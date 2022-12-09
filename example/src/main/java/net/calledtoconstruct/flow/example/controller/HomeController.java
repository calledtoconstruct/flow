package net.calledtoconstruct.flow.example.controller;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Tuple1;
import net.calledtoconstruct.Tuple2;
import net.calledtoconstruct.Tuple3;
import net.calledtoconstruct.Tuple4;
import net.calledtoconstruct.UnexpectedNeitherException;
import net.calledtoconstruct.flow.example.service.DataService;

@Controller
public class HomeController {

    private final static Tuple1<String> TITLE = new Tuple1<>("Flow Sample Application");

    private final DataService dataService;

    public HomeController(final DataService dataService) {
        this.dataService = dataService;
    }

    private void populateModel(
        final Model model,
        final Tuple3<String, Date, Tuple2<List<String>, Long>> data
    ) {
        model.addAttribute("title", data.getFirst());
        model.addAttribute("date", data.getSecond());
        final var rowsAndCount = data.getThird();
        model.addAttribute("rows", rowsAndCount.getFirst());
        model.addAttribute("count", rowsAndCount.getSecond());
    }
    
    @GetMapping("/")
    public String get(Model model) {
        try {
            final var dataFuture = CompletableFuture.supplyAsync(dataService::get);
            final var countFuture = CompletableFuture.supplyAsync(dataService::count);
            final var instant = Instant.now();
            final var titleAndDate = TITLE
                .push(Date.from(instant));
            final var result = dataFuture.get()
                .mergeFailRight(
                    countFuture.get(),
                    (data, count) -> new Tuple2<>(data, count),
                    (dataError, countError) -> dataError,
                    (countError) -> countError,
                    (dataError) -> dataError
                )
                .onLeftApply(rows -> titleAndDate.push(rows))
                .onLeftAccept(titleDateRowsAndCount -> populateModel(model, titleDateRowsAndCount))
                .onLeftSupply(() -> "index")
                .onRightAccept(message -> model.addAttribute("message", message))
                .onRightSupply(() -> "error");
            return Either.coalesce(result, "unexpected");
        } catch (final InterruptedException | ExecutionException | UnexpectedNeitherException exception) {
            return "error";
        }
    }
    
}

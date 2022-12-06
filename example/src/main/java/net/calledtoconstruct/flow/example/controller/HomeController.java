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
import net.calledtoconstruct.Left;
import net.calledtoconstruct.Right;
import net.calledtoconstruct.Tuple1;
import net.calledtoconstruct.Tuple3;
import net.calledtoconstruct.flow.example.service.DataService;

@Controller
public class HomeController {

    private final static Tuple1<String> TITLE = new Tuple1<>("Flow Sample Application");

    private final DataService dataService;

    public HomeController(final DataService dataService) {
        this.dataService = dataService;
    }

    private void populateModel(final Model model, final Tuple3<String, Date, List<String>> data) {
        model.addAttribute("title", data.getFirst());
        model.addAttribute("date", data.getSecond());
        model.addAttribute("rows", data.getThird());
    }

    private String getPageName(final Either<String, String> result) {
        if (result instanceof Left<String, String> left) {
            return left.getValue();
        } else if (result instanceof Right<String, String> right) {
            return right.getValue();
        } else {
            return "unexpected";
        }
    }
    
    @GetMapping("/")
    public String get(Model model) {
        try {
            final var future = CompletableFuture.supplyAsync(dataService::get);
            final var instant = Instant.parse("2022-01-10T10:14:55Z");
            final var titleAndDate = TITLE
                .push(Date.from(instant));
            final var result = future.get()
                .onLeftApply(rows -> titleAndDate.push(rows))
                .onLeftAccept(titleDateAndRows -> populateModel(model, titleDateAndRows))
                .onLeftSupply(() -> "index")
                .onRightAccept(message -> model.addAttribute("message", message))
                .onRightSupply(() -> "error");
            return getPageName(result);
        } catch (final InterruptedException | ExecutionException exception) {
            return "error";
        }
    }
    
}

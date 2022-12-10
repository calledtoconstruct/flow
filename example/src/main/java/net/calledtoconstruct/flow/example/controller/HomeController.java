package net.calledtoconstruct.flow.example.controller;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;
import net.calledtoconstruct.Right;
import net.calledtoconstruct.Tuple1;
import net.calledtoconstruct.Tuple2;
import net.calledtoconstruct.Tuple3;
import net.calledtoconstruct.flow.example.service.DataService;
import net.calledtoconstruct.flow.example.service.LongRunningFunctions;

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
                .mergeFailToRight(
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
            return Either.coalesce(result);
        } catch (final InterruptedException | ExecutionException exception) {
            return "error";
        }
    }

    @GetMapping("/lrf")
    public String executeLongRunningFunctions(Model model) throws InterruptedException, ExecutionException {
        final var log = new ConcurrentLinkedQueue<>();

        final var first = CompletableFuture.supplyAsync(
            () -> LongRunningFunctions.longRunningFunction(20)
                .onLeftAccept(number -> log.add(String.format("Received number: %d", number)))
                .onRightAccept(exception -> log.add("An exception occurred while attempting to sleep for 20."))
        );
        
        final var second = CompletableFuture.supplyAsync(
            () -> LongRunningFunctions.longRunningFunction(30)
                .onLeftAccept(number -> log.add(String.format("Received number: %d", number)))
                .onLeftApply(number -> number * 2)
                .onLeftAccept(number -> log.add(String.format("Received number: %d", number)))
        );
        
        final var third = CompletableFuture.supplyAsync(
            () -> LongRunningFunctions.longRunningFunction(10)
                .onLeftAccept(number -> log.add(String.format("Received number: %d", number)))
        );

        log.add("Waiting...");

        CompletableFuture.allOf(first, second, third).get();
        
        log.add("The future is now");

        final var firstResult = first.get();
        final var secondResult = second.get();
        final var thirdResult = third.get();

        Left.acceptAll(
            numbers -> log.add(numbers.toString()),
            secondResult,
            thirdResult
        );

        try {
            final var exception = Right.any(firstResult, secondResult, thirdResult);
            if (exception.isPresent()) {
                throw exception.get();
            }
        } catch (InterruptedException exception) {
            log.add("Caught interrupted exception");
        } finally {
            log.add("Concluded");
        }

        model.addAttribute("messages", log.toArray());

        return "lrf";
    }
    
}

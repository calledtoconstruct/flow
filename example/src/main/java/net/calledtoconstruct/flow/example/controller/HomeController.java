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
import net.calledtoconstruct.flow.example.service.DataService;

@Controller
public class HomeController {

    private final class PageName {
        public static final String INDEX = "index";
        public static final String ERROR = "error";
    }

    private final class AttributeName {
        public static final String MESSAGE = "message";
        private static final String TITLE = "title";
        private static final String DATE = "date";
        private static final String ROWS = "rows";
        private static final String COUNT = "count";
    }

    private static final Tuple1<String> TITLE = new Tuple1<>("Flow Sample Application");

    private final DataService dataService;

    public HomeController(final DataService dataService) {
        this.dataService = dataService;
    }

    private void populateModel(
        final Model model,
        final Tuple3<String, Date, Tuple2<List<String>, Long>> data
    ) {
        final var rowsAndCount = data.getThird();
        model.addAttribute(AttributeName.TITLE, data.getFirst());
        model.addAttribute(AttributeName.DATE, data.getSecond());
        model.addAttribute(AttributeName.ROWS, rowsAndCount.getFirst());
        model.addAttribute(AttributeName.COUNT, rowsAndCount.getSecond());
    }
    
    @GetMapping("/")
    public String get(Model model) throws InterruptedException {
        try {
            final var dataFuture = CompletableFuture.supplyAsync(dataService::get);
            final var countFuture = CompletableFuture.supplyAsync(dataService::count);

            final var instantNow = Instant.now();
            final var currentDateAndTime = Date.from(instantNow);
            final var titleAndDate = TITLE.push(currentDateAndTime);

            final var result = dataFuture.get()
                .mergeFailToRight(
                    countFuture.get(),
                    Tuple2::new,
                    (dataError, countError) -> dataError,
                    countError -> countError,
                    dataError -> dataError
                )
                .onLeftApply(titleAndDate::push)
                .onLeftAccept(titleDateRowsAndCount -> populateModel(model, titleDateRowsAndCount))
                .onLeftSupply(() -> PageName.INDEX)
                .onRightAccept(message -> model.addAttribute(AttributeName.MESSAGE, message))
                .onRightSupply(() -> PageName.ERROR);
            return Either.coalesce(result);
        } catch (final ExecutionException exception) {
            return PageName.ERROR;
        }
    }
    
}

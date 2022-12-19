package net.calledtoconstruct.flow.example.controller;

import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Right;
import net.calledtoconstruct.Tuple1;
import net.calledtoconstruct.Tuple3;
import net.calledtoconstruct.flow.example.entity.FlowData;
import net.calledtoconstruct.flow.example.service.DataService;

@Controller
public class FlatMapAndFlipController {
    
    private final class PageName {
        public static final String FMAF = "fmaf";
    }

    private final class AttributeName {
        public static final String TITLE = "title";
        public static final String DATE = "date";
        public static final String ROW = "row";
    }

    private static final Tuple1<String> TITLE = new Tuple1<>("Flow Sample Application");
    
    private final DataService dataService;

    public FlatMapAndFlipController(final DataService dataService) {
        this.dataService = dataService;
    }

    private void populateModel(
        final Model model,
        final Tuple3<String, Date, FlowData> data
    ) {
        model.addAttribute(AttributeName.TITLE, data.getFirst());
        model.addAttribute(AttributeName.DATE, data.getSecond());
        model.addAttribute(AttributeName.ROW, data.getThird());
    }

    @GetMapping("/" + PageName.FMAF)
    public String getUsingFlatMapAndFlip(final Model model) {
        final var instantNow = Instant.now();
        final var currentDateAndTime = Date.from(instantNow);
        final var titleAndDate = TITLE.push(currentDateAndTime);
        final var result = new Right<String, Integer>(1)
            .flip()
            .<FlowData>onLeftFlatMap(dataService::getById, dataService::createPlaceholder)
            .onLeftApply(titleAndDate::push)
            .onLeftAccept(titleDateAndFlowData -> populateModel(model, titleDateAndFlowData))
            .onLeftSupply(() -> PageName.FMAF);
        return Either.coalesce(result);
    }

}

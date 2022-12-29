package net.calledtoconstruct.flow.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Tuple3;
import net.calledtoconstruct.flow.example.entity.FlowData;
import net.calledtoconstruct.flow.example.service.DataService;

@Controller
@RequestMapping("/timed")
public class TimedController {

    private final class PageName {
        public static final String TIMED = "timed";
        public static final String ERROR = "error";
    }
    
    private final class AttributeName {
        public static final String MESSAGE = "message";
        private static final String TITLE = "title";
        private static final String ROWS = "rows";
        private static final String COUNT = "count";
        private static final String DURATION = "duration";
    }

    private final DataService dataService;

    public TimedController(final DataService dataService) {
        this.dataService = dataService;
    }

    private void populateTimedModel(final Model model, Tuple3<List<FlowData>, Long, Long> dataCountAndDuration) {
        model.addAttribute(AttributeName.TITLE, "Get Timed");
        model.addAttribute(AttributeName.ROWS, dataCountAndDuration.getFirst());
        model.addAttribute(AttributeName.COUNT, dataCountAndDuration.getSecond());
        model.addAttribute(AttributeName.DURATION, dataCountAndDuration.getThird());
    }
    
    @GetMapping(path = {"", "/"})
    public String getTimed(Model model) {
        final var result = dataService.getDataAndCountTimed()
            .onLeftAccept(dataCountAndDuration -> populateTimedModel(model, dataCountAndDuration))
            .onLeftSupply(() -> PageName.TIMED)
            .onRightAccept(message -> model.addAttribute(AttributeName.MESSAGE, message))
            .onRightSupply(() -> PageName.ERROR);
        return Either.coalesce(result);
    }

}

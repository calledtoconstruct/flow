package net.calledtoconstruct.flow.example.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.calledtoconstruct.Left;
import net.calledtoconstruct.Right;
import net.calledtoconstruct.flow.example.service.LongRunningFunctions;

@RequestMapping("lrf")
public class LongRunningFunctionController {

    private final class PageName {
        public static final String LONG_RUNNING_FUNCTION = "lrf";
    }

    private final class AttributeName {
        private static final String TITLE = "title";
        private static final String MESSAGES = "messages";
    }

    private static final String LOG_NUMBER_RECEIVED_FORMAT = "Received number: %d";

    @GetMapping("/")
    public String executeLongRunningFunctions(final Model model) throws InterruptedException, ExecutionException {
        model.addAttribute(AttributeName.TITLE, "Long Running Functions");

        final var log = new ConcurrentLinkedQueue<>();

        final var first = CompletableFuture.supplyAsync(
            () -> LongRunningFunctions.longRunningFunction(20)
                .onLeftAccept(number -> log.add(String.format(LOG_NUMBER_RECEIVED_FORMAT, number)))
                .onRightAccept(exception -> log.add("An exception occurred while attempting to sleep for 20."))
        );
        
        final var second = CompletableFuture.supplyAsync(
            () -> LongRunningFunctions.longRunningFunction(30)
                .onLeftAccept(number -> log.add(String.format(LOG_NUMBER_RECEIVED_FORMAT, number)))
                .onLeftApply(number -> number * 2)
                .onLeftAccept(number -> log.add(String.format(LOG_NUMBER_RECEIVED_FORMAT, number)))
        );
        
        final var third = CompletableFuture.supplyAsync(
            () -> LongRunningFunctions.longRunningFunction(10)
                .onLeftAccept(number -> log.add(String.format(LOG_NUMBER_RECEIVED_FORMAT, number)))
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
        } catch (final InterruptedException exception) {
            log.add("Caught interrupted exception");
        } finally {
            log.add("Concluded");
        }

        model.addAttribute(AttributeName.MESSAGES, log.toArray());

        return PageName.LONG_RUNNING_FUNCTION;
    }
    
}

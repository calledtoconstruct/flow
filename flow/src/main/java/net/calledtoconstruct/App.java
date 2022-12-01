package net.calledtoconstruct;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App 
{
    public static void main( String[] args ) throws InterruptedException, ExecutionException
    {
        final var first = CompletableFuture.supplyAsync(
            () -> longRunningFunction(20)
                .onLeftAccept(number -> System.out.println(number))
                .onRightAccept(exception -> System.out.println("I knew this would happen"))
        );
        
        final var second = CompletableFuture.supplyAsync(
            () -> longRunningFunction(30)
                .onLeftAccept(number -> System.out.println(number))
                .onLeftApply(number -> number * 2)
                .onLeftAccept(number -> System.out.println(number))
        );
        
        final var third = CompletableFuture.supplyAsync(
            () -> longRunningFunction(10)
                .onLeftAccept(number -> System.out.println(number))
        );

        System.out.println("Waiting...");

        CompletableFuture.allOf(first, second, third).get();
        
        System.out.println("The future is now");

        final var firstResult = first.get();
        final var secondResult = second.get();
        final var thirdResult = third.get();

        Left.acceptAll(
            numbers -> System.out.println(numbers.toString()),
            secondResult,
            thirdResult
        );

        try {
            final var exception = Right.any(firstResult, secondResult, thirdResult);
            if (exception.isPresent()) {
                throw exception.get();
            }
        } catch (InterruptedException exception) {
            System.out.println("Caught interrupted exception");
            throw exception;
        } finally {
            System.out.println("Concluded");
        }
    }

    private static Either<Integer, InterruptedException> longRunningFunction(Integer sleep) {
        try {
            if (sleep != 20) {
                Thread.sleep(sleep);
            } else {    
                throw new InterruptedException();
            }
        } catch (InterruptedException interruptedException) {
            return new Right<>(interruptedException);
        }
        return new Left<>(sleep * 10);
    }
}

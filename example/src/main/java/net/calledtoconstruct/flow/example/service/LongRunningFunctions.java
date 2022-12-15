package net.calledtoconstruct.flow.example.service;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;
import net.calledtoconstruct.Right;

public class LongRunningFunctions {

    private LongRunningFunctions() {}

    public static Either<Integer, InterruptedException> longRunningFunction(Integer sleep) {
        try {
            if (sleep != 20) {
                Thread.sleep(sleep);
            } else {    
                throw new InterruptedException();
            }
        } catch (final InterruptedException interruptedException) {
            return new Right<>(interruptedException);
        }
        return new Left<>(sleep * 10);
    }

}

package net.calledtoconstruct.givenleftandleft;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;
import net.calledtoconstruct.Right;

class WhenInvokingAcceptAllTest {

    private final static Random RANDOM = new Random();
    private static final int FIRST = RANDOM.nextInt();
    private static final int SECOND = RANDOM.nextInt();

    private final Either<Integer, String> first = new Left<Integer, String>(FIRST);
    private final Either<Integer, String> second = new Left<Integer, String>(SECOND);

    private boolean acceptLeftWasCalled = false;
    private boolean acceptRightWasCalled = false;

    private void acceptLeft(final List<Integer> values) {
        acceptLeftWasCalled = true;
    }

    private void acceptRight(final List<String> values) {
        acceptRightWasCalled = true;
    }

    private boolean leftResult;
    private boolean rightResult;
    
    @BeforeEach
    void invokeAcceptAll() {
        leftResult = Left.acceptAll(this::acceptLeft, first, second);
        rightResult = Right.acceptAll(this::acceptRight, first, second);
    }

    @Test
    void thenLeftResultIsTrue() {
        Assertions.assertTrue(leftResult);
    }

    @Test
    void thenRightResultIsFalse() {
        Assertions.assertFalse(rightResult);
    }

    @Test
    void thenAcceptLeftWasCalled() {
        Assertions.assertTrue(acceptLeftWasCalled);
    }

    @Test
    void thenAcceptRightWasNotCalled() {
        Assertions.assertFalse(acceptRightWasCalled);
    }

}

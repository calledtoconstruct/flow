package net.calledtoconstruct.givenleftandright;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;
import net.calledtoconstruct.Right;

public class WhenInvokingAcceptAllTest {

    private final static Random RANDOM = new Random();
    private static final int FIRST = RANDOM.nextInt();
    private static final String SECOND = String.format("%d", RANDOM.nextInt());

    private final Either<Integer, String> first = new Left<Integer, String>(FIRST);
    private final Either<Integer, String> second = new Right<Integer, String>(SECOND);

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
    public void invokeAcceptAll() {
        leftResult = Left.acceptAll(this::acceptLeft, first, second);
        rightResult = Right.acceptAll(this::acceptRight, first, second);
    }

    @Test
    void thenLeftResultIsFalse() {
        Assertions.assertFalse(leftResult);
    }

    @Test
    void thenRightResultIsFalse() {
        Assertions.assertFalse(rightResult);
    }

    @Test
    void thenAcceptLeftWasNotCalled() {
        Assertions.assertFalse(acceptLeftWasCalled);
    }

    @Test
    void thenAcceptRightWasNotCalled() {
        Assertions.assertFalse(acceptRightWasCalled);
    }

}

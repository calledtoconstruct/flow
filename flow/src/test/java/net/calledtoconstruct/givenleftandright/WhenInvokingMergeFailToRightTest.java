package net.calledtoconstruct.givenleftandright;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;
import net.calledtoconstruct.Right;

class WhenInvokingMergeFailToRightTest {

    private final static Random random = new Random();
    private final static long LEFT_VALUE = random.nextLong();
    private final static boolean RIGHT_VALUE = random.nextBoolean();
    private final static String OUTPUT = String.format("%d", random.nextLong());

    private final Left<Long, Integer> left = new Left<>(LEFT_VALUE);
    private final Right<String, Boolean> right = new Right<>(RIGHT_VALUE); 

    private Either<String, String> result;

    private boolean functionMergeLeftWasCalled = false;
    private boolean functionMergeRightWasCalled = false;
    private boolean transformThisWasCalled = false;
    private boolean transformOtherWasCalled = false;

    private String functionMergeLeft(final Long first, final String second) {
        functionMergeLeftWasCalled = true;
        return new String();
    }

    private String functionMergeRight(final Integer first, final Boolean second) {
        functionMergeRightWasCalled = true;
        return new String();
    }

    private String transformThis(final Integer first) {
        transformThisWasCalled = true;
        return new String();
    }

    private String transformOther(final Boolean first) {
        transformOtherWasCalled = true;
        return OUTPUT;
    }
    
    @BeforeEach
    void invokeMergeFailToRight() {
        result = left.mergeFailToRight(
            right,
            this::functionMergeLeft,
            this::functionMergeRight,
            this::transformThis,
            this::transformOther
        );
    }

    @Test
    void thenFunctionMergeLeftWasNotCalled() {
        Assertions.assertFalse(functionMergeLeftWasCalled);
    }

    @Test
    void thenFunctionMergeRightWasNotCalled() {
        Assertions.assertFalse(functionMergeRightWasCalled);
    }

    @Test
    void thenTransformThisWasNotCalled() {
        Assertions.assertFalse(transformThisWasCalled);
    }

    @Test
    void thenTransformOtherWasCalled() {
        Assertions.assertTrue(transformOtherWasCalled);
    }

    @Test
    void thenResultIsInstanceOfRight() {
        Assertions.assertInstanceOf(Right.class, result);
    }

    @Test
    void thenGetProducesCorrectValue() {
        if (result instanceof Right<String, String> right) {
            final var value = right.getValue();
            Assertions.assertEquals(OUTPUT, value);
        }
    }
}

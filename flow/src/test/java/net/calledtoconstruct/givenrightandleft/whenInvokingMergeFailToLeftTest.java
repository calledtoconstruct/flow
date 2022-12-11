package net.calledtoconstruct.givenrightandleft;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;
import net.calledtoconstruct.Right;

public class whenInvokingMergeFailToLeftTest {

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

    private String functionMergeLeft(final String first, final Long second) {
        functionMergeLeftWasCalled = true;
        return new String();
    }

    private String functionMergeRight(final Boolean first, final Integer second) {
        functionMergeRightWasCalled = true;
        return new String();
    }

    private String transformThis(final String first) {
        transformThisWasCalled = true;
        return new String();
    }

    private String transformOther(final Long first) {
        transformOtherWasCalled = true;
        return OUTPUT;
    }
    
    @BeforeEach
    public void invokeMergeFailToLeft() {
        result = right.mergeFailToLeft(
            left,
            this::functionMergeLeft,
            this::functionMergeRight,
            this::transformThis,
            this::transformOther
        );
    }

    @Test
    public void thenFunctionMergeLeftWasNotCalled() {
        Assertions.assertFalse(functionMergeLeftWasCalled);
    }

    @Test
    public void thenFunctionMergeRightWasNotCalled() {
        Assertions.assertFalse(functionMergeRightWasCalled);
    }

    @Test
    public void thenTransformThisWasNotCalled() {
        Assertions.assertFalse(transformThisWasCalled);
    }

    @Test
    public void thenTransformOtherWasCalled() {
        Assertions.assertTrue(transformOtherWasCalled);
    }

    @Test
    public void thenResultIsInstanceOfLeft() {
        Assertions.assertInstanceOf(Left.class, result);
    }

    @Test
    public void thenGetProducesCorrectValue() {
        if (result instanceof Left<String, String> left) {
            final var value = left.getValue();
            Assertions.assertEquals(OUTPUT, value);
        }
    }
}

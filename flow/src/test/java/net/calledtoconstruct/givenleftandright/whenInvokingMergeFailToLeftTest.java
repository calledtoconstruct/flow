package net.calledtoconstruct.givenleftandright;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;
import net.calledtoconstruct.Right;

public class WhenInvokingMergeFailToLeftTest {

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

    private String transformThis(final Long first) {
        transformThisWasCalled = true;
        return OUTPUT;
    }

    private String transformOther(final String first) {
        transformOtherWasCalled = true;
        return new String();
    }
    
    @BeforeEach
    public void invokeMergeFailToLeft() {
        result = left.mergeFailToLeft(
            right,
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
    public void thenTransformThisWasCalled() {
        Assertions.assertTrue(transformThisWasCalled);
    }

    @Test
    public void thenTransformOtherWasNotCalled() {
        Assertions.assertFalse(transformOtherWasCalled);
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

package net.calledtoconstruct.givenrightandright;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Right;

class WhenInvokingMergeFailToLeftTest {

    private final static Random random = new Random();
    private final static long LEFT_VALUE = random.nextLong();
    private final static boolean OTHER_LEFT_VALUE = random.nextBoolean();
    private final static String OUTPUT = String.format("%d", random.nextLong());

    private final Either<Integer, Long> right = new Right<>(LEFT_VALUE);
    private final Either<String, Boolean> other = new Right<>(OTHER_LEFT_VALUE); 

    private Either<String, String> result;

    private boolean functionMergeLeftWasCalled = false;
    private boolean functionMergeRightWasCalled = false;
    private boolean transformThisWasCalled = false;
    private boolean transformOtherWasCalled = false;

    private String functionMergeLeft(final Integer first, final String second) {
        functionMergeLeftWasCalled = true;
        return new String();
    }

    private String functionMergeRight(final Long first, final Boolean second) {
        functionMergeRightWasCalled = true;
        return OUTPUT;
    }

    private String transformThis(final Integer first) {
        transformThisWasCalled = true;
        return new String();
    }

    private String transformOther(final String first) {
        transformOtherWasCalled = true;
        return new String();
    }
    
    @BeforeEach
    void invokeMergeFailToRight() {
        result = right.mergeFailToLeft(
            other,
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
    void thenFunctionMergeRightWasCalled() {
        Assertions.assertTrue(functionMergeRightWasCalled);
    }

    @Test
    void thenTransformThisWasNotCalled() {
        Assertions.assertFalse(transformThisWasCalled);
    }

    @Test
    void thenTransformOtherWasNotCalled() {
        Assertions.assertFalse(transformOtherWasCalled);
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

package net.calledtoconstruct.givenleft;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;

class WhenInvokingOnRightSupplyTest {

    private static final Random RANDOM = new Random();
    private static final int INPUT = RANDOM.nextInt();
    private static final String SUPPLIED = String.format("%d", RANDOM.nextLong());

    private final Either<Integer, Boolean> systemUnderTest = new Left<>(INPUT);

    private Either<Integer, String> onRightSupplyResult;
    private boolean onRightSupplyWasCalled = false;

    private String onRightSupply() {
        onRightSupplyWasCalled = true;
        return SUPPLIED;
    }

    @BeforeEach
    void invokeOnRightSupply() {
        onRightSupplyResult = systemUnderTest.onRightSupply(this::onRightSupply);
    }

    @Test
    void thenOnRightSupplyWasNotCalled() {
        Assertions.assertFalse(onRightSupplyWasCalled);
    }

    @Test
    void thenResultIsInstanceOfLeft() {
        Assertions.assertInstanceOf(Left.class, onRightSupplyResult);
    }

    @Test
    void thenGetReturnsSuppliedValue() {
        if (onRightSupplyResult instanceof final Left<Integer, String> left) {
            final Integer value = left.getValue();
            Assertions.assertEquals(INPUT, value);
        }
    }
    
}

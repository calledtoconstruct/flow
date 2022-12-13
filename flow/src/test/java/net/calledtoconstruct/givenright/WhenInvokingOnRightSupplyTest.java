package net.calledtoconstruct.givenright;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Right;

public class WhenInvokingOnRightSupplyTest {

    private static final Random RANDOM = new Random();
    private static final int INPUT = RANDOM.nextInt();
    private static final String SUPPLIED = String.format("%d", RANDOM.nextLong());

    private final Either<Boolean, Integer> systemUnderTest = new Right<>(INPUT);

    private Either<Boolean, String> onRightSupplyResult;
    private boolean onRightSupplyWasCalled = false;

    private String onRightSupply() {
        onRightSupplyWasCalled = true;
        return SUPPLIED;
    }

    @BeforeEach
    public void invokeOnRightSupply() {
        onRightSupplyResult = systemUnderTest.onRightSupply(this::onRightSupply);
    }

    @Test
    public void thenOnRightSupplyWasCalled() {
        Assertions.assertTrue(onRightSupplyWasCalled);
    }

    @Test
    public void thenResultIsInstanceOfRight() {
        Assertions.assertTrue(onRightSupplyResult instanceof Right);
    }

    @Test
    public void thenGetReturnsSuppliedValue() {
        if (onRightSupplyResult instanceof final Right<Boolean, String> right) {
            final String value = right.getValue();
            Assertions.assertEquals(SUPPLIED, value);
        }
    }
    
}

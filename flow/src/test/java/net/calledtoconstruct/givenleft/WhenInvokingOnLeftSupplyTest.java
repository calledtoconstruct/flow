package net.calledtoconstruct.givenleft;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;

class WhenInvokingOnLeftSupplyTest {

    private static final Random RANDOM = new Random();
    private static final int INPUT = RANDOM.nextInt();
    private static final int SUPPLIED = RANDOM.nextInt();

    private final Either<Integer, Boolean> systemUnderTest = new Left<>(INPUT);

    private Either<Integer, Boolean> onLeftSupplyResult;
    private boolean onLeftSupplyCalled = false;

    private int onLeftSupply() {
        onLeftSupplyCalled = true;
        return SUPPLIED;
    }

    @BeforeEach
    void invokeOnLeftSupply() {
        onLeftSupplyResult = systemUnderTest.onLeftSupply(this::onLeftSupply);
    }

    @Test
    void thenOnLeftSupplyWasCalled() {
        Assertions.assertTrue(onLeftSupplyCalled);
    }

    @Test
    void thenResultIsInstanceOfLeft() {
        Assertions.assertTrue(onLeftSupplyResult instanceof Left);
    }

    @Test
    void thenGetProducesCorrectValue() {
        if (onLeftSupplyResult instanceof Left<Integer, Boolean> left) {
            Assertions.assertEquals(Integer.valueOf(SUPPLIED), left.getValue());
        }
    }
    
}

package net.calledtoconstruct.givenright;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Right;

public class WhenInvokingOnLeftSupplyTest {

    private static final Random RANDOM = new Random();
    private static final int INPUT = RANDOM.nextInt();
    private static final int SUPPLIED = RANDOM.nextInt();

    private final Either<Boolean, Integer> systemUnderTest = new Right<>(INPUT);

    private Either<Integer, Integer> onLeftSupplyResult;
    private boolean onLeftSupplyCalled = false;

    private int onLeftSupply() {
        onLeftSupplyCalled = true;
        return SUPPLIED;
    }

    @BeforeEach
    public void invokeOnLeftSupply() {
        onLeftSupplyResult = systemUnderTest.onLeftSupply(this::onLeftSupply);
    }

    @Test
    public void thenOnLeftSupplyWasNotCalled() {
        Assertions.assertFalse(onLeftSupplyCalled);
    }

    @Test
    public void thenResultIsInstanceOfRight() {
        Assertions.assertTrue(onLeftSupplyResult instanceof Right);
    }

    @Test
    public void thenGetProducesCorrectValue() {
        if (onLeftSupplyResult instanceof Right<Integer, Integer> right) {
            Assertions.assertEquals(Integer.valueOf(INPUT), right.getValue());
        }
    }
    
}

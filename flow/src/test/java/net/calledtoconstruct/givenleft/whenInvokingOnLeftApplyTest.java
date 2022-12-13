package net.calledtoconstruct.givenleft;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;

public class WhenInvokingOnLeftApplyTest {

    private static final Random RANDOM = new Random();
    private static final int INPUT = RANDOM.nextInt();
    private static final int APPLIED = RANDOM.nextInt();

    private final Either<Integer, Boolean> systemUnderTest = new Left<>(INPUT);

    private Either<Integer, Boolean> onLeftApplyResult;
    private boolean onLeftApplyCalled = false;

    private Integer onLeftApply(final Integer input) {
        onLeftApplyCalled = true;
        return APPLIED;
    }

    @BeforeEach
    public void invokeOnLeftApply() {
        onLeftApplyResult = systemUnderTest.onLeftApply(this::onLeftApply);
    }

    @Test
    public void thenOnLeftApplyWasCalled() {
        Assertions.assertTrue(onLeftApplyCalled);
    }

    @Test
    public void thenResultIsInstanceOfLeft() {
        Assertions.assertTrue(onLeftApplyResult instanceof Left);
    }

    @Test
    public void thenGetProducesCorrectValue() {
        if (onLeftApplyResult instanceof Left<Integer, Boolean> left) {
            Assertions.assertEquals(Integer.valueOf(APPLIED), left.getValue());
        }
    }
    
}

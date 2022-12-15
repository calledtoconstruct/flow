package net.calledtoconstruct.givenleft;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;

class WhenInvokingOnRightApplyTest {

    private static final Random RANDOM = new Random();
    private static final int INPUT = RANDOM.nextInt();
    private static final boolean APPLIED = RANDOM.nextBoolean();

    private final Either<Integer, Boolean> systemUnderTest = new Left<>(INPUT);

    private Either<Integer, Boolean> onRightApplyResult;
    private boolean onRightApplyCalled = false;

    private Boolean onRightApply(final Boolean input) {
        onRightApplyCalled = true;
        return APPLIED;
    }

    @BeforeEach
    void invokeOnRightApply() {
        onRightApplyResult = systemUnderTest.onRightApply(this::onRightApply);
    }

    @Test
    void thenOnRightApplyWasNotCalled() {
        Assertions.assertFalse(onRightApplyCalled);
    }

    @Test
    void thenResultIsInstanceOfLeft() {
        Assertions.assertTrue(onRightApplyResult instanceof Left);
    }

    @Test
    void thenGetProducesCorrectValue() {
        if (onRightApplyResult instanceof Left<Integer, Boolean> left) {
            final var value = left.getValue();
            Assertions.assertEquals(Integer.valueOf(INPUT), value);
        }
    }
    
}

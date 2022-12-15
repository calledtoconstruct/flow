package net.calledtoconstruct.givenright;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Right;

class WhenInvokingOnLeftApplyTest {

    private static final Random RANDOM = new Random();
    private static final int INPUT = RANDOM.nextInt();
    private static final boolean APPLIED = RANDOM.nextBoolean();

    private final Either<Boolean, Integer> systemUnderTest = new Right<>(INPUT);

    private Either<Boolean, Integer> onLeftApplyResult;
    private boolean onLeftApplyCalled = false;

    private Boolean onLeftApply(final Boolean input) {
        onLeftApplyCalled = true;
        return APPLIED;
    }

    @BeforeEach
    void invokeOnLeftApply() {
        onLeftApplyResult = systemUnderTest.onLeftApply(this::onLeftApply);
    }

    @Test
    void thenOnLeftApplyWasNotCalled() {
        Assertions.assertFalse(onLeftApplyCalled);
    }

    @Test
    void thenResultIsInstanceOfRight() {
        Assertions.assertTrue(onLeftApplyResult instanceof Right);
    }

    @Test
    void thenGetProducesCorrectValue() {
        if (onLeftApplyResult instanceof Right<Boolean, Integer> right) {
            final var value = right.getValue();
            Assertions.assertEquals(Integer.valueOf(INPUT), value);
        }
    }
    
}

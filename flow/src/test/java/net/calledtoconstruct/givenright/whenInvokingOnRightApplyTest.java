package net.calledtoconstruct.givenright;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Right;

public class WhenInvokingOnRightApplyTest {

    private static final Random RANDOM = new Random();
    private static final int INPUT = RANDOM.nextInt();
    private static final int APPLIED = RANDOM.nextInt();

    private final Either<Boolean, Integer> systemUnderTest = new Right<>(INPUT);

    private Either<Boolean, Integer> onRightApplyResult;
    private boolean onRightApplyCalled = false;

    private Integer onRightApply(final Integer input) {
        onRightApplyCalled = true;
        return APPLIED;
    }

    @BeforeEach
    public void invokeOnRightApply() {
        onRightApplyResult = systemUnderTest.onRightApply(this::onRightApply);
    }

    @Test
    public void thenOnRightApplyWasCalled() {
        Assertions.assertTrue(onRightApplyCalled);
    }

    @Test
    public void thenResultIsInstanceOfRight() {
        Assertions.assertTrue(onRightApplyResult instanceof Right);
    }

    @Test
    public void thenGetProducesCorrectValue() {
        if (onRightApplyResult instanceof Right<Boolean, Integer> right) {
            final var value = right.getValue();
            Assertions.assertEquals(Integer.valueOf(APPLIED), value);
        }
    }
    
}

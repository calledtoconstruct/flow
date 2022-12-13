package net.calledtoconstruct.givenright;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Right;

public class WhenInvokingOnLeftAcceptTest {

    private static final Random RANDOM = new Random();
    private static final int INPUT = RANDOM.nextInt();

    private final Either<Boolean, Integer> systemUnderTest = new Right<>(INPUT);

    private Either<Boolean, Integer> onLeftAcceptResult;
    private boolean onLeftAcceptCalled = false;

    private void onLeftAccept(final Boolean input) {
        onLeftAcceptCalled = true;
    }

    @BeforeEach
    public void invokeOnLeftAccept() {
        onLeftAcceptResult = systemUnderTest.onLeftAccept(this::onLeftAccept);
    }

    @Test
    public void thenOnLeftAcceptWasNotCalled() {
        Assertions.assertFalse(onLeftAcceptCalled);
    }

    @Test
    public void thenResultIsInstanceOfRight() {
        Assertions.assertTrue(onLeftAcceptResult instanceof Right);
    }

    @Test
    public void thenGetProducesCorrectValue() {
        if (onLeftAcceptResult instanceof Right<Boolean, Integer> right) {
            Assertions.assertEquals(Integer.valueOf(INPUT), right.getValue());
        }
    }
    
}

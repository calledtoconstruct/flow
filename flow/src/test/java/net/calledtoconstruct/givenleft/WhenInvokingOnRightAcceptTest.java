package net.calledtoconstruct.givenleft;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;

public class WhenInvokingOnRightAcceptTest {

    private static final Random RANDOM = new Random();
    private static final int INPUT = RANDOM.nextInt();

    private final Either<Integer, Boolean> systemUnderTest = new Left<>(INPUT);

    private Either<Integer, Boolean> onRightAcceptResult;

    private boolean onRightAcceptWasCalled = false;

    private void onRightAccept(final Boolean input) {
        onRightAcceptWasCalled = true;
    }

    @BeforeEach
    public void invokeOnRightAccept() {
        onRightAcceptResult = systemUnderTest.onRightAccept(this::onRightAccept);
    }

    @Test
    public void thenOnRightAcceptWasNotCalled() {
        Assertions.assertFalse(onRightAcceptWasCalled);
    }

    @Test
    public void thenResultIsInstanceOfLeft() {
        Assertions.assertTrue(onRightAcceptResult instanceof Left);
    }
    
}

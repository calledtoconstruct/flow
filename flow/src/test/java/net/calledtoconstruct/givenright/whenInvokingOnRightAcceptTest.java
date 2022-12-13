package net.calledtoconstruct.givenright;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Right;

public class WhenInvokingOnRightAcceptTest {

    private static final Random RANDOM = new Random();
    private static final int INPUT = RANDOM.nextInt();

    private final Either<Boolean, Integer> systemUnderTest = new Right<>(INPUT);

    private Either<Boolean, Integer> onRightAcceptResult;
    private boolean onRightAcceptWasCalled = false;
    private Integer acceptedValue = null;

    private void onRightAccept(final Integer input) {
        onRightAcceptWasCalled = true;
        acceptedValue = input;
    }

    @BeforeEach
    public void invokeOnRightAccept() {
        onRightAcceptResult = systemUnderTest.onRightAccept(this::onRightAccept);
    }

    @Test
    public void thenOnRightAcceptWasCalled() {
        Assertions.assertTrue(onRightAcceptWasCalled);
    }

    @Test
    public void thenResultIsInstanceOfRight() {
        Assertions.assertTrue(onRightAcceptResult instanceof Right);
    }

    @Test
    public void thenAcceptedValueIsCorrect() {
        Assertions.assertEquals(INPUT, acceptedValue);
    }
    
}

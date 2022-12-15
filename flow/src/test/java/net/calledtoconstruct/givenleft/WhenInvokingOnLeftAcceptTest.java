package net.calledtoconstruct.givenleft;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;

class WhenInvokingOnLeftAcceptTest {

    private static final Random RANDOM = new Random();
    private static final int INPUT = RANDOM.nextInt();

    private final Either<Integer, Boolean> systemUnderTest = new Left<>(INPUT);

    private Either<Integer, Boolean> onLeftAcceptResult;
    private boolean onLeftAcceptCalled = false;
    private Integer acceptedValue = null;

    private void onLeftAccept(final Integer input) {
        onLeftAcceptCalled = true;
        acceptedValue = input;
    }

    @BeforeEach
    void invokeOnLeftAccept() {
        onLeftAcceptResult = systemUnderTest.onLeftAccept(this::onLeftAccept);
    }

    @Test
    void thenOnLeftAcceptWasCalled() {
        Assertions.assertTrue(onLeftAcceptCalled);
    }

    @Test
    void thenResultIsInstanceOfLeft() {
        Assertions.assertTrue(onLeftAcceptResult instanceof Left);
    }

    @Test
    void thenGetProducesCorrectValue() {
        if (onLeftAcceptResult instanceof Left<Integer, Boolean> left) {
            Assertions.assertEquals(Integer.valueOf(INPUT), left.getValue());
        }
    }

    @Test
    void thenAcceptedValueIsCorrect() {
        Assertions.assertEquals(INPUT, acceptedValue);
    }
    
}

package net.calledtoconstruct.givenleft;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;

public class whenInvokingOnLeftAcceptTest {

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
    public void invokeOnLeftAccept() {
        onLeftAcceptResult = systemUnderTest.onLeftAccept(this::onLeftAccept);
    }

    @Test
    public void thenOnLeftAcceptWasCalled() {
        Assertions.assertTrue(onLeftAcceptCalled);
    }

    @Test
    public void thenResultIsInstanceOfLeft() {
        Assertions.assertTrue(onLeftAcceptResult instanceof Left);
    }

    @Test
    public void thenGetProducesCorrectValue() {
        if (onLeftAcceptResult instanceof Left<Integer, Boolean> left) {
            Assertions.assertEquals(Integer.valueOf(INPUT), left.getValue());
        }
    }

    @Test
    public void thenAcceptedValueIsCorrect() {
        Assertions.assertEquals(INPUT, acceptedValue);
    }
    
}

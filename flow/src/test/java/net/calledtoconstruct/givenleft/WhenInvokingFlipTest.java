package net.calledtoconstruct.givenleft;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;
import net.calledtoconstruct.Right;

public class WhenInvokingFlipTest {

    private static final Random RANDOM = new Random();
    private static final int INPUT = RANDOM.nextInt();

    private final Either<Integer, Long> systemUnderTest = new Left<Integer, Long>(INPUT);
    
    private Either<Long, Integer> result;

    @BeforeEach
    void invokeFlip() {
        result = systemUnderTest.flip();
    }
    
    @Test
    void thenResultIsInstanceOfRight() {
        Assertions.assertInstanceOf(Right.class, result);
    }

    @Test
    void thenResultHasCorrectValue() {
        if (result instanceof Right<Long, Integer> right) {
            Assertions.assertEquals(INPUT, right.getValue());
        }
    }

}

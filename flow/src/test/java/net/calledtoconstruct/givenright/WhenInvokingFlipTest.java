package net.calledtoconstruct.givenright;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;
import net.calledtoconstruct.Right;

public class WhenInvokingFlipTest {
    
    private static final Random RANDOM = new Random();
    private static final long INPUT = RANDOM.nextLong();

    private final Either<Integer, Long> systemUnderTest = new Right<Integer, Long>(INPUT);
    
    private Either<Long, Integer> result;

    @BeforeEach
    void invokeFlip() {
        result = systemUnderTest.flip();
    }
    
    @Test
    void thenResultIsInstanceOfLeft() {
        Assertions.assertInstanceOf(Left.class, result);
    }

    @Test
    void thenResultHasCorrectValue() {
        if (result instanceof Left<Long, Integer> left) {
            Assertions.assertEquals(INPUT, left.getValue());
        }
    }

}

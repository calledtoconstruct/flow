package net.calledtoconstruct.givenleft;

import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;
import net.calledtoconstruct.Right;

public class WhenInvokingRightAnyTest {

    private final static Random RANDOM = new Random();
    private final static long INPUT = RANDOM.nextLong();

    private final Either<Long, Integer> systemUnderTest = new Left<>(INPUT);

    private Optional<Integer> result;
    
    @BeforeEach
    public void invokeAny() {
        result = Right.any(systemUnderTest);
    }

    @Test
    public void thenResultIsEmpty() {
        Assertions.assertTrue(result.isEmpty());
    }
    
}

package net.calledtoconstruct.givenleft;

import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;

public class WhenInvokingLeftAnyTest {

    private final static Random RANDOM = new Random();
    private final static long INPUT = RANDOM.nextLong();

    private final Either<Long, Integer> systemUnderTest = new Left<>(INPUT);

    private Optional<Long> result;
    
    @BeforeEach
    public void invokeAny() {
        result = Left.any(systemUnderTest);
    }

    @Test
    public void thenResultIsPresent() {
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    public void thenResultIsCorrect() {
        if (result.isPresent()) {
            Assertions.assertEquals(INPUT, result.get());
        }
    }
}

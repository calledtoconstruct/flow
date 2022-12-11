package net.calledtoconstruct.givenright;

import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Right;

public class whenInvokingRightAnyTest {

    private final static Random RANDOM = new Random();
    private final static long INPUT = RANDOM.nextLong();

    private final Either<Integer, Long> systemUnderTest = new Right<>(INPUT);

    private Optional<Long> result;
    
    @BeforeEach
    public void invokeAny() {
        result = Right.any(systemUnderTest);
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

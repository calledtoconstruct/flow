package net.calledtoconstruct.givenright;

import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;
import net.calledtoconstruct.Right;

class WhenInvokingLeftAnyTest {

    private final static Random RANDOM = new Random();
    private final static long INPUT = RANDOM.nextLong();

    private final Either<Integer, Long> systemUnderTest = new Right<>(INPUT);

    private Optional<Integer> result;
    
    @BeforeEach
    void invokeAny() {
        result = Left.any(systemUnderTest);
    }

    @Test
    void thenResultIsEmpty() {
        Assertions.assertTrue(result.isEmpty());
    }
    
}

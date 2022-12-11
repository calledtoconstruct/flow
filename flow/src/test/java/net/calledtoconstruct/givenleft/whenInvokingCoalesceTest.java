package net.calledtoconstruct.givenleft;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;

public class whenInvokingCoalesceTest {

    private static final Random RANDOM = new Random();
    private static final int INPUT = RANDOM.nextInt();

    private final Either<Integer, Integer> systemUnderTest = new Left<>(INPUT);

    private Integer result;
    
    @BeforeEach
    public void invokeCoalesce() {
        result = Either.coalesce(systemUnderTest);
    }

    @Test
    public void thenResultIsCorrect() {
        Assertions.assertEquals(INPUT, result);
    }
}

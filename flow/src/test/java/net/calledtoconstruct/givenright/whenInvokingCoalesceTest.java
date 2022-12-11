package net.calledtoconstruct.givenright;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Right;

public class whenInvokingCoalesceTest {

    private static final Random RANDOM = new Random();
    private static final int INPUT = RANDOM.nextInt();

    private final Either<Integer, Integer> systemUnderTest = new Right<>(INPUT);

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

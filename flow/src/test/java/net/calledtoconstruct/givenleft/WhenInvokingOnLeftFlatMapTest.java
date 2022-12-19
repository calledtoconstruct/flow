package net.calledtoconstruct.givenleft;

import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Left;

public class WhenInvokingOnLeftFlatMapTest {
    
    private static final Random RANDOM = new Random();
    private static final String VALUE = String.format("%d", RANDOM.nextInt());
    private static final int MAPPED = RANDOM.nextInt();
    private static final int OR_ELSE = RANDOM.nextInt();

    private final Either<String, Integer> systemUnderTest = new Left<>(VALUE);

    private final Either<Integer, Integer> mappedResult = systemUnderTest.onLeftFlatMap(
        value -> Optional.of(MAPPED),
        value -> OR_ELSE
    );

    private final Either<Integer, Integer> orElseResult = systemUnderTest.onLeftFlatMap(
        value -> Optional.empty(),
        value -> OR_ELSE
    );

    @Test
    void thatMappedResultIsLeft() {
        Assertions.assertInstanceOf(Left.class, mappedResult);
    }

    @Test
    void thatMappedResultHasCorrectValue() {
        if (mappedResult instanceof Left<Integer, Integer> left) {
            Assertions.assertEquals(MAPPED, left.getValue());
        }
    }

    @Test
    void thatOrElseResultIsLeft() {
        Assertions.assertInstanceOf(Left.class, orElseResult);
    }

    @Test
    void thatOrElseResultHasCorrectValue() {
        if (orElseResult instanceof Left<Integer, Integer> left) {
            Assertions.assertEquals(OR_ELSE, left.getValue());
        }
    }
}

package net.calledtoconstruct.givenright;

import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Either;
import net.calledtoconstruct.Right;

public class WhenInvokingOnRightFlatMapTest {
    
    private static final Random RANDOM = new Random();
    private static final String VALUE = String.format("%d", RANDOM.nextInt());
    private static final int MAPPED = RANDOM.nextInt();
    private static final int OR_ELSE = RANDOM.nextInt();

    private final Either<Integer, String> systemUnderTest = new Right<>(VALUE);

    private final Either<Integer, Integer> mappedResult = systemUnderTest.onRightFlatMap(
        value -> Optional.of(MAPPED),
        value -> OR_ELSE
    );

    private final Either<Integer, Integer> orElseResult = systemUnderTest.onRightFlatMap(
        value -> Optional.empty(),
        value -> OR_ELSE
    );

    @Test
    void thatMappedResultIsRight() {
        Assertions.assertInstanceOf(Right.class, mappedResult);
    }

    @Test
    void thatMappedResultHasCorrectValue() {
        if (mappedResult instanceof Right<Integer, Integer> left) {
            Assertions.assertEquals(MAPPED, left.getValue());
        }
    }

    @Test
    void thatOrElseResultIsRight() {
        Assertions.assertInstanceOf(Right.class, orElseResult);
    }

    @Test
    void thatOrElseResultHasCorrectValue() {
        if (orElseResult instanceof Right<Integer, Integer> left) {
            Assertions.assertEquals(OR_ELSE, left.getValue());
        }
    }

}

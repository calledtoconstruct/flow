package net.calledtoconstruct.giventuples;

import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Tuple;
import net.calledtoconstruct.Tuple1;

class WhenTryingToUnshiftValuesTest {
    
    private static final Random RANDOM = new Random();
    private static final String FIRST_INPUT = String.format("%d", RANDOM.nextInt());
    private static final Long SECOND_INPUT = RANDOM.nextLong();
    private static final Double THIRD_INPUT = RANDOM.nextDouble();
    private static final Integer FOURTH_INPUT = RANDOM.nextInt();
    private static final String FIFTH_INPUT = String.format("%d", RANDOM.nextInt());
    private static final Long SIXTH_INPUT = RANDOM.nextLong();
    private static final Double SEVENTH_INPUT = RANDOM.nextDouble();
    private static final Integer EIGHTH_INPUT = RANDOM.nextInt();
    private static final Integer EXTRA_INPUT = RANDOM.nextInt();

    private final Tuple first = new Tuple1<String>(FIRST_INPUT);
    private final Optional<Tuple> second = first.tryUnshift(SECOND_INPUT);
    private final Optional<Tuple> third = second.isPresent() ? second.get().tryUnshift(THIRD_INPUT) : Optional.empty();
    private final Optional<Tuple> fourth = third.isPresent() ? third.get().tryUnshift(FOURTH_INPUT) : Optional.empty();
    private final Optional<Tuple> fifth = fourth.isPresent() ? fourth.get().tryUnshift(FIFTH_INPUT) : Optional.empty();
    private final Optional<Tuple> sixth = fifth.isPresent() ? fifth.get().tryUnshift(SIXTH_INPUT) : Optional.empty();
    private final Optional<Tuple> seventh = sixth.isPresent() ? sixth.get().tryUnshift(SEVENTH_INPUT) : Optional.empty();
    private final Optional<Tuple> eighth = seventh.isPresent() ? seventh.get().tryUnshift(EIGHTH_INPUT) : Optional.empty();
    private final Optional<Tuple> extra = eighth.isPresent() ? eighth.get().tryUnshift(EXTRA_INPUT) : Optional.empty();

    @Test
    void thenSecondIsPresent() {
        Assertions.assertTrue(second.isPresent());
    }

    @Test
    void thenThirdIsPresent() {
        Assertions.assertTrue(third.isPresent());
    }

    @Test
    void thenFourthIsPresent() {
        Assertions.assertTrue(fourth.isPresent());
    }

    @Test
    void thenFifthIsPresent() {
        Assertions.assertTrue(fifth.isPresent());
    }

    @Test
    void thenSixthIsPresent() {
        Assertions.assertTrue(sixth.isPresent());
    }

    @Test
    void thenSeventhIsPresent() {
        Assertions.assertTrue(seventh.isPresent());
    }

    @Test
    void thenEighthIsPresent() {
        Assertions.assertTrue(eighth.isPresent());
    }

    @Test
    void thenExtraIsEmpty() {
        Assertions.assertTrue(extra.isEmpty());
    }
}
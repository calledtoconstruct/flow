package net.calledtoconstruct.giventuples;

import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Tuple;
import net.calledtoconstruct.Tuple8;

class WhenTryingToPopValuesTest {
    
    private static final Random RANDOM = new Random();
    private static final String FIRST_INPUT = String.format("%d", RANDOM.nextInt());
    private static final Long SECOND_INPUT = RANDOM.nextLong();
    private static final Double THIRD_INPUT = RANDOM.nextDouble();
    private static final Integer FOURTH_INPUT = RANDOM.nextInt();
    private static final String FIFTH_INPUT = String.format("%d", RANDOM.nextInt());
    private static final Long SIXTH_INPUT = RANDOM.nextLong();
    private static final Double SEVENTH_INPUT = RANDOM.nextDouble();
    private static final Integer EIGHTH_INPUT = RANDOM.nextInt();

    private final Tuple first = new Tuple8<String, Long, Double, Integer, String, Long, Double, Integer>(
        FIRST_INPUT,
        SECOND_INPUT,
        THIRD_INPUT,
        FOURTH_INPUT,
        FIFTH_INPUT,
        SIXTH_INPUT,
        SEVENTH_INPUT,
        EIGHTH_INPUT
    );

    private final Optional<Tuple> second = first.tryPop();
    private final Optional<Tuple> third = second.isPresent() ? second.get().tryPop() : Optional.empty();
    private final Optional<Tuple> fourth = third.isPresent() ? third.get().tryPop() : Optional.empty();
    private final Optional<Tuple> fifth = fourth.isPresent() ? fourth.get().tryPop() : Optional.empty();
    private final Optional<Tuple> sixth = fifth.isPresent() ? fifth.get().tryPop() : Optional.empty();
    private final Optional<Tuple> seventh = sixth.isPresent() ? sixth.get().tryPop() : Optional.empty();
    private final Optional<Tuple> eighth = seventh.isPresent() ? seventh.get().tryPop() : Optional.empty();
    private final Optional<Tuple> extra = eighth.isPresent() ? eighth.get().tryPop() : Optional.empty();

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
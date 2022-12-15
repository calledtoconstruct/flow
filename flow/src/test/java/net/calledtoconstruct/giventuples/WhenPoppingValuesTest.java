package net.calledtoconstruct.giventuples;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Tuple1;
import net.calledtoconstruct.Tuple8;

public class WhenPoppingValuesTest {

    private static final Random RANDOM = new Random();
    private static final String FIRST_INPUT = String.format("%d", RANDOM.nextInt());
    private static final Long SECOND_INPUT = RANDOM.nextLong();
    private static final Double THIRD_INPUT = RANDOM.nextDouble();
    private static final Integer FOURTH_INPUT = RANDOM.nextInt();
    private static final String FIFTH_INPUT = String.format("%d", RANDOM.nextInt());
    private static final Long SIXTH_INPUT = RANDOM.nextLong();
    private static final Double SEVENTH_INPUT = RANDOM.nextDouble();
    private static final Integer EIGHTH_INPUT = RANDOM.nextInt();

    private final Tuple1<String> systemUnderTest = new Tuple8<String, Long, Double, Integer, String, Long, Double, Integer>(
        FIRST_INPUT,
        SECOND_INPUT,
        THIRD_INPUT,
        FOURTH_INPUT,
        FIFTH_INPUT,
        SIXTH_INPUT,
        SEVENTH_INPUT,
        EIGHTH_INPUT
    )
        .pop()
        .pop()
        .pop()
        .pop()
        .pop()
        .pop()
        .pop();
    
    @Test
    public void thenResultIsCorrect() {
        Assertions.assertEquals(FIRST_INPUT, systemUnderTest.getFirst());
    }
}

package net.calledtoconstruct.giventuples;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Tuple1;
import net.calledtoconstruct.Tuple8;

class WhenPushingValuesTest {
    
    private static final Random RANDOM = new Random();
    private static final int FIRST_INPUT = RANDOM.nextInt();
    private static final String SECOND_INPUT = String.format("%d", RANDOM.nextInt());
    private static final long THIRD_INPUT = RANDOM.nextLong();
    private static final double FOURTH_INPUT = RANDOM.nextDouble();
    private static final int FIFTH_INPUT = RANDOM.nextInt();
    private static final String SIXTH_INPUT = String.format("%d", RANDOM.nextInt());
    private static final long SEVENTH_INPUT = RANDOM.nextLong();
    private static final double EIGHTH_INPUT = RANDOM.nextDouble();
    
    private Tuple8<Integer, String, Long, Double, Integer, String, Long, Double> systemUnderTest = new Tuple1<>(FIRST_INPUT)
        .push(SECOND_INPUT)
        .push(THIRD_INPUT)
        .push(FOURTH_INPUT)
        .push(FIFTH_INPUT)
        .push(SIXTH_INPUT)
        .push(SEVENTH_INPUT)
        .push(EIGHTH_INPUT);
        
    @Test
    void thenFirstValueIsCorrect() {
        final var value = systemUnderTest.getFirst();
        Assertions.assertEquals(FIRST_INPUT, value);
    }
    
    @Test
    void thenSecondValueIsCorrect() {
        final var value = systemUnderTest.getSecond();
        Assertions.assertEquals(SECOND_INPUT, value);
    }
    
    @Test
    void thenThirdValueIsCorrect() {
        final var value = systemUnderTest.getThird();
        Assertions.assertEquals(THIRD_INPUT, value);
    }
    
    @Test
    void thenFourthValueIsCorrect() {
        final var value = systemUnderTest.getFourth();
        Assertions.assertEquals(FOURTH_INPUT, value);
    }
    
    @Test
    void thenFifthValueIsCorrect() {
        final var value = systemUnderTest.getFifth();
        Assertions.assertEquals(FIFTH_INPUT, value);
    }
    
    @Test
    void thenSixthValueIsCorrect() {
        final var value = systemUnderTest.getSixth();
        Assertions.assertEquals(SIXTH_INPUT, value);
    }
    
    @Test
    void thenSeventhValueIsCorrect() {
        final var value = systemUnderTest.getSeventh();
        Assertions.assertEquals(SEVENTH_INPUT, value);
    }
    
    @Test
    void thenEighthValueIsCorrect() {
        final var value = systemUnderTest.getEighth();
        Assertions.assertEquals(EIGHTH_INPUT, value);
    }
}

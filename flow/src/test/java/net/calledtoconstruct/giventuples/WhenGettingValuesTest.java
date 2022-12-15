package net.calledtoconstruct.giventuples;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Tuple1;
import net.calledtoconstruct.Tuple2;
import net.calledtoconstruct.Tuple3;
import net.calledtoconstruct.Tuple4;
import net.calledtoconstruct.Tuple5;
import net.calledtoconstruct.Tuple6;
import net.calledtoconstruct.Tuple7;
import net.calledtoconstruct.Tuple8;

class WhenGettingValuesTest {
    
    private static final Random RANDOM = new Random();
    private static final String FIRST_INPUT = String.format("%d", RANDOM.nextInt());
    private static final Long SECOND_INPUT = RANDOM.nextLong();
    private static final Double THIRD_INPUT = RANDOM.nextDouble();
    private static final Integer FOURTH_INPUT = RANDOM.nextInt();
    private static final String FIFTH_INPUT = String.format("%d", RANDOM.nextInt());
    private static final Long SIXTH_INPUT = RANDOM.nextLong();
    private static final Double SEVENTH_INPUT = RANDOM.nextDouble();
    private static final Integer EIGHTH_INPUT = RANDOM.nextInt();

    private final Tuple8<String, Long, Double, Integer, String, Long, Double, Integer> tuple8 = new Tuple8<>(
        FIRST_INPUT,
        SECOND_INPUT,
        THIRD_INPUT,
        FOURTH_INPUT,
        FIFTH_INPUT,
        SIXTH_INPUT,
        SEVENTH_INPUT,
        EIGHTH_INPUT
    );

    private final Tuple7<String, Long, Double, Integer, String, Long, Double> tuple7 = new Tuple7<>(
        FIRST_INPUT,
        SECOND_INPUT,
        THIRD_INPUT,
        FOURTH_INPUT,
        FIFTH_INPUT,
        SIXTH_INPUT,
        SEVENTH_INPUT
    );

    private final Tuple6<String, Long, Double, Integer, String, Long> tuple6 = new Tuple6<>(
        FIRST_INPUT,
        SECOND_INPUT,
        THIRD_INPUT,
        FOURTH_INPUT,
        FIFTH_INPUT,
        SIXTH_INPUT
    );

    private final Tuple5<String, Long, Double, Integer, String> tuple5 = new Tuple5<>(
        FIRST_INPUT,
        SECOND_INPUT,
        THIRD_INPUT,
        FOURTH_INPUT,
        FIFTH_INPUT
    );

    private final Tuple4<String, Long, Double, Integer> tuple4 = new Tuple4<>(
        FIRST_INPUT,
        SECOND_INPUT,
        THIRD_INPUT,
        FOURTH_INPUT
    );

    private final Tuple3<String, Long, Double> tuple3 = new Tuple3<>(
        FIRST_INPUT,
        SECOND_INPUT,
        THIRD_INPUT
    );

    private final Tuple2<String, Long> tuple2 = new Tuple2<>(
        FIRST_INPUT,
        SECOND_INPUT
    );

    private final Tuple1<String> tuple1 = new Tuple1<>(
        FIRST_INPUT
    );

    @Test
    void thenEighthIsCorrect() {
        Assertions.assertEquals(EIGHTH_INPUT, tuple8.getEighth());
    }

    @Test
    void thenSeventhIsCorrect() {
        Assertions.assertEquals(SEVENTH_INPUT, tuple8.getSeventh());
        Assertions.assertEquals(SEVENTH_INPUT, tuple7.getSeventh());
    }

    @Test
    void thenSixthIsCorrect() {
        Assertions.assertEquals(SIXTH_INPUT, tuple8.getSixth());
        Assertions.assertEquals(SIXTH_INPUT, tuple7.getSixth());
        Assertions.assertEquals(SIXTH_INPUT, tuple6.getSixth());
    }

    @Test
    void thenFifthIsCorrect() {
        Assertions.assertEquals(FIFTH_INPUT, tuple8.getFifth());
        Assertions.assertEquals(FIFTH_INPUT, tuple7.getFifth());
        Assertions.assertEquals(FIFTH_INPUT, tuple6.getFifth());
        Assertions.assertEquals(FIFTH_INPUT, tuple5.getFifth());
    }

    @Test
    void thenFourthIsCorrect() {
        Assertions.assertEquals(FOURTH_INPUT, tuple8.getFourth());
        Assertions.assertEquals(FOURTH_INPUT, tuple7.getFourth());
        Assertions.assertEquals(FOURTH_INPUT, tuple6.getFourth());
        Assertions.assertEquals(FOURTH_INPUT, tuple5.getFourth());
        Assertions.assertEquals(FOURTH_INPUT, tuple4.getFourth());
    }

    @Test
    void thenThirdIsCorrect() {
        Assertions.assertEquals(THIRD_INPUT, tuple8.getThird());
        Assertions.assertEquals(THIRD_INPUT, tuple7.getThird());
        Assertions.assertEquals(THIRD_INPUT, tuple6.getThird());
        Assertions.assertEquals(THIRD_INPUT, tuple5.getThird());
        Assertions.assertEquals(THIRD_INPUT, tuple4.getThird());
        Assertions.assertEquals(THIRD_INPUT, tuple3.getThird());
    }

    @Test
    void thenSecondIsCorrect() {
        Assertions.assertEquals(SECOND_INPUT, tuple8.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple7.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple6.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple5.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple4.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple3.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple2.getSecond());
    }

    @Test
    void thenFirstIsCorrect() {
        Assertions.assertEquals(FIRST_INPUT, tuple8.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple7.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple6.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple5.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple4.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple3.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple2.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple1.getFirst());
    }
}

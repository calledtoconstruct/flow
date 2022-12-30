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

public class WhenInvokingPrependTest {

    public static final Random RANDOM = new Random();
    public static final Integer FIRST_INPUT = RANDOM.nextInt();
    public static final Integer SECOND_INPUT = RANDOM.nextInt();
    public static final Integer THIRD_INPUT = RANDOM.nextInt();
    public static final Integer FOURTH_INPUT = RANDOM.nextInt();
    public static final Integer FIFTH_INPUT = RANDOM.nextInt();
    public static final Integer SIXTH_INPUT = RANDOM.nextInt();
    public static final Integer SEVENTH_INPUT = RANDOM.nextInt();
    public static final Integer EIGHTH_INPUT = RANDOM.nextInt();

    private final Tuple1<Integer> tuple1_1 = new Tuple1<>(FIRST_INPUT);
    private final Tuple1<Integer> tuple1_2 = new Tuple1<>(SECOND_INPUT);
    private final Tuple1<Integer> tuple1_3 = new Tuple1<>(THIRD_INPUT);
    private final Tuple1<Integer> tuple1_4 = new Tuple1<>(FOURTH_INPUT);
    private final Tuple1<Integer> tuple1_5 = new Tuple1<>(FIFTH_INPUT);
    private final Tuple1<Integer> tuple1_6 = new Tuple1<>(SIXTH_INPUT);
    private final Tuple1<Integer> tuple1_7 = new Tuple1<>(SEVENTH_INPUT);
    private final Tuple1<Integer> tuple1_8 = new Tuple1<>(EIGHTH_INPUT);
    private final Tuple2<Integer, Integer> tuple2 = tuple1_1.prepend(tuple1_2);
    private final Tuple3<Integer, Integer, Integer> tuple3 = tuple1_2.prepend(tuple2);
    private final Tuple4<Integer, Integer, Integer, Integer> tuple4 = tuple1_3.prepend(tuple3);
    private final Tuple5<Integer, Integer, Integer, Integer, Integer> tuple5 = tuple1_4.prepend(tuple4);
    private final Tuple6<Integer, Integer, Integer, Integer, Integer, Integer> tuple6 = tuple1_5.prepend(tuple5);
    private final Tuple7<Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple7 = tuple1_6.prepend(tuple6);
    private final Tuple8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple8 = tuple1_7.prepend(tuple7);
    private final Tuple3<Integer, Integer, Integer> tuple3_2_1 = tuple2.prepend(tuple1_8);
    private final Tuple4<Integer, Integer, Integer, Integer> tuple4_2_2 = tuple2.prepend(tuple2);
    private final Tuple5<Integer, Integer, Integer, Integer, Integer> tuple5_2_3 = tuple2.prepend(tuple3);
    private final Tuple6<Integer, Integer, Integer, Integer, Integer, Integer> tuple6_2_4 = tuple2.prepend(tuple4);
    private final Tuple7<Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple7_2_5 = tuple2.prepend(tuple5);
    private final Tuple8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple8_2_6 = tuple2.prepend(tuple6);
    private final Tuple4<Integer, Integer, Integer, Integer> tuple4_3_1 = tuple3.prepend(tuple1_7);
    private final Tuple5<Integer, Integer, Integer, Integer, Integer> tuple5_3_2 = tuple3.prepend(tuple2);
    private final Tuple6<Integer, Integer, Integer, Integer, Integer, Integer> tuple6_3_3 = tuple3.prepend(tuple3);
    private final Tuple7<Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple7_3_4 = tuple3.prepend(tuple4);
    private final Tuple8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple8_3_5 = tuple3.prepend(tuple5);
    private final Tuple5<Integer, Integer, Integer, Integer, Integer> tuple5_4_1 = tuple4.prepend(tuple1_6);
    private final Tuple6<Integer, Integer, Integer, Integer, Integer, Integer> tuple6_4_2 = tuple4.prepend(tuple2);
    private final Tuple7<Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple7_4_3 = tuple4.prepend(tuple3);
    private final Tuple8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple8_4_4 = tuple4.prepend(tuple4);
    private final Tuple6<Integer, Integer, Integer, Integer, Integer, Integer> tuple6_5_1 = tuple5.prepend(tuple1_5);
    private final Tuple7<Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple7_5_2 = tuple5.prepend(tuple2);
    private final Tuple8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple8_5_3 = tuple5.prepend(tuple3);
    private final Tuple7<Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple7_6_1 = tuple6.prepend(tuple1_4);
    private final Tuple8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple8_6_2 = tuple6.prepend(tuple2);
    private final Tuple8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple8_7_1 = tuple7.prepend(tuple1_3);

    @Test
    void thatTuple2HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple2.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple2.getSecond());
    }

    @Test
    void thatTuple3HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple3.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple3.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple3.getThird());
    }
    
    @Test
    void thatTuple4HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple4.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple4.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple4.getThird());
        Assertions.assertEquals(THIRD_INPUT, tuple4.getFourth());
    }

    @Test
    void thatTuple5HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple5.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple5.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple5.getThird());
        Assertions.assertEquals(THIRD_INPUT, tuple5.getFourth());
        Assertions.assertEquals(FOURTH_INPUT, tuple5.getFifth());
    }

    @Test
    void thatTuple6HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple6.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple6.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple6.getThird());
        Assertions.assertEquals(THIRD_INPUT, tuple6.getFourth());
        Assertions.assertEquals(FOURTH_INPUT, tuple6.getFifth());
        Assertions.assertEquals(FIFTH_INPUT, tuple6.getSixth());
    }

    @Test
    void thatTuple7HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple7.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple7.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple7.getThird());
        Assertions.assertEquals(THIRD_INPUT, tuple7.getFourth());
        Assertions.assertEquals(FOURTH_INPUT, tuple7.getFifth());
        Assertions.assertEquals(FIFTH_INPUT, tuple7.getSixth());
        Assertions.assertEquals(SIXTH_INPUT, tuple7.getSeventh());
    }

    @Test
    void thatTuple8HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple8.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple8.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple8.getThird());
        Assertions.assertEquals(THIRD_INPUT, tuple8.getFourth());
        Assertions.assertEquals(FOURTH_INPUT, tuple8.getFifth());
        Assertions.assertEquals(FIFTH_INPUT, tuple8.getSixth());
        Assertions.assertEquals(SIXTH_INPUT, tuple8.getSeventh());
        Assertions.assertEquals(SEVENTH_INPUT, tuple8.getEighth());
    }

    @Test
    void thatTuple3_2_1HasCorrectValues() {
        Assertions.assertEquals(EIGHTH_INPUT, tuple3_2_1.getFirst());
        Assertions.assertEquals(SECOND_INPUT, tuple3_2_1.getSecond());
        Assertions.assertEquals(FIRST_INPUT, tuple3_2_1.getThird());
    }
    
    @Test
    void thatTuple4_2_2HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple4_2_2.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple4_2_2.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple4_2_2.getThird());
        Assertions.assertEquals(FIRST_INPUT, tuple4_2_2.getFourth());
    }
    
    @Test
    void thatTuple5_2_3HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple5_2_3.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple5_2_3.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple5_2_3.getThird());
        Assertions.assertEquals(SECOND_INPUT, tuple5_2_3.getFourth());
        Assertions.assertEquals(FIRST_INPUT, tuple5_2_3.getFifth());
    }

    @Test
    void thatTuple6_2_4HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple6_2_4.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple6_2_4.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple6_2_4.getThird());
        Assertions.assertEquals(THIRD_INPUT, tuple6_2_4.getFourth());
        Assertions.assertEquals(SECOND_INPUT, tuple6_2_4.getFifth());
        Assertions.assertEquals(FIRST_INPUT, tuple6_2_4.getSixth());
    }

    @Test
    void thatTuple7_2_5HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple7_2_5.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple7_2_5.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple7_2_5.getThird());
        Assertions.assertEquals(THIRD_INPUT, tuple7_2_5.getFourth());
        Assertions.assertEquals(FOURTH_INPUT, tuple7_2_5.getFifth());
        Assertions.assertEquals(SECOND_INPUT, tuple7_2_5.getSixth());
        Assertions.assertEquals(FIRST_INPUT, tuple7_2_5.getSeventh());
    }

    @Test
    void thatTuple8_2_6HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple8_2_6.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple8_2_6.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple8_2_6.getThird());
        Assertions.assertEquals(THIRD_INPUT, tuple8_2_6.getFourth());
        Assertions.assertEquals(FOURTH_INPUT, tuple8_2_6.getFifth());
        Assertions.assertEquals(FIFTH_INPUT, tuple8_2_6.getSixth());
        Assertions.assertEquals(SECOND_INPUT, tuple8_2_6.getSeventh());
        Assertions.assertEquals(FIRST_INPUT, tuple8_2_6.getEighth());
    }

    @Test
    void thatTuple4_3_1HasCorrectValues() {
        Assertions.assertEquals(SEVENTH_INPUT, tuple4_3_1.getFirst());
        Assertions.assertEquals(SECOND_INPUT, tuple4_3_1.getSecond());
        Assertions.assertEquals(FIRST_INPUT, tuple4_3_1.getThird());
        Assertions.assertEquals(SECOND_INPUT, tuple4_3_1.getFourth());
    }

    @Test
    void thatTuple5_3_2HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple5_3_2.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple5_3_2.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple5_3_2.getThird());
        Assertions.assertEquals(FIRST_INPUT, tuple5_3_2.getFourth());
        Assertions.assertEquals(SECOND_INPUT, tuple5_3_2.getFifth());
    }

    @Test
    void thatTuple6_3_3HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple6_3_3.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple6_3_3.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple6_3_3.getThird());
        Assertions.assertEquals(SECOND_INPUT, tuple6_3_3.getFourth());
        Assertions.assertEquals(FIRST_INPUT, tuple6_3_3.getFifth());
        Assertions.assertEquals(SECOND_INPUT, tuple6_3_3.getSixth());
    }

    @Test
    void thatTuple7_3_4HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple7_3_4.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple7_3_4.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple7_3_4.getThird());
        Assertions.assertEquals(THIRD_INPUT, tuple7_3_4.getFourth());
        Assertions.assertEquals(SECOND_INPUT, tuple7_3_4.getFifth());
        Assertions.assertEquals(FIRST_INPUT, tuple7_3_4.getSixth());
        Assertions.assertEquals(SECOND_INPUT, tuple7_3_4.getSeventh());
    }

    @Test
    void thatTuple8_3_5HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple8_3_5.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple8_3_5.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple8_3_5.getThird());
        Assertions.assertEquals(THIRD_INPUT, tuple8_3_5.getFourth());
        Assertions.assertEquals(FOURTH_INPUT, tuple8_3_5.getFifth());
        Assertions.assertEquals(SECOND_INPUT, tuple8_3_5.getSixth());
        Assertions.assertEquals(FIRST_INPUT, tuple8_3_5.getSeventh());
        Assertions.assertEquals(SECOND_INPUT, tuple8_3_5.getEighth());
    }

    @Test
    void thatTuple5_4_1HasCorrectValues() {
        Assertions.assertEquals(SIXTH_INPUT, tuple5_4_1.getFirst());
        Assertions.assertEquals(SECOND_INPUT, tuple5_4_1.getSecond());
        Assertions.assertEquals(FIRST_INPUT, tuple5_4_1.getThird());
        Assertions.assertEquals(SECOND_INPUT, tuple5_4_1.getFourth());
        Assertions.assertEquals(THIRD_INPUT, tuple5_4_1.getFifth());
    }

    @Test
    void thatTuple6_4_2HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple6_4_2.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple6_4_2.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple6_4_2.getThird());
        Assertions.assertEquals(FIRST_INPUT, tuple6_4_2.getFourth());
        Assertions.assertEquals(SECOND_INPUT, tuple6_4_2.getFifth());
        Assertions.assertEquals(THIRD_INPUT, tuple6_4_2.getSixth());
    }

    @Test
    void thatTuple7_4_3HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple7_4_3.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple7_4_3.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple7_4_3.getThird());
        Assertions.assertEquals(SECOND_INPUT, tuple7_4_3.getFourth());
        Assertions.assertEquals(FIRST_INPUT, tuple7_4_3.getFifth());
        Assertions.assertEquals(SECOND_INPUT, tuple7_4_3.getSixth());
        Assertions.assertEquals(THIRD_INPUT, tuple7_4_3.getSeventh());
    }

    @Test
    void thatTuple8_4_4HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple8_4_4.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple8_4_4.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple8_4_4.getThird());
        Assertions.assertEquals(THIRD_INPUT, tuple8_4_4.getFourth());
        Assertions.assertEquals(SECOND_INPUT, tuple8_4_4.getFifth());
        Assertions.assertEquals(FIRST_INPUT, tuple8_4_4.getSixth());
        Assertions.assertEquals(SECOND_INPUT, tuple8_4_4.getSeventh());
        Assertions.assertEquals(THIRD_INPUT, tuple8_4_4.getEighth());
    }

    @Test
    void thatTuple6_5_1HasCorrectValues() {
        Assertions.assertEquals(FIFTH_INPUT, tuple6_5_1.getFirst());
        Assertions.assertEquals(SECOND_INPUT, tuple6_5_1.getSecond());
        Assertions.assertEquals(FIRST_INPUT, tuple6_5_1.getThird());
        Assertions.assertEquals(SECOND_INPUT, tuple6_5_1.getFourth());
        Assertions.assertEquals(THIRD_INPUT, tuple6_5_1.getFifth());
        Assertions.assertEquals(FOURTH_INPUT, tuple6_5_1.getSixth());
    }

    @Test
    void thatTuple7_5_2HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple7_5_2.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple7_5_2.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple7_5_2.getThird());
        Assertions.assertEquals(FIRST_INPUT, tuple7_5_2.getFourth());
        Assertions.assertEquals(SECOND_INPUT, tuple7_5_2.getFifth());
        Assertions.assertEquals(THIRD_INPUT, tuple7_5_2.getSixth());
        Assertions.assertEquals(FOURTH_INPUT, tuple7_5_2.getSeventh());
    }

    @Test
    void thatTuple8_5_3HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple8_5_3.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple8_5_3.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple8_5_3.getThird());
        Assertions.assertEquals(SECOND_INPUT, tuple8_5_3.getFourth());
        Assertions.assertEquals(FIRST_INPUT, tuple8_5_3.getFifth());
        Assertions.assertEquals(SECOND_INPUT, tuple8_5_3.getSixth());
        Assertions.assertEquals(THIRD_INPUT, tuple8_5_3.getSeventh());
        Assertions.assertEquals(FOURTH_INPUT, tuple8_5_3.getEighth());
    }

    @Test
    void thatTuple7_6_1HasCorrectValues() {
        Assertions.assertEquals(FOURTH_INPUT, tuple7_6_1.getFirst());
        Assertions.assertEquals(SECOND_INPUT, tuple7_6_1.getSecond());
        Assertions.assertEquals(FIRST_INPUT, tuple7_6_1.getThird());
        Assertions.assertEquals(SECOND_INPUT, tuple7_6_1.getFourth());
        Assertions.assertEquals(THIRD_INPUT, tuple7_6_1.getFifth());
        Assertions.assertEquals(FOURTH_INPUT, tuple7_6_1.getSixth());
        Assertions.assertEquals(FIFTH_INPUT, tuple7_6_1.getSeventh());
    }

    @Test
    void thatTuple8_6_2HasCorrectValues() {
        Assertions.assertEquals(SECOND_INPUT, tuple8_6_2.getFirst());
        Assertions.assertEquals(FIRST_INPUT, tuple8_6_2.getSecond());
        Assertions.assertEquals(SECOND_INPUT, tuple8_6_2.getThird());
        Assertions.assertEquals(FIRST_INPUT, tuple8_6_2.getFourth());
        Assertions.assertEquals(SECOND_INPUT, tuple8_6_2.getFifth());
        Assertions.assertEquals(THIRD_INPUT, tuple8_6_2.getSixth());
        Assertions.assertEquals(FOURTH_INPUT, tuple8_6_2.getSeventh());
        Assertions.assertEquals(FIFTH_INPUT, tuple8_6_2.getEighth());
    }

    @Test
    void thatTuple8_7_1HasCorrectValues() {
        Assertions.assertEquals(THIRD_INPUT, tuple8_7_1.getFirst());
        Assertions.assertEquals(SECOND_INPUT, tuple8_7_1.getSecond());
        Assertions.assertEquals(FIRST_INPUT, tuple8_7_1.getThird());
        Assertions.assertEquals(SECOND_INPUT, tuple8_7_1.getFourth());
        Assertions.assertEquals(THIRD_INPUT, tuple8_7_1.getFifth());
        Assertions.assertEquals(FOURTH_INPUT, tuple8_7_1.getSixth());
        Assertions.assertEquals(FIFTH_INPUT, tuple8_7_1.getSeventh());
        Assertions.assertEquals(SIXTH_INPUT, tuple8_7_1.getEighth());
    }
}
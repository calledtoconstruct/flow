package net.calledtoconstruct.giventuples;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.calledtoconstruct.Tuple;
import net.calledtoconstruct.Tuple1;
import net.calledtoconstruct.Tuple2;
import net.calledtoconstruct.Tuple3;
import net.calledtoconstruct.Tuple4;
import net.calledtoconstruct.Tuple5;
import net.calledtoconstruct.Tuple6;
import net.calledtoconstruct.Tuple7;
import net.calledtoconstruct.Tuple8;

public class WhenInvokingToArrayTest {
    
    private static final Random RANDOM = new Random();

    private static final int VALUE = RANDOM.nextInt();

    private final Tuple8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple8 = new Tuple8<>(
        VALUE, VALUE, VALUE, VALUE, VALUE, VALUE, VALUE, VALUE
    );

    private final Tuple7<Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple7 = new Tuple7<>(
        VALUE, VALUE, VALUE, VALUE, VALUE, VALUE, VALUE
    );

    private final Tuple6<Integer, Integer, Integer, Integer, Integer, Integer> tuple6 = new Tuple6<>(
        VALUE, VALUE, VALUE, VALUE, VALUE, VALUE
    );

    private final Tuple5<Integer, Integer, Integer, Integer, Integer> tuple5 = new Tuple5<>(
        VALUE, VALUE, VALUE, VALUE, VALUE
    );

    private final Tuple4<Integer, Integer, Integer, Integer> tuple4 = new Tuple4<>(
        VALUE, VALUE, VALUE, VALUE
    );

    private final Tuple3<Integer, Integer, Integer> tuple3 = new Tuple3<>(
        VALUE, VALUE, VALUE
    );

    private final Tuple2<Integer, Integer> tuple2 = new Tuple2<>(
        VALUE, VALUE
    );

    private final Tuple1<Integer> tuple1 = new Tuple1<>(
        VALUE
    );

    private final Integer[] array8 = Tuple.toArray(tuple8, Integer.class);
    private final Integer[] array7 = Tuple.toArray(tuple7, Integer.class);
    private final Integer[] array6 = Tuple.toArray(tuple6, Integer.class);
    private final Integer[] array5 = Tuple.toArray(tuple5, Integer.class);
    private final Integer[] array4 = Tuple.toArray(tuple4, Integer.class);
    private final Integer[] array3 = Tuple.toArray(tuple3, Integer.class);
    private final Integer[] array2 = Tuple.toArray(tuple2, Integer.class);
    private final Integer[] array1 = Tuple.toArray(tuple1, Integer.class);

    @Test
    void thatArray8IsCorrect() {
        Assertions.assertEquals(8, array8.length);
        for (var value : array8) {
            Assertions.assertEquals(VALUE, value);
        }
    }

    @Test
    void thatArray7IsCorrect() {
        Assertions.assertEquals(7, array7.length);
        for (var value : array7) {
            Assertions.assertEquals(VALUE, value);
        }
    }

    @Test
    void thatArray6IsCorrect() {
        Assertions.assertEquals(6, array6.length);
        for (var value : array6) {
            Assertions.assertEquals(VALUE, value);
        }
    }

    @Test
    void thatArray5IsCorrect() {
        Assertions.assertEquals(5, array5.length);
        for (var value : array5) {
            Assertions.assertEquals(VALUE, value);
        }
    }

    @Test
    void thatArray4IsCorrect() {
        Assertions.assertEquals(4, array4.length);
        for (var value : array4) {
            Assertions.assertEquals(VALUE, value);
        }
    }

    @Test
    void thatArray3IsCorrect() {
        Assertions.assertEquals(3, array3.length);
        for (var value : array3) {
            Assertions.assertEquals(VALUE, value);
        }
    }

    @Test
    void thatArray2IsCorrect() {
        Assertions.assertEquals(2, array2.length);
        for (var value : array2) {
            Assertions.assertEquals(VALUE, value);
        }
    }

    @Test
    void thatArray1IsCorrect() {
        Assertions.assertEquals(1, array1.length);
        for (var value : array1) {
            Assertions.assertEquals(VALUE, value);
        }
    }
}

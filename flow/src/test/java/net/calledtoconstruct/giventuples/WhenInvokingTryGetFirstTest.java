package net.calledtoconstruct.giventuples;

import java.util.Optional;
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

public class WhenInvokingTryGetFirstTest {
    
    private static final Random RANDOM = new Random();
    private static final long FIRST_VALUE = RANDOM.nextLong();
    private static final long SECOND_VALUE = RANDOM.nextLong();
    private static final long THIRD_VALUE = RANDOM.nextLong();
    private static final long FOURTH_VALUE = RANDOM.nextLong();
    private static final long FIFTH_VALUE = RANDOM.nextLong();
    private static final long SIXTH_VALUE = RANDOM.nextLong();
    private static final long SEVENTH_VALUE = RANDOM.nextLong();
    private static final long EIGHTH_VALUE = RANDOM.nextLong();

    private final Tuple1<Long> tuple1 = new Tuple1<>(FIRST_VALUE);
    private final Tuple2<Long, Long> tuple2 = new Tuple2<>(FIRST_VALUE, SECOND_VALUE);
    private final Tuple3<Long, Long, Long> tuple3 = new Tuple3<>(FIRST_VALUE, SECOND_VALUE, THIRD_VALUE);
    private final Tuple4<Long, Long, Long, Long> tuple4 = new Tuple4<>(FIRST_VALUE, SECOND_VALUE, THIRD_VALUE, FOURTH_VALUE);
    private final Tuple5<Long, Long, Long, Long, Long> tuple5 = new Tuple5<>(FIRST_VALUE, SECOND_VALUE, THIRD_VALUE, FOURTH_VALUE, FIFTH_VALUE);
    private final Tuple6<Long, Long, Long, Long, Long, Long> tuple6 = new Tuple6<>(FIRST_VALUE, SECOND_VALUE, THIRD_VALUE, FOURTH_VALUE, FIFTH_VALUE, SIXTH_VALUE);
    private final Tuple7<Long, Long, Long, Long, Long, Long, Long> tuple7 = new Tuple7<>(FIRST_VALUE, SECOND_VALUE, THIRD_VALUE, FOURTH_VALUE, FIFTH_VALUE, SIXTH_VALUE, SEVENTH_VALUE);
    private final Tuple8<Long, Long, Long, Long, Long, Long, Long, Long> tuple8 = new Tuple8<>(FIRST_VALUE, SECOND_VALUE, THIRD_VALUE, FOURTH_VALUE, FIFTH_VALUE, SIXTH_VALUE, SEVENTH_VALUE, EIGHTH_VALUE);
    
    private final Optional<Long> firstResult = tuple1.tryGetFirst(Long.class);
    private final Optional<String> firstResultEmpty = tuple1.tryGetFirst(String.class);
    private final Optional<Long> secondResult = tuple2.tryGetFirst(Long.class);
    private final Optional<String> secondResultEmpty = tuple2.tryGetFirst(String.class);
    private final Optional<Long> thirdResult = tuple3.tryGetFirst(Long.class);
    private final Optional<String> thirdResultEmpty = tuple3.tryGetFirst(String.class);
    private final Optional<Long> fourthResult = tuple4.tryGetFirst(Long.class);
    private final Optional<String> fourthResultEmpty = tuple4.tryGetFirst(String.class);
    private final Optional<Long> fifthResult = tuple5.tryGetFirst(Long.class);
    private final Optional<String> fifthResultEmpty = tuple5.tryGetFirst(String.class);
    private final Optional<Long> sixthResult = tuple6.tryGetFirst(Long.class);
    private final Optional<String> sixthResultEmpty = tuple6.tryGetFirst(String.class);
    private final Optional<Long> seventhResult = tuple7.tryGetFirst(Long.class);
    private final Optional<String> seventhResultEmpty = tuple7.tryGetFirst(String.class);
    private final Optional<Long> eighthResult = tuple8.tryGetFirst(Long.class);
    private final Optional<String> eighthResultEmpty = tuple8.tryGetFirst(String.class);

    @Test
    void thatFirstResultIsCorrect() {
        Assertions.assertTrue(firstResult.isPresent());
        Assertions.assertEquals(FIRST_VALUE, firstResult.get());
        Assertions.assertFalse(firstResultEmpty.isPresent());
    }

    @Test
    void thatSecondResultIsCorrect() {
        Assertions.assertTrue(secondResult.isPresent());
        Assertions.assertEquals(FIRST_VALUE, secondResult.get());
        Assertions.assertFalse(secondResultEmpty.isPresent());
    }

    @Test
    void thatThirdResultIsCorrect() {
        Assertions.assertTrue(thirdResult.isPresent());
        Assertions.assertEquals(FIRST_VALUE, thirdResult.get());
        Assertions.assertFalse(thirdResultEmpty.isPresent());
    }

    @Test
    void thatFourthResultIsCorrect() {
        Assertions.assertTrue(fourthResult.isPresent());
        Assertions.assertEquals(FIRST_VALUE, fourthResult.get());
        Assertions.assertFalse(fourthResultEmpty.isPresent());
    }

    @Test
    void thatFifthResultIsCorrect() {
        Assertions.assertTrue(fifthResult.isPresent());
        Assertions.assertEquals(FIRST_VALUE, fifthResult.get());
        Assertions.assertFalse(fifthResultEmpty.isPresent());
    }

    @Test
    void thatSixthResultIsCorrect() {
        Assertions.assertTrue(sixthResult.isPresent());
        Assertions.assertEquals(FIRST_VALUE, sixthResult.get());
        Assertions.assertFalse(sixthResultEmpty.isPresent());
    }

    @Test
    void thatSeventhResultIsCorrect() {
        Assertions.assertTrue(seventhResult.isPresent());
        Assertions.assertEquals(FIRST_VALUE, seventhResult.get());
        Assertions.assertFalse(seventhResultEmpty.isPresent());
    }

    @Test
    void thatEighthResultIsCorrect() {
        Assertions.assertTrue(eighthResult.isPresent());
        Assertions.assertEquals(FIRST_VALUE, eighthResult.get());
        Assertions.assertFalse(eighthResultEmpty.isPresent());
    }
}

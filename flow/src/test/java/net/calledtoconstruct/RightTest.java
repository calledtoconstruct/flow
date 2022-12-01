package net.calledtoconstruct;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.Before;
import org.junit.Test;

public class RightTest {

    private static final int INPUT = 298374234;
    private Either<Boolean, Integer> systemUnderTest;

    private static final int MULTIPLIER = 10;
    private Either<Boolean, Integer> result;

    private Either<Boolean, String> mapped;

    @Before
    public void givenValidRight_onRightApply() {
        systemUnderTest = new Right<>(INPUT);
        result = systemUnderTest.<Integer>onRightApply(input -> input * MULTIPLIER);
        mapped = systemUnderTest.<String>onRightApply(input -> input.toString());
    }

    @Test
    public void thenResultOnRightAcceptProducesCorrectValue() {
        final var value = new AtomicInteger();
        result.onRightAccept(calculated -> value.set(calculated));
        assertEquals(INPUT * MULTIPLIER, value.get());
    }

    @Test
    public void thenMappedOnRightAcceptProducesCorrectValue() {
        final var value = new AtomicReference<String>();
        mapped.onRightAccept(converted -> value.set(converted));
        assertEquals(Integer.toString(INPUT), value.get());
    }

    @Test
    public void thenResultIsInstanceOfRight() {
        assertTrue(result instanceof Right);
    }

    @Test
    public void thenGetProducesCorrectValue() {
        if (result instanceof Right<Boolean, Integer> right) {
            assertEquals(Integer.valueOf(INPUT * MULTIPLIER), right.getValue());
        }
    }
}

package net.calledtoconstruct;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.Before;
import org.junit.Test;

public class LeftTest {

    private static final int INPUT = 89474;
    private Either<Integer, Boolean> systemUnderTest;

    private static final int MULTIPLIER = 10;
    private Either<Integer, Boolean> result;

    private Either<String, Boolean> mapped;

    @Before
    public void givenValidLeft_onLeftApply() {
        systemUnderTest = new Left<>(INPUT);
        result = systemUnderTest.<Integer>onLeftApply(input -> input * MULTIPLIER);
        mapped = systemUnderTest.<String>onLeftApply(input -> input.toString());
    }

    @Test
    public void thenResultOnLeftAcceptProducesCorrectValue() {
        final var value = new AtomicInteger();
        result.onLeftAccept(calculated -> value.set(calculated));
        assertEquals(INPUT * MULTIPLIER, value.get());
    }

    @Test
    public void thenMappedOnLeftAcceptProducesCorrectValue() {
        final var value = new AtomicReference<String>();
        mapped.onLeftAccept(converted -> value.set(converted));
        assertEquals(Integer.toString(INPUT), value.get());
    }

    @Test
    public void thenResultIsInstanceOfLeft() {
        assertTrue(result instanceof Left);
    }

    @Test
    public void thenGetProducesCorrectValue() {
        if (result instanceof Left<Integer, Boolean> left) {
            assertEquals(Integer.valueOf(INPUT * MULTIPLIER), left.getValue());
        }
    }
}

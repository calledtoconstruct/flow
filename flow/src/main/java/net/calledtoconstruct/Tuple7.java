package net.calledtoconstruct;

import java.util.Optional;

/**
 * An implementation of the Tuple interface which contains seven elements of type T1, T2, T3, T4, T5, T6 and T7.
 */
public class Tuple7<T1, T2, T3, T4, T5, T6, T7> implements Tuple {

    private final T1 firstValue;
    private final T2 secondValue;
    private final T3 thirdValue;
    private final T4 fourthValue;
    private final T5 fifthValue;
    private final T6 sixthValue;
    private final T7 seventhValue;

    /**
     * A constructor for the {@link Tuple7} class which accepts seven values of types T1, T2, T3, T4, T5, T6 and T7.
     */
    public Tuple7(T1 firstValue, T2 secondValue, T3 thirdValue, T4 fourthValue, T5 fifthValue, T6 sixthValue, T7 seventhValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.thirdValue = thirdValue;
        this.fourthValue = fourthValue;
        this.fifthValue = fifthValue;
        this.sixthValue = sixthValue;
        this.seventhValue = seventhValue;
    }

    /**
     * A function that returns a new {@link Tuple8} containing 
     * the values of this instance plus the supplied {@code value}.
     * 
     * @param <T8> The type of {@code value} being added.
     * @param value A value to be added.
     * @return An instance of {@link Tuple8}
     */
    public <T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> push(T8 value) {
        return new Tuple8<>(firstValue, secondValue, thirdValue, fourthValue, fifthValue, sixthValue, seventhValue, value);
    }

    /**
     * A function that returns a new instance of {@link Tuple6} containing the
     * first six values from this instance.
     * 
     * @return A {@link Tuple6} containing the first six values from this instance.
     */
    public Tuple6<T1, T2, T3, T4, T5, T6> pop() {
        return new Tuple6<>(firstValue, secondValue, thirdValue, fourthValue, fifthValue, sixthValue);
    }

    /**
     * A function that returns a new instance of {@link Tuple6} containing the
     * last six values from this instance.
     * 
     * @return A {@link Tuple6} containing the last six values from this instance.
     */
    public Tuple6<T2, T3, T4, T5, T6, T7> shift() {
        return new Tuple6<>(secondValue, thirdValue, fourthValue, fifthValue, sixthValue, seventhValue);
    }

    /**
     * A function that returns a new {@link Tuple8} containing 
     * the supplied {@code value} plus the values of this instance.
     * 
     * @param <T8> The type of {@code value} being added.
     * @param value A value to be added.
     * @return An instance of {@link Tuple8}
     */
    public <T8> Tuple8<T8, T1, T2, T3, T4, T5, T6, T7> unshift(T8 value) {
        return new Tuple8<>(value, firstValue, secondValue, thirdValue, fourthValue, fifthValue, sixthValue, seventhValue);
    }

    @Override
    public Optional<Tuple> tryPop() {
        return Optional.of(pop());
    }

    @Override
    public <T> Optional<Tuple> tryPush(T value) {
        return Optional.of(push(value));
    }

    @Override
    public Optional<Tuple> tryShift() {
        return Optional.of(shift());
    }

    @Override
    public <T> Optional<Tuple> tryUnshift(T value) {
        return Optional.of(unshift(value));
    }

    /**
     * A function that returns the first value from this instance.
     * 
     * @return A value of type {@code T1}
     */
    public T1 getFirst() {
        return firstValue;
    }

    /**
     * A function that returns the second value from this instance.
     * 
     * @return A value of type {@code T2}
     */
    public T2 getSecond() {
        return secondValue;
    }

    /**
     * A function that returns the third value from this instance.
     * 
     * @return A value of type {@code T3}
     */
    public T3 getThird() {
        return thirdValue;
    }

    /**
     * A function that returns the fourth value from this instance.
     * 
     * @return A value of type {@code T4}
     */
    public T4 getFourth() {
        return fourthValue;
    }

    /**
     * A function that returns the fifth value from this instance.
     * 
     * @return A value of type {@code T5}
     */
    public T5 getFifth() {
        return fifthValue;
    }

    /**
     * A function that returns the sixth value from this instance.
     * 
     * @return A value of type {@code T6}
     */
    public T6 getSixth() {
        return sixthValue;
    }

    /**
     * A function that returns the seventh value from this instance.
     * 
     * @return A value of type {@code T7}
     */
    public T7 getSeventh() {
        return seventhValue;
    }

    /**
     * Appends the value of the provided {@link Tuple1} to the end of this instance and returns a {@link Tuple8}.
     */
    public <T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> append(final Tuple1<T8> other) {
        return new Tuple8<>(firstValue, secondValue, thirdValue, fourthValue, fifthValue, sixthValue, seventhValue, other.getFirst());
    }

    public <T8> Tuple8<T8, T1, T2, T3, T4, T5, T6, T7> prepend(final Tuple1<T8> other) {
        return new Tuple8<>(other.getFirst(), firstValue, secondValue, thirdValue, fourthValue, fifthValue, sixthValue, seventhValue);
    }

    @Override
    public <T> Optional<T> tryGetFirst(Class<T> clazz) {
        if (clazz.isAssignableFrom(firstValue.getClass())) {
            final var cast = clazz.cast(firstValue);
            return Optional.of(cast);
        }
        return Optional.empty();
    }

    @Override
    public <T> Optional<T> tryGetLast(Class<T> clazz) {
        if (clazz.isAssignableFrom(seventhValue.getClass())) {
            final var cast = clazz.cast(seventhValue);
            return Optional.of(cast);
        }
        return Optional.empty();
    }

}

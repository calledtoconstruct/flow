package net.calledtoconstruct;

import java.util.Optional;

/**
 * An implementation of the Tuple interface which contains six elements of type T1, T2, T3, T4, T5 and T6.
 */
public class Tuple6<T1, T2, T3, T4, T5, T6> implements Tuple {

    private final T1 firstValue;
    private final T2 secondValue;
    private final T3 thirdValue;
    private final T4 fourthValue;
    private final T5 fifthValue;
    private final T6 sixthValue;

    /**
     * A constructor for the {@link Tuple6} class which accepts six values of types T1, T2, T3, T4, T5 and T6.
     * 
     * @param firstValue The first value to be stored.
     * @param secondValue The second value to be stored.
     * @param thirdValue The third value to be stored.
     * @param fourthValue The fourth value to be stored.
     * @param fifthValue The fifth value to be stored.
     * @param sixthValue The sixth value to be stored.
     */
    public Tuple6(T1 firstValue, T2 secondValue, T3 thirdValue, T4 fourthValue, T5 fifthValue, T6 sixthValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.thirdValue = thirdValue;
        this.fourthValue = fourthValue;
        this.fifthValue = fifthValue;
        this.sixthValue = sixthValue;
    }

    /**
     * A function that returns a new {@link Tuple7} containing 
     * the values of this instance plus the supplied {@code value}.
     * 
     * @param <T7> The type of {@code value} being added.
     * @param value A value to be added.
     * @return An instance of {@link Tuple7}
     */
    public <T7> Tuple7<T1, T2, T3, T4, T5, T6, T7> push(T7 value) {
        return new Tuple7<>(firstValue, secondValue, thirdValue, fourthValue, fifthValue, sixthValue, value);
    }

    /**
     * A function that returns a new instance of {@link Tuple5} containing the
     * first five values from this instance.
     * 
     * @return A {@link Tuple5} containing the first five values from this instance.
     */
    public Tuple5<T1, T2, T3, T4, T5> pop() {
        return new Tuple5<>(firstValue, secondValue, thirdValue, fourthValue, fifthValue);
    }

    /**
     * A function that returns a new instance of {@link Tuple5} containing the
     * last five values from this instance.
     * 
     * @return A {@link Tuple5} containing the last five values from this instance.
     */
    public Tuple5<T2, T3, T4, T5, T6> shift() {
        return new Tuple5<>(secondValue, thirdValue, fourthValue, fifthValue, sixthValue);
    }

    /**
     * A function that returns a new {@link Tuple7} containing 
     * the supplied {@code value} plus the values of this instance.
     * 
     * @param <T7> The type of {@code value} being added.
     * @param value A value to be added.
     * @return An instance of {@link Tuple7}
     */
    public <T7> Tuple7<T7, T1, T2, T3, T4, T5, T6> unshift(T7 value) {
        return new Tuple7<>(value, firstValue, secondValue, thirdValue, fourthValue, fifthValue, sixthValue);
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
     * Appends the value of the provided {@link Tuple1} to the end of this instance and returns a {@link Tuple7}.
     * 
     * @param <T7> Type of the value contained in the {@link Tuple1} that will be appended.
     * @param other An instance of {@link Tuple1} containing the value of type {@code T7} to be appended.
     * @return A {@link Tuple7} containing the values from this instance and the value from {@code other}.
     */
    public <T7> Tuple7<T1, T2, T3, T4, T5, T6, T7> append(final Tuple1<T7> other) {
        return new Tuple7<>(firstValue, secondValue, thirdValue, fourthValue, fifthValue, sixthValue, other.getFirst());
    }

    /**
     * Appends the values of the provided {@link Tuple2} to the end of this instance and returns a {@link Tuple8}.
     * 
     * @param <T7> Type of the first value contained in the {@link Tuple2} that will be appended.
     * @param <T8> Type of the second value contained in the {@link Tuple2} that will be appended.
     * @param other An instance of {@link Tuple2} containing the values of types {@code T7} and {@code T8} to be appended.
     * @return A {@link Tuple8} containing the values from this instance and the values from {@code other}.
     */
    public <T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> append(final Tuple2<T7, T8> other) {
        return new Tuple8<>(firstValue, secondValue, thirdValue, fourthValue, fifthValue, sixthValue, other.getFirst(), other.getSecond());
    }

    /**
     * Prepends the value of the provided {@link Tuple1} to the beginning of this instance and returns a {@link Tuple7}.
     * 
     * @param <T7> Type of the value contained in the {@link Tuple1} that will be prepended.
     * @param other An instance of {@link Tuple1} containing the value of type {@code T7} to be prepended.
     * @return A {@link Tuple7} containing the value from {@code other} and the values from this instance.
     */
    public <T7> Tuple7<T7, T1, T2, T3, T4, T5, T6> prepend(final Tuple1<T7> other) {
        return new Tuple7<>(other.getFirst(), firstValue, secondValue, thirdValue, fourthValue, fifthValue, sixthValue);
    }

    /**
     * Prepends the values of the provided {@link Tuple2} to the beginning of this instance and returns a {@link Tuple8}.
     * 
     * @param <T7> Type of the first value contained in the {@link Tuple2} that will be prepended.
     * @param <T8> Type of the second value contained in the {@link Tuple2} that will be prepended.
     * @param other An instance of {@link Tuple2} containing the values of types {@code T7} and {@code T8} to be prepended.
     * @return A {@link Tuple8} containing the values from {@code other} and the values from this instance.
     */
    public <T7, T8> Tuple8<T7, T8, T1, T2, T3, T4, T5, T6> prepend(final Tuple2<T7, T8> other) {
        return new Tuple8<>(other.getFirst(), other.getSecond(), firstValue, secondValue, thirdValue, fourthValue, fifthValue, sixthValue);
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
        if (clazz.isAssignableFrom(sixthValue.getClass())) {
            final var cast = clazz.cast(sixthValue);
            return Optional.of(cast);
        }
        return Optional.empty();
    }

}

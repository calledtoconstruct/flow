package net.calledtoconstruct;

import java.util.Optional;

/**
 * An implementation of the Tuple interface which contains four elements of type T1, T2, T3 and T4.
 */
public class Tuple4<T1, T2, T3, T4> implements Tuple {

    private final T1 firstValue;
    private final T2 secondValue;
    private final T3 thirdValue;
    private final T4 fourthValue;

    /**
     * A constructor for the {@link Tuple4} class which accepts four values of types T1, T2, T3 and T4.
     */
    public Tuple4(T1 firstValue, T2 secondValue, T3 thirdValue, T4 fourthValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.thirdValue = thirdValue;
        this.fourthValue = fourthValue;
    }

    /**
     * A function that returns a new {@link Tuple5} containing 
     * the values of this instance plus the supplied {@code value}.
     * 
     * @param <T5> The type of {@code value} being added.
     * @param value A value to be added.
     * @return An instance of {@link Tuple5}
     */
    public <T5> Tuple5<T1, T2, T3, T4, T5> push(T5 value) {
        return new Tuple5<>(firstValue, secondValue, thirdValue, fourthValue, value);
    }

    /**
     * A function that returns a new instance of {@link Tuple3} containing the
     * first three values from this instance.
     * 
     * @return A {@link Tuple3} containing the first three values from this instance.
     */
    public Tuple3<T1, T2, T3> pop() {
        return new Tuple3<>(firstValue, secondValue, thirdValue);
    }

    /**
     * A function that returns a new instance of {@link Tuple3} containing the
     * last three values from this instance.
     * 
     * @return A {@link Tuple3} containing the last three values from this instance.
     */
    public Tuple3<T2, T3, T4> shift() {
        return new Tuple3<>(secondValue, thirdValue, fourthValue);
    }

    /**
     * A function that returns a new {@link Tuple5} containing 
     * the supplied {@code value} plus the values of this instance.
     * 
     * @param <T5> The type of {@code value} being added.
     * @param value A value to be added.
     * @return An instance of {@link Tuple5}
     */
    public <T5> Tuple5<T5, T1, T2, T3, T4> unshift(T5 value) {
        return new Tuple5<>(value, firstValue, secondValue, thirdValue, fourthValue);
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
     * Appends the value of the provided {@link Tuple1} to the end of this instance and returns a {@link Tuple5}.
     */
    public <T5> Tuple5<T1, T2, T3, T4, T5> append(final Tuple1<T5> other) {
        return new Tuple5<>(firstValue, secondValue, thirdValue, fourthValue, other.getFirst());
    }

    /**
     * Appends the values of the provided {@link Tuple2} to the end of this instance and returns a {@link Tuple6}.
     */
    public <T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> append(final Tuple2<T5, T6> other) {
        return new Tuple6<>(firstValue, secondValue, thirdValue, fourthValue, other.getFirst(), other.getSecond());
    }

    /**
     * Appends the values of the provided {@link Tuple3} to the end of this instance and returns a {@link Tuple7}.
     */
    public <T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7> append(final Tuple3<T5, T6, T7> other) {
        return new Tuple7<>(firstValue, secondValue, thirdValue, fourthValue, other.getFirst(), other.getSecond(), other.getThird());
    }

    /**
     * Appends the values of the provided {@link Tuple4} to the end of this instance and returns a {@link Tuple8}.
     */
    public <T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> append(final Tuple4<T5, T6, T7, T8> other) {
        return new Tuple8<>(firstValue, secondValue, thirdValue, fourthValue, other.getFirst(), other.getSecond(), other.getThird(), other.getFourth());
    }

    public <T5> Tuple5<T5, T1, T2, T3, T4> prepend(final Tuple1<T5> other) {
        return new Tuple5<>(other.getFirst(), firstValue, secondValue, thirdValue, fourthValue);
    }

    public <T5, T6> Tuple6<T5, T6, T1, T2, T3, T4> prepend(final Tuple2<T5, T6> other) {
        return new Tuple6<>(other.getFirst(), other.getSecond(), firstValue, secondValue, thirdValue, fourthValue);
    }

    public <T5, T6, T7> Tuple7<T5, T6, T7, T1, T2, T3, T4> prepend(final Tuple3<T5, T6, T7> other) {
        return new Tuple7<>(other.getFirst(), other.getSecond(), other.getThird(), firstValue, secondValue, thirdValue, fourthValue);
    }

    public <T5, T6, T7, T8> Tuple8<T5, T6, T7, T8, T1, T2, T3, T4> prepend(final Tuple4<T5, T6, T7, T8> other) {
        return new Tuple8<>(other.getFirst(), other.getSecond(), other.getThird(), other.getFourth(), firstValue, secondValue, thirdValue, fourthValue);
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
        if (clazz.isAssignableFrom(fourthValue.getClass())) {
            final var cast = clazz.cast(fourthValue);
            return Optional.of(cast);
        }
        return Optional.empty();
    }

}

package net.calledtoconstruct;

import java.util.Optional;

/**
 * An implementation of the Tuple interface which contains two elements of type T1 and T2.
 */
public class Tuple2<T1, T2> implements Tuple {
    
    private final T1 firstValue;
    private final T2 secondValue;

    /**
     * A constructor for the {@link Tuple2} class which accepts two values of types T1 and T2.
     */
    public Tuple2(T1 firstValue, T2 secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    /**
     * A function that returns a new {@link Tuple3} containing 
     * the values of this instance plus the supplied {@code value}.
     * 
     * @param <T> The type of {@code value} being added.
     * @param value A value to be added.
     * @return An instance of {@link Tuple3}
     */
    public <T> Tuple3<T1, T2, T> push(T value) {
        return new Tuple3<>(firstValue, secondValue, value);
    }

    /**
     * A function that returns a new instance of {@link Tuple1} containing the
     * first value from this instance.
     * 
     * @return A {@link Tuple1} containing the first value from this instance.
     */
    public Tuple1<T1> pop() {
        return new Tuple1<>(firstValue);
    }

    /**
     * A function that returns a new instance of {@link Tuple1} containing the
     * last value from this instance.
     * 
     * @return A {@link Tuple1} containing the last value from this instance.
     */
    public Tuple1<T2> shift() {
        return new Tuple1<>(secondValue);
    }

    /**
     * A function that returns a new {@link Tuple3} containing 
     * the supplied {@code value} plus the value of this instance.
     * 
     * @param <T> The type of {@code value} being added.
     * @param value A value to be added.
     * @return An instance of {@link Tuple3}
     */
    public <T> Tuple3<T, T1, T2> unshift(T value) {
        return new Tuple3<>(value, firstValue, secondValue);
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
     * Appends the value of the provided {@link Tuple1} to the end of this instance and returns a {@link Tuple3}.
     */
    public <T3> Tuple3<T1, T2, T3> append(final Tuple1<T3> other) {
        return new Tuple3<>(firstValue, secondValue, other.getFirst());
    }

    /**
     * Appends the values of the provided {@link Tuple2} to the end of this instance and returns a {@link Tuple4}.
     */
    public <T3, T4> Tuple4<T1, T2, T3, T4> append(final Tuple2<T3, T4> other) {
        return new Tuple4<>(firstValue, secondValue, other.getFirst(), other.getSecond());
    }

    /**
     * Appends the values of the provided {@link Tuple3} to the end of this instance and returns a {@link Tuple5}.
     */
    public <T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> append(final Tuple3<T3, T4, T5> other) {
        return new Tuple5<>(firstValue, secondValue, other.getFirst(), other.getSecond(), other.getThird());
    }

    /**
     * Appends the values of the provided {@link Tuple4} to the end of this instance and returns a {@link Tuple6}.
     */
    public <T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> append(final Tuple4<T3, T4, T5, T6> other) {
        return new Tuple6<>(firstValue, secondValue, other.getFirst(), other.getSecond(), other.getThird(), other.getFourth());
    }

    /**
     * Appends the values of the provided {@link Tuple5} to the end of this instance and returns a {@link Tuple7}.
     */
    public <T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7> append(final Tuple5<T3, T4, T5, T6, T7> other) {
        return new Tuple7<>(firstValue, secondValue, other.getFirst(), other.getSecond(), other.getThird(), other.getFourth(), other.getFifth());
    }

    /**
     * Appends the values of the provided {@link Tuple6} to the end of this instance and returns a {@link Tuple8}.
     */
    public <T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> append(final Tuple6<T3, T4, T5, T6, T7, T8> other) {
        return new Tuple8<>(firstValue, secondValue, other.getFirst(), other.getSecond(), other.getThird(), other.getFourth(), other.getFifth(), other.getSixth());
    }

    /**
     * Prepends the value of the provided {@link Tuple1} to the beginning of this instance and returns a {@link Tuple3}.
     */
    public <T3> Tuple3<T3, T1, T2> prepend(final Tuple1<T3> other) {
        return new Tuple3<>(other.getFirst(), firstValue, secondValue);
    }

    /**
     * Prepends the values of the provided {@link Tuple2} to the beginning of this instance and returns a {@link Tuple4}.
     */
    public <T3, T4> Tuple4<T3, T4, T1, T2> prepend(final Tuple2<T3, T4> other) {
        return new Tuple4<>(other.getFirst(), other.getSecond(), firstValue, secondValue);
    }

    /**
     * Prepends the values of the provided {@link Tuple3} to the beginning of this instance and returns a {@link Tuple5}.
     */
    public <T3, T4, T5> Tuple5<T3, T4, T5, T1, T2> prepend(final Tuple3<T3, T4, T5> other) {
        return new Tuple5<>(other.getFirst(), other.getSecond(), other.getThird(), firstValue, secondValue);
    }

    /**
     * Prepends the values of the provided {@link Tuple4} to the beginning of this instance and returns a {@link Tuple6}.
     */
    public <T3, T4, T5, T6> Tuple6<T3, T4, T5, T6, T1, T2> prepend(final Tuple4<T3, T4, T5, T6> other) {
        return new Tuple6<>(other.getFirst(), other.getSecond(), other.getThird(), other.getFourth(), firstValue, secondValue);
    }

    /**
     * Prepends the values of the provided {@link Tuple5} to the beginning of this instance and returns a {@link Tuple7}.
     */
    public <T3, T4, T5, T6, T7> Tuple7<T3, T4, T5, T6, T7, T1, T2> prepend(final Tuple5<T3, T4, T5, T6, T7> other) {
        return new Tuple7<>(other.getFirst(), other.getSecond(), other.getThird(), other.getFourth(), other.getFifth(), firstValue, secondValue);
    }

    /**
     * Prepends the values of the provided {@link Tuple6} to the beginning of this instance and returns a {@link Tuple8}.
     */
    public <T3, T4, T5, T6, T7, T8> Tuple8<T3, T4, T5, T6, T7, T8, T1, T2> prepend(final Tuple6<T3, T4, T5, T6, T7, T8> other) {
        return new Tuple8<>(other.getFirst(), other.getSecond(), other.getThird(), other.getFourth(), other.getFifth(), other.getSixth(), firstValue, secondValue);
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
        if (clazz.isAssignableFrom(secondValue.getClass())) {
            final var cast = clazz.cast(secondValue);
            return Optional.of(cast);
        }
        return Optional.empty();
    }

}

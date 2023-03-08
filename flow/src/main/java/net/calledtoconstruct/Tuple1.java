package net.calledtoconstruct;

import java.util.Optional;

/**
 * An implementation of the Tuple interface which contains a single element of type T1.
 */
public class Tuple1<T1> implements Tuple {
    private final T1 firstValue;
    
    /**
     * A constructor for the {@link Tuple1} class which accepts a single value of type T1.
     * 
     * @param value The value to be stored.
     */
    public Tuple1(T1 value) {
        this.firstValue = value;
    }

    /**
     * A function that returns the value from this instance.
     * 
     * @return A value of type {@code T1}
     */
    public T1 getFirst() {
        return this.firstValue;
    }

    /**
     * A function that returns a new {@link Tuple2} containing 
     * the value of this instance plus the supplied {@code value}.
     * 
     * @param <T> The type of {@code value} being added.
     * @param value A value to be added.
     * @return An instance of {@link Tuple2}
     */
    public <T> Tuple2<T1, T> push(final T value) {
        return new Tuple2<>(this.firstValue, value);
    }

    /**
     * A function that returns a new {@link Tuple2} containing 
     * the supplied {@code value} plus the value of this instance.
     * 
     * @param <T> The type of {@code value} being added.
     * @param value A value to be added.
     * @return An instance of {@link Tuple2}
     */
    public <T> Tuple2<T, T1> unshift(final T value) {
        return new Tuple2<>(value, this.firstValue);
    }

    @Override
    public Optional<Tuple> tryPop() {
        return Optional.empty();
    }

    @Override
    public <T> Optional<Tuple> tryPush(T value) {
        return Optional.of(push(value));
    }

    @Override
    public Optional<Tuple> tryShift() {
        return Optional.empty();
    }

    @Override
    public <T> Optional<Tuple> tryUnshift(T value) {
        return Optional.of(unshift(value));
    }

    /**
     * Appends the value of the provided {@link Tuple1} to the end of this instance and returns a {@link Tuple2}.
     * 
     * @param <T2> Type of the first value contained in the {@link Tuple1} that will be appended.
     * @param other An instance of {@link Tuple1} containing the value of type {@code T2} to be appended.
     * @return A {@link Tuple2} containing the values from this instance and the values from {@code other}.
     */
    public <T2> Tuple2<T1, T2> append(final Tuple1<T2> other) {
        return new Tuple2<>(firstValue, other.getFirst());
    }

    /**
     * Appends the values of the provided {@link Tuple2} to the end of this instance and returns a {@link Tuple3}.
     * 
     * @param <T2> Type of the first value contained in the {@link Tuple2} that will be appended.
     * @param <T3> Type of the second value contained in the {@link Tuple2} that will be appended.
     * @param other An instance of {@link Tuple2} containing the values of types {@code T2} and {@code T3} to be appended.
     * @return A {@link Tuple3} containing the values from this instance and the values from {@code other}.
     */
    public <T2, T3> Tuple3<T1, T2, T3> append(final Tuple2<T2, T3> other) {
        return new Tuple3<>(firstValue, other.getFirst(), other.getSecond());
    }

    /**
     * Appends the values of the provided {@link Tuple3} to the end of this instance and returns a {@link Tuple4}.
     * 
     * @param <T2> Type of the first value contained in the {@link Tuple3} that will be appended.
     * @param <T3> Type of the second value contained in the {@link Tuple3} that will be appended.
     * @param <T4> Type of the third value contained in the {@link Tuple3} that will be appended.
     * @param other An instance of {@link Tuple3} containing the values of types {@code T2}, {@code T3} and {@code T4} to be appended.
     * @return A {@link Tuple4} containing the values from this instance and the values from {@code other}.
     */
    public <T2, T3, T4> Tuple4<T1, T2, T3, T4> append(final Tuple3<T2, T3, T4> other) {
        return new Tuple4<>(firstValue, other.getFirst(), other.getSecond(), other.getThird());
    }

    /**
     * Appends the values of the provided {@link Tuple4} to the end of this instance and returns a {@link Tuple5}.
     * 
     * @param <T2> Type of the first value contained in the {@link Tuple4} that will be appended.
     * @param <T3> Type of the second value contained in the {@link Tuple4} that will be appended.
     * @param <T4> Type of the third value contained in the {@link Tuple4} that will be appended.
     * @param <T5> Type of the fourth value contained in the {@link Tuple4} that will be appended.
     * @param other An instance of {@link Tuple4} containing the values of types {@code T2}, {@code T3}, {@code T4} and {@code T5} to be appended.
     * @return A {@link Tuple5} containing the values from this instance and the values from {@code other}.
     */
    public <T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> append(final Tuple4<T2, T3, T4, T5> other) {
        return new Tuple5<>(firstValue, other.getFirst(), other.getSecond(), other.getThird(), other.getFourth());
    }

    /**
     * Appends the values of the provided {@link Tuple5} to the end of this instance and returns a {@link Tuple6}.
     * 
     * @param <T2> Type of the first value contained in the {@link Tuple5} that will be appended.
     * @param <T3> Type of the second value contained in the {@link Tuple5} that will be appended.
     * @param <T4> Type of the third value contained in the {@link Tuple5} that will be appended.
     * @param <T5> Type of the fourth value contained in the {@link Tuple5} that will be appended.
     * @param <T6> Type of the fifth value contained in the {@link Tuple5} that will be appended.
     * @param other An instance of {@link Tuple5} containing the values of types {@code T2}, {@code T3}, {@code T4}, {@code T5} and {@code T6} to be appended.
     * @return A {@link Tuple6} containing the values from this instance and the values from {@code other}.
     */
    public <T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> append(final Tuple5<T2, T3, T4, T5, T6> other) {
        return new Tuple6<>(firstValue, other.getFirst(), other.getSecond(), other.getThird(), other.getFourth(), other.getFifth());
    }

    /**
     * Appends the values of the provided {@link Tuple6} to the end of this instance and returns a {@link Tuple7}.
     * 
     * @param <T2> Type of the first value contained in the {@link Tuple6} that will be appended.
     * @param <T3> Type of the second value contained in the {@link Tuple6} that will be appended.
     * @param <T4> Type of the third value contained in the {@link Tuple6} that will be appended.
     * @param <T5> Type of the fourth value contained in the {@link Tuple6} that will be appended.
     * @param <T6> Type of the fifth value contained in the {@link Tuple6} that will be appended.
     * @param <T7> Type of the sixth value contained in the {@link Tuple6} that will be appended.
     * @param other An instance of {@link Tuple6} containing the values of types {@code T2}, {@code T3}, {@code T4}, {@code T5}, {@code T6} and {@code T7} to be appended.
     * @return A {@link Tuple7} containing the values from this instance and the values from {@code other}.
     */
    public <T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7> append(final Tuple6<T2, T3, T4, T5, T6, T7> other) {
        return new Tuple7<>(firstValue, other.getFirst(), other.getSecond(), other.getThird(), other.getFourth(), other.getFifth(), other.getSixth());
    }

    /**
     * Appends the values of the provided {@link Tuple7} to the end of this instance and returns a {@link Tuple8}.
     * 
     * @param <T2> Type of the first value contained in the {@link Tuple7} that will be appended.
     * @param <T3> Type of the second value contained in the {@link Tuple7} that will be appended.
     * @param <T4> Type of the third value contained in the {@link Tuple7} that will be appended.
     * @param <T5> Type of the fourth value contained in the {@link Tuple7} that will be appended.
     * @param <T6> Type of the fifth value contained in the {@link Tuple7} that will be appended.
     * @param <T7> Type of the sixth value contained in the {@link Tuple7} that will be appended.
     * @param <T8> Type of the seventh value contained in the {@link Tuple7} that will be appended.
     * @param other An instance of {@link Tuple7} containing the values of types {@code T2}, {@code T3}, {@code T4}, {@code T5}, {@code T6}, {@code T7} and {@code T8} to be appended.
     * @return A {@link Tuple8} containing the values from this instance and the values from {@code other}.
     */
    public <T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> append(final Tuple7<T2, T3, T4, T5, T6, T7, T8> other) {
        return new Tuple8<>(firstValue, other.getFirst(), other.getSecond(), other.getThird(), other.getFourth(), other.getFifth(), other.getSixth(), other.getSeventh());
    }

    /**
     * Prepends the value of the provided {@link Tuple1} to the beginning of this instance and returns a {@link Tuple2}.
     * 
     * @param <T2> Type of the first value contained in the {@link Tuple1} that will be prepended.
     * @param other An instance of {@link Tuple1} containing the value of type {@code T2} and {@code T3} to be prepended.
     * @return A {@link Tuple3} containing the values from {@code other} and the values from this instance.
     */
    public <T2> Tuple2<T2, T1> prepend(final Tuple1<T2> other) {
        return new Tuple2<>(other.getFirst(), firstValue);
    }

    /**
     * Prepends the values of the provided {@link Tuple2} to the beginning of this instance and returns a {@link Tuple3}.
     * 
     * @param <T2> Type of the first value contained in the {@link Tuple2} that will be prepended.
     * @param <T3> Type of the second value contained in the {@link Tuple2} that will be prepended.
     * @param other An instance of {@link Tuple2} containing the values of types {@code T2}, {@code T3} and {@code T4} to be prepended.
     * @return A {@link Tuple4} containing the values from {@code other} and the values from this instance.
     */
    public <T2, T3> Tuple3<T2, T3, T1> prepend(final Tuple2<T2, T3> other) {
        return new Tuple3<>(other.getFirst(), other.getSecond(), firstValue);
    }

    /**
     * Prepends the values of the provided {@link Tuple3} to the beginning of this instance and returns a {@link Tuple4}.
     * 
     * @param <T2> Type of the first value contained in the {@link Tuple3} that will be prepended.
     * @param <T3> Type of the second value contained in the {@link Tuple3} that will be prepended.
     * @param <T4> Type of the third value contained in the {@link Tuple3} that will be prepended.
     * @param other An instance of {@link Tuple3} containing the values of types {@code T2}, {@code T3} and {@code T4} to be prepended.
     * @return A {@link Tuple4} containing the values from {@code other} and the values from this instance.
     */
    public <T2, T3, T4> Tuple4<T2, T3, T4, T1> prepend(final Tuple3<T2, T3, T4> other) {
        return new Tuple4<>(other.getFirst(), other.getSecond(), other.getThird(), firstValue);
    }

    /**
     * Prepends the values of the provided {@link Tuple4} to the beginning of this instance and returns a {@link Tuple5}.
     * 
     * @param <T2> Type of the first value contained in the {@link Tuple4} that will be prepended.
     * @param <T3> Type of the second value contained in the {@link Tuple4} that will be prepended.
     * @param <T4> Type of the third value contained in the {@link Tuple4} that will be prepended.
     * @param <T5> Type of the fourth value contained in the {@link Tuple4} that will be prepended.
     * @param other An instance of {@link Tuple4} containing the values of types {@code T2}, {@code T3}, {@code T4} and {@code T5} to be prepended.
     * @return A {@link Tuple5} containing the values from {@code other} and the values from this instance.
     */
    public <T2, T3, T4, T5> Tuple5<T2, T3, T4, T5, T1> prepend(final Tuple4<T2, T3, T4, T5> other) {
        return new Tuple5<>(other.getFirst(), other.getSecond(), other.getThird(), other.getFourth(), firstValue);
    }

    /**
     * Prepends the values of the provided {@link Tuple5} to the beginning of this instance and returns a {@link Tuple6}.
     * 
     * @param <T2> Type of the first value contained in the {@link Tuple5} that will be prepended.
     * @param <T3> Type of the second value contained in the {@link Tuple5} that will be prepended.
     * @param <T4> Type of the third value contained in the {@link Tuple5} that will be prepended.
     * @param <T5> Type of the fourth value contained in the {@link Tuple5} that will be prepended.
     * @param <T6> Type of the fifth value contained in the {@link Tuple5} that will be prepended.
     * @param other An instance of {@link Tuple5} containing the values of types {@code T2}, {@code T3}, {@code T4}, {@code T5} and {@code T6} to be prepended.
     * @return A {@link Tuple6} containing the values from {@code other} and the values from this instance.
     */
    public <T2, T3, T4, T5, T6> Tuple6<T2, T3, T4, T5, T6, T1> prepend(final Tuple5<T2, T3, T4, T5, T6> other) {
        return new Tuple6<>(other.getFirst(), other.getSecond(), other.getThird(), other.getFourth(), other.getFifth(), firstValue);
    }

    /**
     * Prepends the values of the provided {@link Tuple6} to the beginning of this instance and returns a {@link Tuple7}.
     * 
     * @param <T2> Type of the first value contained in the {@link Tuple6} that will be prepended.
     * @param <T3> Type of the second value contained in the {@link Tuple6} that will be prepended.
     * @param <T4> Type of the third value contained in the {@link Tuple6} that will be prepended.
     * @param <T5> Type of the fourth value contained in the {@link Tuple6} that will be prepended.
     * @param <T6> Type of the fifth value contained in the {@link Tuple6} that will be prepended.
     * @param <T7> Type of the sixth value contained in the {@link Tuple6} that will be prepended.
     * @param other An instance of {@link Tuple6} containing the values of types {@code T2}, {@code T3}, {@code T4}, {@code T5}, {@code T6} and {@code T7} to be prepended.
     * @return A {@link Tuple7} containing the values from {@code other} and the values from this instance.
     */
    public <T2, T3, T4, T5, T6, T7> Tuple7<T2, T3, T4, T5, T6, T7, T1> prepend(final Tuple6<T2, T3, T4, T5, T6, T7> other) {
        return new Tuple7<>(other.getFirst(), other.getSecond(), other.getThird(), other.getFourth(), other.getFifth(), other.getSixth(), firstValue);
    }

    /**
     * Prepends the values of the provided {@link Tuple7} to the beginning of this instance and returns a {@link Tuple8}.
     * 
     * @param <T2> Type of the first value contained in the {@link Tuple7} that will be prepended.
     * @param <T3> Type of the second value contained in the {@link Tuple7} that will be prepended.
     * @param <T4> Type of the third value contained in the {@link Tuple7} that will be prepended.
     * @param <T5> Type of the fourth value contained in the {@link Tuple7} that will be prepended.
     * @param <T6> Type of the fifth value contained in the {@link Tuple7} that will be prepended.
     * @param <T7> Type of the sixth value contained in the {@link Tuple7} that will be prepended.
     * @param <T8> Type of the seventh value contained in the {@link Tuple7} that will be prepended.
     * @param other An instance of {@link Tuple7} containing the values of types {@code T2}, {@code T3}, {@code T4}, {@code T5}, {@code T6}, {@code T7} and {@code T8} to be prepended.
     * @return A {@link Tuple8} containing the values from {@code other} and the values from this instance.
     */
    public <T2, T3, T4, T5, T6, T7, T8> Tuple8<T2, T3, T4, T5, T6, T7, T8, T1> prepend(final Tuple7<T2, T3, T4, T5, T6, T7, T8> other) {
        return new Tuple8<>(other.getFirst(), other.getSecond(), other.getThird(), other.getFourth(), other.getFifth(), other.getSixth(), other.getSeventh(), firstValue);
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
        if (clazz.isAssignableFrom(firstValue.getClass())) {
            final var cast = clazz.cast(firstValue);
            return Optional.of(cast);
        }
        return Optional.empty();
    }

}

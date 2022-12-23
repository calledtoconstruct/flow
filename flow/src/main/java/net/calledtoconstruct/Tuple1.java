package net.calledtoconstruct;

import java.util.Optional;

public class Tuple1<T1> implements Tuple {
    private final T1 firstValue;
    
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

    public <T2> Tuple2<T1, T2> append(final Tuple1<T2> other) {
        return new Tuple2<>(firstValue, other.getFirst());
    }

    public <T2, T3> Tuple3<T1, T2, T3> append(final Tuple2<T2, T3> other) {
        return new Tuple3<>(firstValue, other.getFirst(), other.getSecond());
    }

    public <T2, T3, T4> Tuple4<T1, T2, T3, T4> append(final Tuple3<T2, T3, T4> other) {
        return new Tuple4<>(firstValue, other.getFirst(), other.getSecond(), other.getThird());
    }

    public <T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> append(final Tuple4<T2, T3, T4, T5> other) {
        return new Tuple5<>(firstValue, other.getFirst(), other.getSecond(), other.getThird(), other.getFourth());
    }

    public <T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> append(final Tuple5<T2, T3, T4, T5, T6> other) {
        return new Tuple6<>(firstValue, other.getFirst(), other.getSecond(), other.getThird(), other.getFourth(), other.getFifth());
    }

    public <T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7> append(final Tuple6<T2, T3, T4, T5, T6, T7> other) {
        return new Tuple7<>(firstValue, other.getFirst(), other.getSecond(), other.getThird(), other.getFourth(), other.getFifth(), other.getSixth());
    }

    public <T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> append(final Tuple7<T2, T3, T4, T5, T6, T7, T8> other) {
        return new Tuple8<>(firstValue, other.getFirst(), other.getSecond(), other.getThird(), other.getFourth(), other.getFifth(), other.getSixth(), other.getSeventh());
    }

}

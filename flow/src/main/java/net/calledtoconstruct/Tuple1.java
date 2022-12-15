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

}
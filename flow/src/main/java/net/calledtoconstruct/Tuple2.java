package net.calledtoconstruct;

import java.util.Optional;

public class Tuple2<T1, T2> implements Tuple {
    
    private final T1 firstValue;
    private final T2 secondValue;

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

}
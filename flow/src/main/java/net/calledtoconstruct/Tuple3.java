package net.calledtoconstruct;

import java.util.Optional;

public class Tuple3<T1, T2, T3> implements Tuple {

    private final T1 firstValue;
    private final T2 secondValue;
    private final T3 thirdValue;

    public Tuple3(T1 firstValue, T2 secondValue, T3 thirdValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.thirdValue = thirdValue;
    }

    /**
     * A function that returns a new {@link Tuple4} containing 
     * the values of this instance plus the supplied {@code value}.
     * 
     * @param <T4> The type of {@code value} being added.
     * @param value A value to be added.
     * @return An instance of {@link Tuple4}
     */
    public <T4> Tuple4<T1, T2, T3, T4> push(T4 value) {
        return new Tuple4<>(firstValue, secondValue, thirdValue, value);
    }

    /**
     * A function that returns a new instance of {@link Tuple2} containing the
     * first two values from this instance.
     * 
     * @return A {@link Tuple2} containing the first two values from this instance.
     */
    public Tuple2<T1, T2> pop() {
        return new Tuple2<>(firstValue, secondValue);
    }

    /**
     * A function that returns a new instance of {@link Tuple2} containing the
     * last two values from this instance.
     * 
     * @return A {@link Tuple2} containing the last two values from this instance.
     */
    public Tuple2<T2, T3> shift() {
        return new Tuple2<>(secondValue, thirdValue);
    }

    /**
     * A function that returns a new {@link Tuple4} containing 
     * the supplied {@code value} plus the values of this instance.
     * 
     * @param <T4> The type of {@code value} being added.
     * @param value A value to be added.
     * @return An instance of {@link Tuple4}
     */
    public <T4> Tuple4<T4, T1, T2, T3> unshift(T4 value) {
        return new Tuple4<>(value, firstValue, secondValue, thirdValue);
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

}
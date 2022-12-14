package net.calledtoconstruct;

import java.util.Optional;

public class Tuple4<T1, T2, T3, T4> implements Tuple {

    private final T1 firstValue;
    private final T2 secondValue;
    private final T3 thirdValue;
    private final T4 fourthValue;

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

}
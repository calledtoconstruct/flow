package net.calledtoconstruct;

import java.util.Optional;

public class Tuple6<T1, T2, T3, T4, T5, T6> implements Tuple {

    private final T1 firstValue;
    private final T2 secondValue;
    private final T3 thirdValue;
    private final T4 fourthValue;
    private final T5 fifthValue;
    private final T6 sixthValue;

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

}
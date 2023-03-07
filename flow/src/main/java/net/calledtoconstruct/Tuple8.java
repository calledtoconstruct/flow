package net.calledtoconstruct;

import java.util.Optional;

/**
 * An implementation of the Tuple interface which contains eight elements of type T1, T2, T3, T4, T5, T6, T7 and T8.
 */
public class Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> implements Tuple {

    private final T1 firstValue;
    private final T2 secondValue;
    private final T3 thirdValue;
    private final T4 fourthValue;
    private final T5 fifthValue;
    private final T6 sixthValue;
    private final T7 seventhValue;
    private final T8 eighthValue;

    /**
     * A constructor for the {@link Tuple8} class which accepts eight values of types T1, T2, T3, T4, T5, T6, T7 and T8.
     */
    public Tuple8(T1 firstValue, T2 secondValue, T3 thirdValue, T4 fourthValue, T5 fifthValue, T6 sixthValue, T7 seventhValue, T8 eighthValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.thirdValue = thirdValue;
        this.fourthValue = fourthValue;
        this.fifthValue = fifthValue;
        this.sixthValue = sixthValue;
        this.seventhValue = seventhValue;
        this.eighthValue = eighthValue;
    }

    /**
     * A function that returns a new instance of {@link Tuple7} containing the
     * first seven values from this instance.
     * 
     * @return A {@link Tuple7} containing the first seven values from this instance.
     */
    public Tuple7<T1, T2, T3, T4, T5, T6, T7> pop() {
        return new Tuple7<>(firstValue, secondValue, thirdValue, fourthValue, fifthValue, sixthValue, seventhValue);
    }

    /**
     * A function that returns a new instance of {@link Tuple7} containing the
     * last seven values from this instance.
     * 
     * @return A {@link Tuple7} containing the last seven values from this instance.
     */
    public Tuple7<T2, T3, T4, T5, T6, T7, T8> shift() {
        return new Tuple7<>(secondValue, thirdValue, fourthValue, fifthValue, sixthValue, seventhValue, eighthValue);
    }

    @Override
    public Optional<Tuple> tryPop() {
        return Optional.of(pop());
    }

    @Override
    public <T> Optional<Tuple> tryPush(T value) {
        return Optional.empty();
    }

    @Override
    public Optional<Tuple> tryShift() {
        return Optional.of(shift());
    }

    @Override
    public <T> Optional<Tuple> tryUnshift(T value) {
        return Optional.empty();
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
     * A function that returns the seventh value from this instance.
     * 
     * @return A value of type {@code T7}
     */
    public T7 getSeventh() {
        return seventhValue;
    }

    /**
     * A function that returns the eighth value from this instance.
     * 
     * @return A value of type {@code T8}
     */
    public T8 getEighth() {
        return eighthValue;
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
        if (clazz.isAssignableFrom(eighthValue.getClass())) {
            final var cast = clazz.cast(eighthValue);
            return Optional.of(cast);
        }
        return Optional.empty();
    }

}
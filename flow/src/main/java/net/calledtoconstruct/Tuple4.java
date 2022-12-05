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

    public Tuple3<T1, T2, T3> pop() {
        return new Tuple3<>(firstValue, secondValue, thirdValue);
    }

    public Tuple3<T2, T3, T4> shift() {
        return new Tuple3<>(secondValue, thirdValue, fourthValue);
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

    public T1 getFirst() {
        return firstValue;
    }

    public T2 getSecond() {
        return secondValue;
    }

    public T3 getThird() {
        return thirdValue;
    }

    public T4 getFourth() {
        return fourthValue;
    }

}
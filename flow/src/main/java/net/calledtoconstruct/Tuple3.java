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

    public <T4> Tuple4<T1, T2, T3, T4> push(T4 value) {
        return new Tuple4<>(firstValue, secondValue, thirdValue, value);
    }

    public Tuple2<T1, T2> pop() {
        return new Tuple2<>(firstValue, secondValue);
    }

    public Tuple2<T2, T3> shift() {
        return new Tuple2<>(secondValue, thirdValue);
    }

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

    public T1 getFirst() {
        return firstValue;
    }

    public T2 getSecond() {
        return secondValue;
    }

    public T3 getThird() {
        return thirdValue;
    }

}
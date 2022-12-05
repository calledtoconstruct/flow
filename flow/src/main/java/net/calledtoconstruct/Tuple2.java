package net.calledtoconstruct;

import java.util.Optional;

public class Tuple2<T1, T2> implements Tuple {
    
    private final T1 firstValue;
    private final T2 secondValue;

    public Tuple2(T1 firstValue, T2 secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public <T> Tuple3<T1, T2, T> push(T value) {
        return new Tuple3<>(firstValue, secondValue, value);
    }

    public Tuple1<T1> pop() {
        return new Tuple1<>(firstValue);
    }

    public Tuple1<T2> shift() {
        return new Tuple1<>(secondValue);
    }

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

    public T1 getFirst() {
        return firstValue;
    }

    public T2 getSecond() {
        return secondValue;
    }

}
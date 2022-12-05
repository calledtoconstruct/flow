package net.calledtoconstruct;

import java.util.Optional;

public class Tuple1<T1> implements Tuple {
    private final T1 firstValue;
    
    public Tuple1(T1 value) {
        this.firstValue = value;
    }

    public T1 getFirst() {
        return this.firstValue;
    }

    public <T> Tuple2<T1, T> push(final T value) {
        return new Tuple2<T1, T>(this.firstValue, value);
    }

    public <T> Tuple2<T, T1> unshift(final T value) {
        return new Tuple2<T, T1>(value, this.firstValue);
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
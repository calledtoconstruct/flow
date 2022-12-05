package net.calledtoconstruct;

import java.util.Optional;

public interface Tuple {
    Optional<Tuple> tryPop();
    <T> Optional<Tuple> tryPush(T value);
    Optional<Tuple> tryShift();
    <T> Optional<Tuple> tryUnshift(T value);
}

package net.calledtoconstruct;

import java.util.Optional;

public interface Tuple {
    /**
     * A function that returns a new {@link java.util.Optional} of {@link Tuple} containing 
     * the values of this instance minus the last one, or an empty {@link java.util.Optional}
     * of {@link Tuple} if only a single value was present.
     * 
     * @return When the source {@link Tuple} contains two more more values, {@link java.util.Optional} of {@link Tuple}, else
     * and empty {@link java.util.Optional} of {@link Tuple}
     */
    Optional<Tuple> tryPop();

    /**
     * A function that returns a new {@link java.util.Optional} of {@link Tuple} containing
     * the values of this instance plus the supplied {@code value}.  However, if adding the
     * value exceeds the available {@link Tuple} classes, then an empty {@link java.util.Optional}
     * is returned. 
     * 
     * @param <T> The type of the {@code value} being added.
     * @param value The value being added.
     * @return A new {@link java.util.Optional} of {@link Tuple}, or an empty {@link java.util.Optional}
     */
    <T> Optional<Tuple> tryPush(T value);

    /**
     * A function that returns a new {@link java.util.Optional} of {@link Tuple} containing 
     * the values of this instance minus the first one, or an empty {@link java.util.Optional}
     * of {@link Tuple} if only a single value was present.
     * 
     * @return When the source {@link Tuple} contains two more more values, {@link java.util.Optional} of {@link Tuple}, else
     * and empty {@link java.util.Optional} of {@link Tuple}
     */
    Optional<Tuple> tryShift();

    /**
     * A function that returns a new {@link java.util.Optional} of {@link Tuple} containing
     * the values of this instance plus the supplied {@code value} prepended as the first value.  However,
     * if adding the value exceeds the available {@link Tuple} classes, then an empty {@link java.util.Optional}
     * is returned. 
     * 
     * @param <T> The type of the {@code value} being added.
     * @param value The value being added.
     * @return A new {@link java.util.Optional} of {@link Tuple}, or an empty {@link java.util.Optional}
     */
    <T> Optional<Tuple> tryUnshift(T value);
}

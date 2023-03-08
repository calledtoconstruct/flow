package net.calledtoconstruct;

import java.lang.reflect.Array;
import java.util.Optional;

/**
 * The tuple interface provides the definition for functions common to all Tuple\<...\> implementations.
 */
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
    <T> Optional<Tuple> tryPush(final T value);

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
    <T> Optional<Tuple> tryUnshift(final T value);

    /**
     * Converts a Tuple1\<T\> instance to an array of type T
     * 
     * @param <T> The type of the value to be extracted.
     * @param tuple The {@link Tuple} containing the value to be extracted.
     * @param clazz The {@link java.lang.Class} of the value to be extracted.
     * @return An array of type T containing the value from the source {@code tuple}.
     */
    static <T> T[] toArray(final Tuple1<T> tuple, final Class<T> clazz) {
        final var array = Array.newInstance(clazz, 1);
        Array.set(array, 0, tuple.getFirst());
        return (T[]) array;
    }

    /**
     * Converts a Tuple2\<T\> instance to an array of type T
     * 
     * @param <T> The type of the values to be extracted.
     * @param tuple The {@link Tuple} containing the values to be extracted.
     * @param clazz The {@link java.lang.Class} of the values to be extracted.
     * @return An array of type T containing the values from the source {@code tuple}.
     */
    static <T> T[] toArray(final Tuple2<T, T> tuple, final Class<T> clazz) {
        final var array = Array.newInstance(clazz, 2);
        Array.set(array, 0, tuple.getFirst());
        Array.set(array, 1, tuple.getSecond());
        return (T[]) array;
    }

    /**
     * Converts a Tuple3\<T\> instance to an array of type T
     * 
     * @param <T> The type of the values to be extracted.
     * @param tuple The {@link Tuple} containing the values to be extracted.
     * @param clazz The {@link java.lang.Class} of the values to be extracted.
     * @return An array of type T containing the values from the source {@code tuple}.
     */
    static <T> T[] toArray(final Tuple3<T, T, T> tuple, final Class<T> clazz) {
        final var array = Array.newInstance(clazz, 3);
        Array.set(array, 0, tuple.getFirst());
        Array.set(array, 1, tuple.getSecond());
        Array.set(array, 2, tuple.getThird());
        return (T[]) array;
    }

    /**
     * Converts a Tuple4\<T\> instance to an array of type T
     * 
     * @param <T> The type of the values to be extracted.
     * @param tuple The {@link Tuple} containing the values to be extracted.
     * @param clazz The {@link java.lang.Class} of the values to be extracted.
     * @return An array of type T containing the values from the source {@code tuple}.
     */
    static <T> T[] toArray(final Tuple4<T, T, T, T> tuple, final Class<T> clazz) {
        final var array = Array.newInstance(clazz, 4);
        Array.set(array, 0, tuple.getFirst());
        Array.set(array, 1, tuple.getSecond());
        Array.set(array, 2, tuple.getThird());
        Array.set(array, 3, tuple.getFourth());
        return (T[]) array;
    }

    /**
     * Converts a Tuple5\<T\> instance to an array of type T
     * 
     * @param <T> The type of the values to be extracted.
     * @param tuple The {@link Tuple} containing the values to be extracted.
     * @param clazz The {@link java.lang.Class} of the values to be extracted.
     * @return An array of type T containing the values from the source {@code tuple}.
     */
    static <T> T[] toArray(final Tuple5<T, T, T, T, T> tuple, final Class<T> clazz) {
        final var array = Array.newInstance(clazz, 5);
        Array.set(array, 0, tuple.getFirst());
        Array.set(array, 1, tuple.getSecond());
        Array.set(array, 2, tuple.getThird());
        Array.set(array, 3, tuple.getFourth());
        Array.set(array, 4, tuple.getFifth());
        return (T[]) array;
    }

    /**
     * Converts a Tuple6\<T\> instance to an array of type T
     * 
     * @param <T> The type of the values to be extracted.
     * @param tuple The {@link Tuple} containing the values to be extracted.
     * @param clazz The {@link java.lang.Class} of the values to be extracted.
     * @return An array of type T containing the values from the source {@code tuple}.
     */
    static <T> T[] toArray(final Tuple6<T, T, T, T, T, T> tuple, final Class<T> clazz) {
        final var array = Array.newInstance(clazz, 6);
        Array.set(array, 0, tuple.getFirst());
        Array.set(array, 1, tuple.getSecond());
        Array.set(array, 2, tuple.getThird());
        Array.set(array, 3, tuple.getFourth());
        Array.set(array, 4, tuple.getFifth());
        Array.set(array, 5, tuple.getSixth());
        return (T[]) array;
    }

    /**
     * Converts a Tuple7\<T\> instance to an array of type T
     * 
     * @param <T> The type of the values to be extracted.
     * @param tuple The {@link Tuple} containing the values to be extracted.
     * @param clazz The {@link java.lang.Class} of the values to be extracted.
     * @return An array of type T containing the values from the source {@code tuple}.
     */
    static <T> T[] toArray(final Tuple7<T, T, T, T, T, T, T> tuple, final Class<T> clazz) {
        final var array = Array.newInstance(clazz, 7);
        Array.set(array, 0, tuple.getFirst());
        Array.set(array, 1, tuple.getSecond());
        Array.set(array, 2, tuple.getThird());
        Array.set(array, 3, tuple.getFourth());
        Array.set(array, 4, tuple.getFifth());
        Array.set(array, 5, tuple.getSixth());
        Array.set(array, 6, tuple.getSeventh());
        return (T[]) array;
    }

    /**
     * Converts a Tuple8\<T\> instance to an array of type T
     * 
     * @param <T> The type of the values to be extracted.
     * @param tuple The {@link Tuple} containing the values to be extracted.
     * @param clazz The {@link java.lang.Class} of the values to be extracted.
     * @return An array of type T containing the values from the source {@code tuple}.
     */
    static <T> T[] toArray(final Tuple8<T, T, T, T, T, T, T, T> tuple, final Class<T> clazz) {
        final var array = Array.newInstance(clazz, 8);
        Array.set(array, 0, tuple.getFirst());
        Array.set(array, 1, tuple.getSecond());
        Array.set(array, 2, tuple.getThird());
        Array.set(array, 3, tuple.getFourth());
        Array.set(array, 4, tuple.getFifth());
        Array.set(array, 5, tuple.getSixth());
        Array.set(array, 6, tuple.getSeventh());
        Array.set(array, 7, tuple.getEighth());
        return (T[]) array;
    }

    /**
     * Attempts to return the first element from a Tuple.  If the Tuple is empty, an empty Optional\<T\> is returned.
     * 
     * @param <T> The type of the value to be extracted.
     * @param clazz The {@link java.lang.Class} of the value to be extracted.
     * @return An optional of type T containing the value from the source {@link Tuple} or empty.
     */
    <T> Optional<T> tryGetFirst(final Class<T> clazz);

    /**
     * Attempts to return the last element from a Tuple.  If the Tuple is empty, an empty Optional\<T\> is returned.
     * 
     * @param <T> The type of the value to be extracted.
     * @param clazz The {@link java.lang.Class} of the value to be extracted.
     * @return An optional of type T containing the value from the source {@link Tuple} or empty.
     */
    <T> Optional<T> tryGetLast(final Class<T> clazz);
}

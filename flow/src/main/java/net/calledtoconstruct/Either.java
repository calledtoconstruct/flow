package net.calledtoconstruct;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface Either<TLeft, TRight> {

    /**
     * Given that the existing {@link Either} is of type {@link Left}, the {@code onLeftApply} transforms the contained value of type {@code TLeft}
     * using the supplied function, returning a new instance of {@link Left} as {@link Either} containing the transformed value of type {@code TOther}.
     * When the {@link Either} is of type {@link Right}, then {@code function} is not invoked, and the same instance is returned.
     * 
     * @param <TOther> Type of the value returned by {@code function}.
     * @param function A function that receives the value of type {@code TLeft} and returns a value of type {@code TOther}.
     * @return A new {@link Left} instance as {@link Either} containing the transformed value of type {@code TOther},
     * or the existing instance of type {@link Right} as {@link Either}.
     */
    <TOther> Either<TOther, TRight> onLeftApply(Function<TLeft, TOther> function);
    
    /**
     * Given that the existing {@link Either} is of type {@link Left}, the {@code onLeftAccept} provides the contained value of type {@code TLeft}
     * to the provided consumer.  The contained value of type {@code TLeft} is retained.  When the {@link Either} is of type {@link Right}
     * the {@code consumer} is not invoked, and the same instance is returned.
     * 
     * @param consumer A method that receives the value of type {@code TLeft}.
     * @return The existing {@link Left} or {@link Right} instance as {@link Either}.
     */
    Either<TLeft, TRight> onLeftAccept(Consumer<TLeft> consumer);

    /**
     * Given that the existing {@link Either} is of type {@link Left}, the {@code onLeftSupply} invokes {@code supplier} which returns
     * a value of type {@code TOther}.  A new {@link Left} instance is returned as type {@link Either} containing the supplied
     * value of type {@code TOther}.  When the {@link Either} is of type {@link Right}, the {@code supplier} is not invoked, and the same
     * instance is returned.
     * 
     * @param <TOther> Type of value supplied by the {@code supplier} function.
     * @param supplier A method that provides a new value of type {@code TLeft}.
     * @return A new {@link Left} as {@link Either} containing the supplied value, or the existing instance of {@link Right} as {@link Either}.
     */
    <TOther> Either<TOther, TRight> onLeftSupply(Supplier<TOther> supplier);

    /**
     * Given that the existing {@link Either} is of type {@link Right}, the {@code onRightApply} transforms the contained value of
     * type {@code TRight} using the supplied {@code function}, returning a new instance of {@link Right} as {@link Either}
     * containing the transformed value of type {@code TOther}. When the {@link Either} is of type {@link Left}, the {@code function}
     * is not invoked, and the same instance is returned.
     * 
     * @param <TOther> Type of the value returned by {@code function}.
     * @param function A function that receives the value of type {@code TRight} and returns a transformed value of type {@code TOther}.
     * @return A new {@link Right} instance as {@link Either} containing the transformed value of type {@code TOther},
     * or the existing instance of type {@link Left} as {@link Either}.
     */
    <TOther> Either<TLeft, TOther> onRightApply(Function<TRight, TOther> function);

    /**
     * Given that the existing {@link Either} is of type {@link Right}, the {@code onRightAccept} provides the contained value of
     * type {@code TRight} to {@code consumer}.  The contained value is maintained.  When the {@link Either} is of type {@link Left}
     * the consumer is not invoked, and the same instance is returned.
     * 
     * @param consumer A method that receives the value of type {@code TRight}.
     * @return The existing {@link Left} or {@link Right} instance as {@link Either}.
     */
    Either<TLeft, TRight> onRightAccept(Consumer<TRight> consumer);

    /**
     * Given that the existing {@link Either} is of type {@link Right}, the {@code onRightSupply} accepts a new value of type {@code TOther}
     * from the provided {@code supplier}.  A new {@link Right} is returned which contains the supplied
     * value.  When the {@link Either} is of type {@link Left}, the {@code supplier} is not invoked, and the same
     * instance is returned.
     * 
     * @param <TOther> Type of value supplied by {@code supplier}.
     * @param supplier A method that provides a new value of type {@code TOther}.
     * @return A new instance of {@link Right} containing the supplied value, or the existing instance of type {@link Left}.
     */
    <TOther> Either<TLeft, TOther> onRightSupply(Supplier<TOther> supplier);

    /**
     * Given the current {@link Either} and a provided "other" {@link Either}, attempt to merge the values they contain such that
     * the following rules are applied:
     *      {@link Left} + {@link Left} returns a new instance of type {@link Left} as {@link Either} with the two values of types
     * {@code TLeft} and {@code TOtherLeft} transformed by {@code functionMergeLeft}.
     *      {@link Right} + {@link Right} returns a new instance of type {@link Right} as {@link Either} with the two values of types
     * {@code TRight} and {@code TOtherRight} transformed by {@code functionMergeRight}
     * 
     * If it is not possible due to a mis-matched set of {@link Left} and {@link Right}, then this function will favor the {@link Left}
     * and return a new instance of type {@link Left} with the value of type {@code TLeft} transformed by {@code transformThis}
     * or of type {@code TOtherLeft} transformed by {@code transformOther}.  When this instance is of type {@link Left}, its values is
     * passed to {@code transformThis} and the result of type {@code TLeftOut} is returned.  When the "other" instance is of type
     * {@link Left}, its value is passed to {@code transformOther} and the result of type {@code TLeftOut} is returned.
     * 
     * @param <TOtherLeft> The type of value for the {@link Left} of the "other" {@link Either}.
     * @param <TOtherRight> The type of value for the {@link Right} of the "other" {@link Either}.
     * @param <TLeftOut> The type of value for the {@link Left} of the resulting {@link Either}.
     * @param <TRightOut> The type of value for the {@link Right} of the resulting {@link Either}.
     * @param other The "other" instance of {@link Either} being merged.
     * @param functionMergeLeft A function which takes values of type {@code TLeft} and {@code TOtherLeft} and produces a value of type
     * {@code TLeftOut} effectively merging the two left values.
     * @param functionMergeRight A function which takes values of type {@code TRight} and {@code TOtherRight} and produces a value of type
     * {@code TRightOut} effectively merging the two right values.
     * @param transformThis A function which takes a value of type {@code TLeft} and transforms the value to type {@code TLeftOut}.
     * @param transformOther A function which takes a value of type {@code TOtherLeft} and transforms the value to type {@code TLeftOut}.
     * @return An instance of type {@link Left} or {@link Right} as {@link Either} with value types of {@code TLeftOut} and {@code TRightOut} based on the above rules.
     */
    <TOtherLeft, TOtherRight, TLeftOut, TRightOut> Either<TLeftOut, TRightOut> mergeFailToLeft(
        Either<TOtherLeft, TOtherRight> other,
        Function2<TLeft, TOtherLeft, TLeftOut> functionMergeLeft,
        Function2<TRight, TOtherRight, TRightOut> functionMergeRight,
        Function<TLeft, TLeftOut> transformThis,
        Function<TOtherLeft, TLeftOut> transformOther
    );

    /**
     * Given the current {@link Either} and a provided "other" {@link Either}, attempt to merge the values they contain such that
     * the following rules are applied:
     *      {@link Left} + {@link Left} returns a new instance of type {@link Left} as {@link Either} with the two values of types
     * {@code TLeft} and {@code TOtherLeft} transformed by {@code functionMergeLeft}.
     *      {@link Right} + {@link Right} returns a new instance of type {@link Right} as {@link Either} with the two values of types
     * {@code TRight} and {@code TOtherRight} transformed by {@code functionMergeRight}
     * 
     * If it is not possible due to a mis-matched set of {@link Left} and {@link Right}, then this function will favor the {@link Right}
     * and return a new instance of type {@link Right} with the value of type {@code TRight} transformed by {@code transformThis}
     * or of type {@code TOtherRight} transformed by {@code transformOther}.  When this instance is of type {@link Right}, its values is
     * passed to {@code transformThis} and the result of type {@code TRightOut} is returned.  When the "other" instance is of type
     * {@link Right}, its value is passed to {@code transformOther} and the result of type {@code TRightOut} is returned.
     * 
     * @param <TOtherLeft> The type of value for the {@link Left} of the "other" {@link Either}.
     * @param <TOtherRight> The type of value for the {@link Right} of the "other" {@link Either}.
     * @param <TLeftOut> The type of value for the {@link Left} of the resulting {@link Either}.
     * @param <TRightOut> The type of value for the {@link Right} of the resulting {@link Either}.
     * @param other The "other" instance of {@link Either} being merged.
     * @param functionMergeLeft A function which takes values of type {@code TLeft} and {@code TOtherLeft} and produces a value of type
     * {@code TLeftOut} effectively merging the two left values.
     * @param functionMergeRight A function which takes values of type {@code TRight} and {@code TOtherRight} and produces a value of type
     * {@code TRightOut} effectively merging the two right values.
     * @param transformOther A function which takes a value of {@code TOtherRight} and transforms the value to {@code TRightOut}.
     * @param transformThis A function which takes a value of {@code TRight} and transforms the value to {@code TRightOut}.
     * @return An instance of type {@link Left} or {@link Right} as {@link Either} with value types {@code TLeftOut} and {@code TRightOut} based on the above rules.
     */
    <TOtherLeft, TOtherRight, TLeftOut, TRightOut> Either<TLeftOut, TRightOut> mergeFailToRight(
        Either<TOtherLeft, TOtherRight> other,
        Function2<TLeft, TOtherLeft, TLeftOut> functionMergeLeft,
        Function2<TRight, TOtherRight, TRightOut> functionMergeRight,
        Function<TRight, TRightOut> transformThis,
        Function<TOtherRight, TRightOut> transformOther
    );

    /**
     * Inverts the {@code TLeft} and {@code TRight} values, returning an instance of the opposite of this instance.
     * 
     * @return When the current instance of {@link Left}, returns an instance of {@link Right} of the same data type and value.  When the current instance
     * is {@link Right}, returns and instance of {@link Left} of the same data type and value.
     */
    Either<TRight, TLeft> flip();

    /**
     * When an {@link Either} uses the same type for both the {@code TLeft} and {@code TRight}, the coalesce function will
     * extract the value from either implementation and return it.
     * 
     * @param <TOther> The type used for the {@code TLeft} and {@code TRight} values.
     * @param either The {@link Either} containing the value to extract.
     * @return The value, regardless of whether the {@link Either} is a {@link Left} or a {@link Right}.
     */
    static <TOther> TOther coalesce(final Either<TOther, TOther> either) {
        if (either instanceof Left<TOther, TOther> left) {
            return left.getValue();
        } else if (either instanceof Right<TOther, TOther> right) {
            return right.getValue();
        } else {
            throw new UnexpectedNeitherException();
        }
    }
}
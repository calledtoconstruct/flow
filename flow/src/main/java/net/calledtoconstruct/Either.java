package net.calledtoconstruct;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface Either<TLeft, TRight> {

    <TOther> Either<TOther, TRight> onLeftApply(Function<TLeft, TOther> function);
    Either<TLeft, TRight> onLeftAccept(Consumer<TLeft> consumer);
    <TOther> Either<TOther, TRight> onLeftSupply(Supplier<TOther> supplier);

    <TOther> Either<TLeft, TOther> onRightApply(Function<TRight, TOther> function);
    Either<TLeft, TRight> onRightAccept(Consumer<TRight> consumer);
    <TOther> Either<TLeft, TOther> onRightSupply(Supplier<TOther> supplier);

    <TOtherLeftIn, TOtherRightIn, TOtherLeftOut, TOtherRightOut> Either<TOtherLeftOut, TOtherRightOut> mergeFailLeft(
        Either<TOtherLeftIn, TOtherRightIn> other,
        Function2<TLeft, TOtherLeftIn, TOtherLeftOut> functionLeft,
        Function2<TRight, TOtherRightIn, TOtherRightOut> functionRight,
        Function<TLeft, TOtherLeftOut> failLeftRightLeft,
        Function<TOtherLeftIn, TOtherLeftOut> failRightLeftLeft
        // Function2<TLeft, TOtherRightIn, TOtherLeftOut> failLeftRightLeft,
        // Function2<TRight, TOtherLeftIn, TOtherLeftOut> failRightLeftLeft
    ) throws UnexpectedNeitherException;

    <TOtherLeftIn, TOtherRightIn, TOtherLeftOut, TOtherRightOut> Either<TOtherLeftOut, TOtherRightOut> mergeFailRight(
        Either<TOtherLeftIn, TOtherRightIn> other,
        Function2<TLeft, TOtherLeftIn, TOtherLeftOut> functionLeft,
        Function2<TRight, TOtherRightIn, TOtherRightOut> functionRight,
        Function<TOtherRightIn, TOtherRightOut> failLeftRightRight,
        Function<TRight, TOtherRightOut> failRightLeftRight
        // Function2<TLeft, TOtherRightIn, TOtherRightOut> failLeftRightRight,
        // Function2<TRight, TOtherLeftIn, TOtherRightOut> failRightLeftRight
    ) throws UnexpectedNeitherException;
    
    static <TOther> TOther coalesce(final Either<TOther, TOther> either, final TOther defaultValue) {
        try {
            return Either.coalesce(either);
        } catch (final UnexpectedNeitherException exception) {
            return defaultValue;
        }
    }
    
    static <TOther> TOther coalesce(final Either<TOther, TOther> either) throws UnexpectedNeitherException {
        if (either instanceof Left<TOther, TOther> left) {
            return left.getValue();
        } else if (either instanceof Right<TOther, TOther> right) {
            return right.getValue();
        } else {
            throw new UnexpectedNeitherException();
        }
    }
}
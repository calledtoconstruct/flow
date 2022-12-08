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
package net.calledtoconstruct;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Left<TLeft, TRight> implements Either<TLeft, TRight> {

    private final TLeft value;

    public Left(TLeft value) {
        this.value = value;
    }

    @Override
    public <TOther> Either<TOther, TRight> onLeftApply(Function<TLeft, TOther> function) {
        final TOther other = function.apply(value);
        return new Left<TOther, TRight>(other);
    }

    @Override
    public <TOther> Either<TLeft, TOther> onRightApply(Function<TRight, TOther> function) {
        return new Left<TLeft, TOther>(value);
    }

    @Override
    public Either<TLeft, TRight> onLeftAccept(Consumer<TLeft> consumer) {
        consumer.accept(value);
        return this;
    }

    @Override
    public Either<TLeft, TRight> onRightAccept(Consumer<TRight> consumer) {
        return this;
    }

    @Override
    public <TOther> Either<TOther, TRight> onLeftSupply(Supplier<TOther> supplier) {
        final var other = supplier.get();
        return new Left<>(other);
    }

    @Override
    public <TOther> Either<TLeft, TOther> onRightSupply(Supplier<TOther> supplier) {
        return new Left<>(value);
    }

    public TLeft getValue() {
        return value;
    }
    
    @SafeVarargs
    public static <TLeft, TRight> boolean acceptAll(Consumer<List<TLeft>> consumer, Either<TLeft, TRight>... input) {
        final var values = Arrays.stream(input)
            .map(either -> (either instanceof Left<TLeft, TRight> left) ? left.getValue() : null)
            .filter(value -> value != null)
            .collect(Collectors.toList());

        if (values.size() == input.length) {
            consumer.accept(values);
            return true;
        }

        return false;
    }

    @SafeVarargs
    public static <TLeft, TRight> Optional<TLeft> any(Either<TLeft, TRight>... input) {
        for (var either : input) {
            if (either instanceof Left<TLeft, TRight> left) {
                return Optional.of(left.getValue());
            }
        }
        return Optional.empty();
    }

    @Override
    public <TOtherLeftIn, TOtherRightIn, TOtherLeftOut, TOtherRightOut> Either<TOtherLeftOut, TOtherRightOut> mergeFailLeft(
        Either<TOtherLeftIn, TOtherRightIn> other,
        Function2<TLeft, TOtherLeftIn, TOtherLeftOut> functionLeft,
        Function2<TRight, TOtherRightIn, TOtherRightOut> functionRight,
        Function<TLeft, TOtherLeftOut> failThis,
        Function<TOtherLeftIn, TOtherLeftOut> failOther
        // Function2<TLeft, TOtherRightIn, TOtherLeftOut> failLeftRightLeft,
        // Function2<TRight, TOtherLeftIn, TOtherLeftOut> failRightLeftLeft
    ) throws UnexpectedNeitherException {
        if (other instanceof Left<TOtherLeftIn, TOtherRightIn> left) {
            return new Left<TOtherLeftOut, TOtherRightOut>(functionLeft.apply(value, left.value));
        } else if (other instanceof Right<TOtherLeftIn, TOtherRightIn> right) {
            return new Left<TOtherLeftOut, TOtherRightOut>(failThis.apply(value));
        } else {
            throw new UnexpectedNeitherException();
        }
    }

    @Override
    public <TOtherLeftIn, TOtherRightIn, TOtherLeftOut, TOtherRightOut> Either<TOtherLeftOut, TOtherRightOut> mergeFailRight(
        Either<TOtherLeftIn, TOtherRightIn> other,
        Function2<TLeft, TOtherLeftIn, TOtherLeftOut> functionLeft,
        Function2<TRight, TOtherRightIn, TOtherRightOut> functionRight,
        Function<TOtherRightIn, TOtherRightOut> failOther,
        Function<TRight, TOtherRightOut> failThis
        // Function2<TLeft, TOtherRightIn, TOtherRightOut> failLeftRightRight,
        // Function2<TRight, TOtherLeftIn, TOtherRightOut> failRightLeftRight
    ) throws UnexpectedNeitherException {
        if (other instanceof Left<TOtherLeftIn, TOtherRightIn> left) {
            return new Left<TOtherLeftOut, TOtherRightOut>(functionLeft.apply(value, left.value));
        } else if (other instanceof Right<TOtherLeftIn, TOtherRightIn> right) {
            return new Right<TOtherLeftOut, TOtherRightOut>(failOther.apply(right.getValue()));
        } else {
            throw new UnexpectedNeitherException();
        }
    }
}

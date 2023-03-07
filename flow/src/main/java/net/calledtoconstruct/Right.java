package net.calledtoconstruct;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Right implements the container for the right value of an {@link Either}.
 */
public class Right<TLeft, TRight> implements Either<TLeft, TRight> {

    private final TRight value;

    /**
     * An implementation of {@link Either} in which the {@link Right} value of type {@code TRight} is reatined.
     * 
     * @param value The value of type {@code TRight} to store.
     */
    public Right(TRight value) {
        this.value = value;
    }

    @Override
    public <TOther> Either<TOther, TRight> onLeftApply(Function<TLeft, TOther> function) {
        return new Right<>(value);
    }

    @Override
    public <TOther> Either<TLeft, TOther> onRightApply(Function<TRight, TOther> function) {
        final TOther other = function.apply(value);
        return new Right<>(other);
    }

    @Override
    public Either<TLeft, TRight> onLeftAccept(Consumer<TLeft> consumer) {
        return this;
    }

    @Override
    public Either<TLeft, TRight> onRightAccept(Consumer<TRight> consumer) {
        consumer.accept(value);
        return this;
    }

    @Override
    public <TOther> Either<TOther, TRight> onLeftSupply(Supplier<TOther> supplier) {
        return new Right<>(value);
    }

    @Override
    public <TOther> Either<TLeft, TOther> onRightSupply(Supplier<TOther> supplier) {
        final var other = supplier.get();
        return new Right<>(other);
    }

    /**
     * Get the contained value of type {@code TRight}.
     * 
     * @return the value of type {@code TRight}
     */
    public TRight getValue() {
        return value;
    }
    
    /**
     * A function which accepts zero to many instances of {@link Either}, collects all the values from those of type {@link Right}, and invokes the supplied
     * {@code consumer},  passing the {@link java.util.List} of {@code TRight} values as the parameter.
     * 
     * @param <TLeft> The type for the {@link Left} value.
     * @param <TRight> The type for the {@link Right} value.
     * @param consumer A method which receives a {@link java.util.List} of {@code TRight} values collected from any of the supplied {@code input} which are of type {@link Right}.
     * @param input Zero or more instances of {@link Either} to be evaluated.
     * @return {@code true} when {@code input} contains at least one instance of {@link Right}, otherwise, false.
     */
    @SafeVarargs
    public static <TLeft, TRight> boolean acceptAll(Consumer<List<TRight>> consumer, Either<TLeft, TRight>... input) {
        final var values = Arrays.stream(input)
            .map(either -> (either instanceof Right<TLeft, TRight> right) ? right.getValue() : null)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

        if (values.size() == input.length) {
            consumer.accept(values);
            return true;
        }

        return false;
    }
    
    /**
     * A function which accepts zero to many instances of {@link Either}, searches for any instance of type {@link Right}, then extracts its value and returns
     * it as an {@link java.util.Optional}.  When no instance of type {@link Right} is provided, an empty {@link java.util.Optional} is returned.
     * 
     * @param <TLeft> The type for the {@link Left} value.
     * @param <TRight> The type for the {@link Right} value.
     * @param input Zero or more instances of {@link Either} to be evaluated.
     * @return And {@link java.util.Optional} of {@code TRight} or empty.
     */
    @SafeVarargs
    public static <TLeft, TRight> Optional<TRight> any(Either<TLeft, TRight>... input) {
        for (var either : input) {
            if (either instanceof Right<TLeft, TRight> right) {
                return Optional.of(right.getValue());
            }
        }
        return Optional.empty();
    }

    @Override
    public <TOtherLeft, TOtherRight, TLeftOut, TRightOut> Either<TLeftOut, TRightOut> mergeFailToLeft(
        Either<TOtherLeft, TOtherRight> other,
        BiFunction<TLeft, TOtherLeft, TLeftOut> functionMergeLeft,
        BiFunction<TRight, TOtherRight, TRightOut> functionMergeRight,
        Function<TLeft, TLeftOut> transformThis,
        Function<TOtherLeft, TLeftOut> transformOther
    ) {
        if (other instanceof Right<TOtherLeft, TOtherRight> right) {
            return new Right<>(functionMergeRight.apply(value, right.value));
        } else if (other instanceof Left<TOtherLeft, TOtherRight> left) {
            return new Left<>(transformOther.apply(left.getValue()));
        } else {
            throw new UnexpectedNeitherException();
        }
    }

    @Override
    public <TOtherLeft, TOtherRight, TLeftOut, TRightOut> Either<TLeftOut, TRightOut> mergeFailToRight(
        Either<TOtherLeft, TOtherRight> other,
        BiFunction<TLeft, TOtherLeft, TLeftOut> functionMergeLeft,
        BiFunction<TRight, TOtherRight, TRightOut> functionMergeRight,
        Function<TRight, TRightOut> transformThis,
        Function<TOtherRight, TRightOut> transformOther
    ) {
        if (other instanceof Right<TOtherLeft, TOtherRight> right) {
            return new Right<>(functionMergeRight.apply(value, right.value));
        } else if (other instanceof Left<TOtherLeft, TOtherRight>) {
            return new Right<>(transformThis.apply(value));
        } else {
            throw new UnexpectedNeitherException();
        }
    }

    @Override
    public Either<TRight, TLeft> flip() {
        return new Left<>(value);
    }

    @Override
    public <TLeftOut> Either<TLeftOut, TRight> onLeftFlatMap(
        Function<TLeft, Optional<TLeftOut>> function,
        Function<TLeft, TLeftOut> otherwise
    ) {
        return new Right<>(value);
    }

    @Override
    public <TRightOut> Either<TLeft, TRightOut> onRightFlatMap(
        Function<TRight, Optional<TRightOut>> function,
        Function<TRight, TRightOut> otherwise
    ) {
        return function.apply(value)
            .map(out -> new Right<TLeft, TRightOut>(out))
            .orElse(new Right<>(otherwise.apply(value)));
    }
}

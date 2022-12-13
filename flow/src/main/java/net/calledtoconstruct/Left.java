package net.calledtoconstruct;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Left<TLeft, TRight> implements Either<TLeft, TRight> {

    private final TLeft value;

    /**
     * An implementation of {@link Either} in which the {@link Left} value of type {@code TLeft} is retained.
     * 
     * @param value The value of type {@code TLeft} to store.
     */
    public Left(TLeft value) {
        this.value = value;
    }

    @Override
    public <TOther> Either<TOther, TRight> onLeftApply(Function<TLeft, TOther> function) {
        final TOther other = function.apply(value);
        return new Left<>(other);
    }

    @Override
    public <TOther> Either<TLeft, TOther> onRightApply(Function<TRight, TOther> function) {
        return new Left<>(value);
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

    /**
     * Get the contained value of type {@code TLeft}.
     * 
     * @return the value of type {@code TLeft}
     */
    public TLeft getValue() {
        return value;
    }
    
    /**
     * A function which accepts zero to many instances of {@link Either}, collects all the values from those of type {@link Left}, and invokes the supplied
     * {@code consumer}, passing the {@link java.util.List} of {@code TLeft} values as the parameter.
     * 
     * @param <TLeft> The type for the {@link Left} value.
     * @param <TRight> The type for the {@link Right} value.
     * @param consumer A method which receives a {@link java.util.List} of {@code TLeft} values collected from any of the supplied {@code input} which are of type {@link Left}.
     * @param input Zero or more instances of {@link Either} to be evaluated.
     * @return {@code true} when {@code input} contains at least one instance of {@link Left}, otherwise, {@code false}.
     */
    @SafeVarargs
    public static <TLeft, TRight> boolean acceptAll(Consumer<List<TLeft>> consumer, Either<TLeft, TRight>... input) {
        final var values = Arrays.stream(input)
            .map(either -> (either instanceof Left<TLeft, TRight> left) ? left.getValue() : null)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

        if (values.size() == input.length) {
            consumer.accept(values);
            return true;
        }

        return false;
    }

    /**
     * A function which accepts zero to many instances of {@link Either}, searches for any instance of type {@link Left}, then extracts its value and returns
     * it as an {@link java.util.Optional}.  When no instance of type {@link Left} is provided, an empty {@link java.util.Optional} is returned.
     * 
     * @param <TLeft> The type for the {@link Left} value.
     * @param <TRight> The type for the {@link Right} value.
     * @param input Zero or more instances of {@link Either} to be evaluated.
     * @return And {@link java.util.Optional} of type {@code TLeft} or empty.
     */
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
    public <TOtherLeft, TOtherRight, TLeftOut, TRightOut> Either<TLeftOut, TRightOut> mergeFailToLeft(
        Either<TOtherLeft, TOtherRight> other,
        Function2<TLeft, TOtherLeft, TLeftOut> functionMergeLeft,
        Function2<TRight, TOtherRight, TRightOut> functionMergeRight,
        Function<TLeft, TLeftOut> transformThis,
        Function<TOtherLeft, TLeftOut> transformOther
    ) {
        if (other instanceof Left<TOtherLeft, TOtherRight> left) {
            return new Left<>(functionMergeLeft.apply(value, left.value));
        } else if (other instanceof Right<TOtherLeft, TOtherRight>) {
            return new Left<>(transformThis.apply(value));
        } else {
            throw new UnexpectedNeitherException();
        }
    }

    @Override
    public <TOtherLeft, TOtherRight, TLeftOut, TRightOut> Either<TLeftOut, TRightOut> mergeFailToRight(
        Either<TOtherLeft, TOtherRight> other,
        Function2<TLeft, TOtherLeft, TLeftOut> functionLeft,
        Function2<TRight, TOtherRight, TRightOut> functionRight,
        Function<TRight, TRightOut> transformThis,
        Function<TOtherRight, TRightOut> transformOther
    ) {
        if (other instanceof Left<TOtherLeft, TOtherRight> left) {
            return new Left<>(functionLeft.apply(value, left.value));
        } else if (other instanceof Right<TOtherLeft, TOtherRight> right) {
            return new Right<>(transformOther.apply(right.getValue()));
        } else {
            throw new UnexpectedNeitherException();
        }
    }
}

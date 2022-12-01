package net.calledtoconstruct;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
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
}

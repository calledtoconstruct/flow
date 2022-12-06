package net.calledtoconstruct;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Right<TLeft, TRight> implements Either<TLeft, TRight> {

    private final TRight value;

    public Right(TRight value) {
        this.value = value;
    }

    @Override
    public <TOther> Either<TOther, TRight> onLeftApply(Function<TLeft, TOther> function) {
        return new Right<TOther, TRight>(value);
    }

    @Override
    public <TOther> Either<TLeft, TOther> onRightApply(Function<TRight, TOther> function) {
        final TOther other = function.apply(value);
        return new Right<TLeft, TOther>(other);
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

    public TRight getValue() {
        return value;
    }
    
    @SafeVarargs
    public static <TLeft, TRight> boolean acceptAll(Consumer<List<TRight>> consumer, Either<TLeft, TRight>... input) {
        final var values = Arrays.stream(input)
            .map(either -> (either instanceof Right<TLeft, TRight> right) ? right.getValue() : null)
            .filter(value -> value != null)
            .collect(Collectors.toList());

        if (values.size() == input.length) {
            consumer.accept(values);
            return true;
        }

        return false;
    }
    
    @SafeVarargs
    public static <TLeft, TRight> Optional<TRight> any(Either<TLeft, TRight>... input) {
        for (var either : input) {
            if (either instanceof Right<TLeft, TRight> right) {
                return Optional.of(right.getValue());
            }
        }
        return Optional.empty();
    }
}

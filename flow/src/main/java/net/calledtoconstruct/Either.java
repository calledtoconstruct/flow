package net.calledtoconstruct;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface Either<TLeft, TRight> {
    public <TOther> Either<TOther, TRight> onLeftApply(Function<TLeft, TOther> function);
    public <TOther> Either<TLeft, TOther> onRightApply(Function<TRight, TOther> function);
    public Either<TLeft, TRight> onLeftAccept(Consumer<TLeft> consumer);
    public Either<TLeft, TRight> onRightAccept(Consumer<TRight> consumer);
    public <TOther> Either<TOther, TRight> onLeftSupply(Supplier<TOther> supplier);
    public <TOther> Either<TLeft, TOther> onRightSupply(Supplier<TOther> supplier);
}

package net.calledtoconstruct;

public interface Function2<TFirstInput, TSecondInput, TOutput> {
    TOutput apply(TFirstInput first, TSecondInput second);
}

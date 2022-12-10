package net.calledtoconstruct;

public class UnexpectedNeitherException extends RuntimeException {
    public UnexpectedNeitherException() {
        super("Instance of Either was neither an instance of Left or of Right.");
    }
}
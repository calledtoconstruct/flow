package net.calledtoconstruct;

/**
 * A runtime exception that is thrown if an unexpected implementation of the Either interface is used.
 */
public class UnexpectedNeitherException extends RuntimeException {
    public UnexpectedNeitherException() {
        super("Instance of Either was neither an instance of Left or of Right.");
    }
}
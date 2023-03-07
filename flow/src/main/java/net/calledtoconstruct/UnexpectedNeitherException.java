package net.calledtoconstruct;

/**
 * A runtime exception that is thrown if an unexpected implementation of the Either interface is used.
 * See also: {@link Left} and {@link Right}
 */
public class UnexpectedNeitherException extends RuntimeException {

    /**
     * Constructs an instance of the {@link UnexpectedNeitherException} with a default message.
     */
    public UnexpectedNeitherException() {
        super("Instance of Either was neither an instance of Left or of Right.");
    }
}
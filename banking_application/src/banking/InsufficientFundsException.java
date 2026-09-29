package banking;

/** Signals that a withdrawal would exceed the available balance. */
public final class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

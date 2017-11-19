package courses.formatter.io.closable;

/**
 * CloseException class;
 */
public class CloseException extends Exception {
    /**
     * CloseException - constructor;
     * @param message - message;
     */
    public CloseException(final String message) {
        super(message);
    }
    /**
     * CloseException - constructor;
     * @param e exception;
     */
    public CloseException(final Exception e) {
        super(e.getMessage());
    }
}

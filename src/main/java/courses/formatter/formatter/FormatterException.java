package courses.formatter.formatter;

/**
 * FormatterException class;
 */
public class FormatterException extends Exception {
    /**
     *
     * @param message - message;
     */
    public FormatterException(final String message) {
        super(message);
    }

    /**
     *
     * @param e - exception;
     */
    public FormatterException(final Exception e) {
        super(e.getMessage());
    }
}

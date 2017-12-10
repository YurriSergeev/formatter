package courses.formatter.formatter;

/**
 * FormatterException class;
 */
public class FormatterException extends Exception {
    /**
     *
     * @param message - message;
     */
    public FormatterException(final String message, final Exception e) {
        super(message, e);
    }

    /**
     *
     * @param e - exception;
     */
    public FormatterException(final Exception e) {
        super(e.getMessage());
    }
}

package courses.formatter.lexer;

/**
 * LexerException class;
 */
public class LexerException extends Exception {
    /**
     * LexerException - constructor;
     * @param message - mes;
     * @param e - exception;
     */
    public LexerException(final String message, final Exception e) {
        super(message, e);
    }
}

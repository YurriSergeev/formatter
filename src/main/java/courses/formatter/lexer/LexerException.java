package courses.formatter.lexer;

/**
 * LexerException class;
 */
public class LexerException extends Exception {
    /**
     * LexerException constructor;
     * @param message - message;
     */
    public LexerException(final String message) {
        super(message);
    }

    /**
     * * LexerException constructor;
     * @param e - Exceptinon;
     */
    public LexerException(final Exception e) {
        super(e.getMessage());
    }
}

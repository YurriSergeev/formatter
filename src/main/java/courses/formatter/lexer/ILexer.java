package courses.formatter.lexer;


/**
 * ILexer interface;
 */
public interface ILexer {
    /**
     * hasToken;
     * @return bool;
     * @throws LexerException - ex;
     */
    boolean hasToken() throws LexerException;

    /**
     * readToken
     * @return IToken;
     * @throws LexerException ex;
     */
    IToken readToken() throws LexerException;

    /**
     * ...
     * @return ..
     */
    String getNextLex();
}

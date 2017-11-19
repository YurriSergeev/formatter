package courses.formatter.lexer;

import courses.formatter.lexer.implementation.Token;
import courses.formatter.lexer.LexerException;

public interface ILexer {
    boolean hasToken() throws LexerException;
    Token readToken() throws LexerException;
}

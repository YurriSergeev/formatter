package courses.formatter.lexer.implementation;

import courses.formatter.io.reader.IReader;
import courses.formatter.io.reader.ReaderException;
import courses.formatter.lexer.LexerException;
import courses.formatter.lexer.ILexer;

/**
 * Lexer class;
 */
public class Lexer implements ILexer {
    private IReader reader;
    private StringBuilder lexeme;

    /**
     * Lexer constructor;
     * @param reader - reader;
     */
    public Lexer(final IReader reader) {
        this.reader = reader;
        this.lexeme = new StringBuilder();
    }

    /**
     * hasToken()
     * @return bool;
     * @throws LexerException - Lexer exception;
     */
    public boolean hasToken() throws LexerException {
        try {
            return reader.hasChar();
        } catch (ReaderException e) {
            throw new LexerException(e.getMessage());
        }
    }

    /**
     * space
     * newLine
     * openingBracket
     * closingBracket
     * semicolon
     * tab
     * regularCharacter
     * @return token;
     * @throws LexerException - lexer exception;
     */
    public Token readToken() throws LexerException {
        String lexemeName = "";
        lexeme = new StringBuilder();
        boolean lexemeFinished = false;
        int c;

        try {
            while (reader.hasChar() && !lexemeFinished) {
                c = reader.getChar();
                switch (c) {
                    case ' ':
                        lexeme.append((char) c);
                        lexemeName = "space";
                        lexemeFinished = true;
                        break;
                    case '\n':
                        lexeme.append((char) c);
                        lexemeName = "newLine";
                        lexemeFinished = true;
                        break;
                    case '{':
                        lexeme.append((char) c);
                        lexemeName = "openingBracket";
                        lexemeFinished = true;
                        break;
                    case '}':
                        lexeme.append((char) c);
                        lexemeName = "closingBracket";
                        lexemeFinished = true;
                        break;
                    case ';':
                        lexeme.append((char) c);
                        lexemeName = "semicolon";
                        lexemeFinished = true;
                        break;
                    case '\t':
                        lexeme.append((char) c);
                        lexemeName = "tab";
                        lexemeFinished = true;
                        break;
                    default:
                        lexeme.append((char)c);
                        lexemeName = "regularCharacter";
                        lexemeFinished = true;
                }
            }
        } catch (ReaderException e) {
            throw new LexerException(e.getMessage());
        }
        return new Token(lexeme.toString(), lexemeName);
    }
}
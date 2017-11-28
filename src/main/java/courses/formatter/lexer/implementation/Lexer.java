package courses.formatter.lexer.implementation;

import courses.formatter.io.reader.IReader;
import courses.formatter.io.reader.ReaderException;
import courses.formatter.lexer.IToken;
import courses.formatter.lexer.LexerException;
import courses.formatter.lexer.ILexer;

/**
 * Lexer class;
 */
public class Lexer implements ILexer {
    private IReader reader;
    private StringBuilder lexeme;
    private int nextChar;
    private boolean firstChar = true;

    /**
     * getLastLex
     * @return next lexeme;
     */
    public String getNextLex() {

        return "" + (char) nextChar;
    }

    /**
     * Lexer - constructor;
     * @param reader - reader;
     * @throws ReaderException - ex;
     */
    public Lexer(final IReader reader) throws ReaderException {
        this.reader = reader;
        this.lexeme = new StringBuilder();
        this.nextChar = reader.getChar();
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
            throw new LexerException("Lexer failed", e);
        }
    }

    /**
     *
     *readToken
     * @return token;
     * @throws LexerException - lexer exception;
     */
    public IToken readToken() throws LexerException {

        lexeme = new StringBuilder();

        String lexemeName = "none";
        boolean alreadyNamed = false;
        boolean lexemeFinished = false;
        boolean literal = false;

        try {
            while ((reader.hasChar() && !lexemeFinished) || firstChar) {
                int currentChar = nextChar;
                if (reader.hasChar()) {
                    nextChar = reader.getChar();
                }

                switch (currentChar) {
                    case ' ':
                        if (!alreadyNamed) {
                            lexemeName = "space";
                            alreadyNamed = true;
                            lexemeFinished = true;
                        }
                        lexeme.append((char) currentChar);
                        break;
                    case '\n':
                        if (!alreadyNamed) {
                            lexemeName = "newLine";
                            alreadyNamed = true;
                            lexemeFinished = true;
                        } else {
                            if (lexemeName.equals("slComment")) {
                                lexemeFinished = true;
                                break;
                            }
                        }
                        lexeme.append((char) currentChar);
                        break;
                    case '{':
                        if (!alreadyNamed) {
                            lexemeName = "openingBracket";
                            alreadyNamed = true;
                            lexemeFinished = true;
                        }
                        lexeme.append((char) currentChar);
                        break;
                    case '}':
                        if (!alreadyNamed) {
                            lexemeName = "closingBracket";
                            alreadyNamed = true;
                            lexemeFinished = true;
                        }
                        lexeme.append((char) currentChar);
                        break;
                    case ';':
                        if (!alreadyNamed) {
                            lexemeName = "semicolon";
                            alreadyNamed = true;
                            lexemeFinished = true;
                        }
                        lexeme.append((char) currentChar);
                        break;
                    case '\"':
                        if (!alreadyNamed) {
                            lexemeName = "literal";
                            alreadyNamed = true;
                            lexemeFinished = false;
                            literal = true;
                        } else {
                            if (!lexemeName.equals("slComment") && !lexemeName.equals("mlComment")) {
                                lexemeFinished = true;
                            }
                        }
                        lexeme.append((char) currentChar);
                        break;
                    case '\t':
                        if (!alreadyNamed) {
                            lexemeName = "tab";
                            alreadyNamed = true;
                            lexemeFinished = true;
                        }
                        lexeme.append((char) currentChar);
                        break;
                    case '/':
                        if (!alreadyNamed && (nextChar == '/')) {
                            lexemeName = "slComment";
                            alreadyNamed = true;
                            lexemeFinished = false;
                        }
                        if (!alreadyNamed && (nextChar == '*')) {
                            lexemeName = "mlComment";
                            alreadyNamed = true;
                            lexemeFinished = false;
                        }
                        lexeme.append((char) currentChar);
                        break;
                    case '*':
                        lexeme.append((char) currentChar);
                        if (alreadyNamed && (nextChar == '/') && !literal) {
                            lexemeFinished = true;
                            lexeme.append((char) nextChar);
                        }
                        break;
                    default:
                        if (!alreadyNamed) {
                            lexemeName = "regularCharacter";
                            alreadyNamed = true;
                            lexemeFinished = true;
                        }
                        lexeme.append((char) currentChar);
                        break;
                }
                firstChar = false;
            }

            if (!reader.hasChar() && nextChar != -1) {
                return new Token(lexeme.toString(), lexemeName);
            }

        } catch (ReaderException e) {
            throw new LexerException("Lexer failed", e);
        }
        return new Token(lexeme.toString(), lexemeName);
    }
}
package courses.formatter.lexer.implementation;

import courses.formatter.lexer.IToken;

/**
 * class Token;
 */
public class Token implements IToken {
    private final String lexeme;
    private final String name;

    /**
     * Token;
     * @param lexeme - lex;
     * @param name -lexname;
     */
    Token(final String lexeme, final String name) {
        this.lexeme = lexeme;
        this.name = name;
    }

    public String getLexeme() {
        return lexeme;
    }

    public String getName() {
        return name;
    }
}

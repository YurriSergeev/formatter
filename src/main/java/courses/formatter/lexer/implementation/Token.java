package courses.formatter.lexer.implementation;

import courses.formatter.lexer.IToken;

public class Token implements IToken {
    private String lexeme;
    private String name;


    Token(final String lexeme, final String name) {
        this.lexeme = lexeme;
        this.name = name;
    }

    public String getLexeme() {
        return this.lexeme;
    }

    public String getName() {
        return this.name;
    }
}

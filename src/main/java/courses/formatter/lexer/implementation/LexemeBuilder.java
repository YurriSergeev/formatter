package courses.formatter.lexer.implementation;

import courses.formatter.stateMachine.interfaces.ILexemeBuilder;

/**
 *
 */
public class LexemeBuilder implements ILexemeBuilder {

    private final StringBuilder lexeme;
    private boolean isFinished;

    /**
     * LexemeBuilder constructor;
     */
    LexemeBuilder() {
        this.lexeme = new StringBuilder();
        isFinished = false;
    }

    /**
     * @return name of lexeme;
     */
    public String getName() {
        return new LexemeMap().getName(this.lexeme.toString());
    }

    /**
     * @param c to append;
     */
    public void append(final char c) {
        lexeme.append(c);
    }

    /**
     * @return is lexeme finished;
     */
    public boolean getFinished() {
        return isFinished;
    }

    /**
     *
     * @param fin - bool value writting to isFinished;
     */
    public void setFinished(final boolean fin) {
        this.isFinished = fin;
    }
    @Override
    public String toString() {
        return lexeme.toString();
    }
}

package courses.formatter.lexer.stateMachine.interfaces;

/**
 *
 */
public interface ILexemeBuilder {
    /**
     *
     * @return name of lexeme;
     */
    String getName();

    /**
     *
     * @param c to append;
     */
    void append(char c);

    /**
     *
     * @return is lexeme finished;
     */
    boolean isFinished();

    /**
     *
     */
    void setFinished();
}

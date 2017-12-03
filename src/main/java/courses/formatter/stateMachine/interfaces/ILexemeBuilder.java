package courses.formatter.stateMachine.interfaces;

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
    boolean getFinished();

    /**
     * set value for isFinished;
     */
    void setFinished(boolean finished);

}

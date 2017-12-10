package courses.formatter.lexer.stateMachine.interfaces;

/**
 * ICommand;
 */
public interface ICommand {
    /**
     *
     * @param lb lexemeBuilder
     * @param c char
     */
    void execute(ILexemeBuilder lb, char c);
}

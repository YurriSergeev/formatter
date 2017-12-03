package courses.formatter.stateMachine.interfaces;

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

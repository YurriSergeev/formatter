package courses.formatter.stateMachine.commands;

import courses.formatter.stateMachine.interfaces.ICommand;
import courses.formatter.stateMachine.interfaces.ILexemeBuilder;

/**
 *
 */
public class SkipCommand implements ICommand {
    /**
     * @param lb lexemeBuilder
     * @param c  char
     */
    public void execute(final ILexemeBuilder lb, final char c) {
        //does nothing;
    }
}

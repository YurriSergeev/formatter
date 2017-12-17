package courses.formatter.lexer.stateMachine.lexerCommands;

import courses.formatter.lexer.stateMachine.interfaces.ICommand;
import courses.formatter.lexer.stateMachine.interfaces.ILexemeBuilder;

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

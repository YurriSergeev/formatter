package courses.formatter.stateMachine.commands;

import courses.formatter.stateMachine.interfaces.ICommand;
import courses.formatter.stateMachine.interfaces.ILexemeBuilder;

/**
 *
 */
public class FinishCommand implements ICommand {
    /**
     * sets isFinished
     * @param lex - lexemeBuilder;
     * @param c - some char;
     */
    public void execute(final ILexemeBuilder lex, final char c) {
        lex.setFinished(true);
    }
}

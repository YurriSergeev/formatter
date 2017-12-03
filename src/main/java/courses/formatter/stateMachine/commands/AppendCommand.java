package courses.formatter.stateMachine.commands;

import courses.formatter.stateMachine.interfaces.ICommand;
import courses.formatter.stateMachine.interfaces.ILexemeBuilder;

/**
 *
 */
public class AppendCommand implements ICommand {
    /**
     *
     * @param lex - lexemeBuilder;
     * @param c - char to append;
     */
    public void execute(final ILexemeBuilder lex, final char c) {
        lex.append(c);
        lex.setFinished(false);
    }
}

package courses.formatter.lexer.stateMachine;

import courses.formatter.lexer.stateMachine.interfaces.ICommand;
import courses.formatter.statePackage.IState;

/**
 *
 */
public class LexerCommandsTransition {
    /**
     *
     * @param state current state;
     * @param c char;
     * @return command;
     */
    public static ICommand getCommand(final IState state, final char c) {
        return (new LexerCommandsMap()).getCommand(state, c);
    }
}

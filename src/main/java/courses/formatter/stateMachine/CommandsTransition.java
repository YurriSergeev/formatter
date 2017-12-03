package courses.formatter.stateMachine;

import courses.formatter.stateMachine.interfaces.ICommand;

/**
 *
 */
public class CommandsTransition {
    /**
     *
     * @param state current state;
     * @param c char;
     * @return command;
     */
    public static ICommand getCommand(final State state, final char c) {
        return (new CommandsMap()).getCommand(state, c);
    }
}

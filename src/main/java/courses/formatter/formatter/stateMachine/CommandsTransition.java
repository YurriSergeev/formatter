package courses.formatter.formatter.stateMachine;

import courses.formatter.formatter.stateMachine.interfaces.ICommand;
import courses.formatter.lexer.IToken;
import courses.formatter.statePackage.IState;

/**
 *
 */
public class CommandsTransition {
    private CommandsMap commandsMap;

    /**
     *
     */
    public CommandsTransition() {
        this.commandsMap = new CommandsMap();
    }

    /**
     *
     * @param state ;
     * @param token ;
     * @return ;
     */
    public ICommand getCommand(final IState state, final IToken token) {
        return commandsMap.getNextCommand(state, token);
    }

}

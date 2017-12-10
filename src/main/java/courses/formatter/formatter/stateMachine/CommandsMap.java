package courses.formatter.formatter.stateMachine;


import courses.formatter.formatter.stateMachine.Commands.AppendCommand;
import courses.formatter.formatter.stateMachine.interfaces.ICommand;
import courses.formatter.lexer.IToken;
import courses.formatter.pair.Pair;
import courses.formatter.statePackage.IState;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class CommandsMap {
    private Map<Pair<IState, String>, ICommand> hashMap;

    /**
     *
     */
    CommandsMap() {
        hashMap = new HashMap<>();
        ICommand append = new AppendCommand();
        hashMap.put(new Pair<>(null, "regularCharacter"), append);
    }

    /**
     *
     * @param state ;
     * @param token ;
     * @return ;
     */
    ICommand getNextCommand(final IState state, final IToken token) {
        if (hashMap.containsKey(new Pair<>(state, token.getName()))) {
            return hashMap.get(new Pair<>(state, token.getLexeme()));
        }
        if (hashMap.containsKey(new Pair<>(state, (String) null))) {
            return hashMap.get(new Pair<>(state, (String) null));
        }
        return new AppendCommand();
    }
}

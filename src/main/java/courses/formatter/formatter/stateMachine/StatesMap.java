package courses.formatter.formatter.stateMachine;

import courses.formatter.lexer.IToken;
import courses.formatter.pair.Pair;
import courses.formatter.statePackage.IState;
import courses.formatter.statePackage.State;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class StatesMap {
    private IState defaultState = new State("default");
    private Map<Pair<IState, String>, IState> hashMap;

    /**
     *
     */
    StatesMap() {
        hashMap = new HashMap<>();

        hashMap.put(new Pair<>(defaultState, (String) null), defaultState);
    }
    /**
     *
     */
    public IState getNextState(final IState state, final IToken token) {

        if (hashMap.containsKey(new Pair<>(state, token.getName()))) {
            return hashMap.get(new Pair<>(state, token.getLexeme()));
        }
        if (hashMap.containsKey(new Pair<>(state, (String) null))) {
            return hashMap.get(new Pair<>(state, (String) null));
        }
        return null;
    }
}

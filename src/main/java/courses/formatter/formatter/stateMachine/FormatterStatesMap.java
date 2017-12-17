package courses.formatter.formatter.stateMachine;

import courses.formatter.lexer.IToken;
import courses.formatter.pair.Pair;
import courses.formatter.statePackage.IState;
import courses.formatter.statePackage.State;

import java.util.HashMap;
import java.util.Map;

/**
 * state map for formatter state machine;
 */
public class FormatterStatesMap {
    private Map<Pair<IState, String>, IState> hashMap;

    /**
     * constructor;
     */
    public FormatterStatesMap() {
        hashMap = new HashMap<>();
        IState defaultState = new State("default");
        IState nlState = new State("nlState");


        hashMap.put(new Pair<>(defaultState,  null), defaultState);
        hashMap.put(new Pair<>(defaultState,  "space"), defaultState);
        hashMap.put(new Pair<>(defaultState,  "openingBracket"), nlState);
        hashMap.put(new Pair<>(defaultState,  "closingBracket"), nlState);
        hashMap.put(new Pair<>(defaultState,  "semicolon"), nlState);
        hashMap.put(new Pair<>(defaultState,  "newLine"), nlState);

        hashMap.put(new Pair<>(nlState,  null), defaultState);
        hashMap.put(new Pair<>(nlState,  "space"), defaultState);
        hashMap.put(new Pair<>(nlState,  "openingBracket"), nlState);
        hashMap.put(new Pair<>(nlState,  "closingBracket"), nlState);
        hashMap.put(new Pair<>(nlState,  "semicolon"), nlState);
        hashMap.put(new Pair<>(nlState,  "newLine"), nlState);





    }

    /**
     * getNextState;
     * @param state ;
     * @param token ;
     * @return ;
     */
    public IState getNextState(final IState state, final IToken token) {

        if (hashMap.containsKey(new Pair<>(state, token.getName()))) {
            return hashMap.get(new Pair<>(state, token.getName()));
        } else  {
            return hashMap.get(new Pair<>(state, (String) null));
        }
    }
}

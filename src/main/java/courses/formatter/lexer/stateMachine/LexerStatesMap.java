package courses.formatter.lexer.stateMachine;


import courses.formatter.pair.Pair;
import courses.formatter.statePackage.IState;
import courses.formatter.statePackage.State;

import java.util.HashMap;
import java.util.Map;


/**
 *
 */
public class LexerStatesMap {
    private static IState startState = new State("start");
    private Map<Pair<IState, Character>, IState> hashMap;

    /**
     * getting start state;
     * @return startState;
     */
    public static IState getStartState() {
        return startState;
    }

    /**
     * getting next state with current state and char;
      * @param state - current state;
     * @param c - char;
     * @return new state;
     */
    IState getMap(final IState state, final char c) {
        if (hashMap.containsKey(new Pair<>(state, c))) {
            return hashMap.get(new Pair<>(state, c));
        } else {
            return hashMap.get(new Pair<>(state, (Character) null));
        }
    }

    /**
     *
     */
    LexerStatesMap() {
        hashMap = new HashMap<>();
        IState defaultState = new State("default");
        IState spaceState = new State("space");
        IState resState = new State("reserved");
        IState literalState = new State("literal");
        IState commentMaybeState = new State("commentMaybe");
        IState slCommentState = new State("slComment");
        IState mlCommentState = new State("mlComment");
        IState mlCommentEndMaybeState = new State("mlCommentEndMaybe");
        IState roundBrackets = new State("roundBrackets");


        hashMap.put(new Pair<>(defaultState, '('), roundBrackets);
        hashMap.put(new Pair<>(startState, '('), roundBrackets);
        hashMap.put(new Pair<>(roundBrackets, null), roundBrackets);
        hashMap.put(new Pair<>(roundBrackets, ')'), defaultState);

        hashMap.put(new Pair<>(startState, null), defaultState);
        hashMap.put(new Pair<>(startState, (char) -1), startState);

        hashMap.put(new Pair<>(startState, '{'), resState);
        hashMap.put(new Pair<>(startState, ';'), resState);
        hashMap.put(new Pair<>(startState, '}'), resState);
        hashMap.put(new Pair<>(startState, '\n'), resState);
        hashMap.put(new Pair<>(startState, '\t'), resState);

        hashMap.put(new Pair<>(defaultState, '{'), resState);
        hashMap.put(new Pair<>(defaultState, ';'), resState);
        hashMap.put(new Pair<>(defaultState, '}'), resState);
        hashMap.put(new Pair<>(defaultState, '\n'), resState);
        hashMap.put(new Pair<>(defaultState, '\t'), resState);

        //spaces
        hashMap.put(new Pair<>(startState, ' '), spaceState);
        hashMap.put(new Pair<>(defaultState, null), defaultState);
        hashMap.put(new Pair<>(defaultState, ' '), spaceState);
        hashMap.put(new Pair<>(spaceState, null), defaultState);
        hashMap.put(new Pair<>(spaceState, ' '), spaceState);

        //literals
        hashMap.put(new Pair<>(startState, '\"'), literalState);
        hashMap.put(new Pair<>(defaultState, '\"'), literalState);
        hashMap.put(new Pair<>(spaceState, '\"'), literalState);
        hashMap.put(new Pair<>(literalState, null), literalState);
        hashMap.put(new Pair<>(literalState, '\"'), defaultState);

        //all comments:
        hashMap.put(new Pair<>(startState, '/'), commentMaybeState);
        hashMap.put(new Pair<>(defaultState, '/'), commentMaybeState);
        hashMap.put(new Pair<>(spaceState, '/'), commentMaybeState);
        //sl-comments:
        hashMap.put(new Pair<>(commentMaybeState, '/'), slCommentState);
        hashMap.put(new Pair<>(slCommentState, null), slCommentState);
        hashMap.put(new Pair<>(slCommentState, '\n'), defaultState);
        //ml-comments:
        hashMap.put(new Pair<>(commentMaybeState, '*'), mlCommentState);
        hashMap.put(new Pair<>(mlCommentState, null), mlCommentState);
        hashMap.put(new Pair<>(mlCommentState, '*'), mlCommentEndMaybeState);
        hashMap.put(new Pair<>(mlCommentEndMaybeState, '/'), defaultState);
        hashMap.put(new Pair<>(mlCommentEndMaybeState, null), mlCommentState);

    }
}

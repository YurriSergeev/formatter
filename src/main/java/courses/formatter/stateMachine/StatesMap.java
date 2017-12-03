package courses.formatter.stateMachine;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;


/**
 *
 */
public class StatesMap {
    private static State startState = new State("start");
    private Map<Pair<State, Character>, State> hashMap;

    /**
     * getting start state;
     * @return startState;
     */
    public static State getStartState() {
        return startState;
    }

    /**
     * getting next state with current state and char;
      * @param state - current state;
     * @param c - char;
     * @return new state;
     */
    State getMap(final State state, final char c) {
        if (hashMap.containsKey(new Pair<>(state, c))) {
            return hashMap.get(new Pair<>(state, c));
        } else {
            return hashMap.get(new Pair<>(state, (Character) null));
        }
    }

    /**
     *
     */
    StatesMap() {
        hashMap = new HashMap<>();
        State defaultState = new State("default");
        State spaceState = new State("space");
        State resState = new State("reserved");
        State literalState = new State("literal");
        State commentMaybeState = new State("commentMaybe");
        State slCommentState = new State("slComment");
        State mlCommentState = new State("mlComment");
        State mlCommentEndMaybeState = new State("mlCommentEndMaybe");


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

        hashMap.put(new Pair<>(startState, ' '), spaceState);
        hashMap.put(new Pair<>(defaultState, null), defaultState);
        hashMap.put(new Pair<>(defaultState, ' '), spaceState);
        hashMap.put(new Pair<>(spaceState, null), defaultState);
        hashMap.put(new Pair<>(spaceState, ' '), spaceState);


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

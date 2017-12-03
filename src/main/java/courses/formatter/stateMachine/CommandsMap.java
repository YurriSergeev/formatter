package courses.formatter.stateMachine;

import courses.formatter.stateMachine.commands.AppendCommand;
import courses.formatter.stateMachine.commands.FinishCommand;
import courses.formatter.stateMachine.commands.SkipCommand;
import courses.formatter.stateMachine.interfaces.ICommand;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class CommandsMap {
    private Map<Pair<State, Character>, ICommand> hashMap;

    /**
     *
     */
    CommandsMap() {
        hashMap = new HashMap<>();
        State startState = new State("start");
        State defaultState = new State("default");
        State spaceState = new State("space");
        State resState = new State("reserved");
        State literalState = new State("literal");
        State commentMaybeState = new State("commentMaybe");
        State slCommentState = new State("slComment");
        State mlCommentState = new State("mlComment");
        State mlCommentEndMaybeState = new State("mlCommentEndMaybe");



        ICommand append = new AppendCommand();
        ICommand skip = new SkipCommand();
        ICommand finish = new FinishCommand();

        hashMap.put(new Pair<>(startState, null), append);
        hashMap.put(new Pair<>(startState, (char) -1), skip);
        hashMap.put(new Pair<>(resState, null), finish);
        hashMap.put(new Pair<>(defaultState, ' '), finish);
        hashMap.put(new Pair<>(defaultState, '{'), finish);
        hashMap.put(new Pair<>(defaultState, ';'), finish);
        hashMap.put(new Pair<>(defaultState, '}'), finish);
        hashMap.put(new Pair<>(defaultState, '\n'), finish);
        hashMap.put(new Pair<>(defaultState, '\t'), finish);
        hashMap.put(new Pair<>(defaultState, '/'), finish);
        hashMap.put(new Pair<>(defaultState, null), append);

        hashMap.put(new Pair<>(literalState, null), append);

        hashMap.put(new Pair<>(spaceState, ' '), append);
        hashMap.put(new Pair<>(spaceState, null), finish);

        hashMap.put(new Pair<>(commentMaybeState, '/'), append);
        hashMap.put(new Pair<>(commentMaybeState, '*'), append);
        hashMap.put(new Pair<>(commentMaybeState, null), finish);

        hashMap.put(new Pair<>(slCommentState, null), append);
        hashMap.put(new Pair<>(slCommentState, '\n'), finish);

        hashMap.put(new Pair<>(mlCommentState, null), append);
        hashMap.put(new Pair<>(mlCommentEndMaybeState, null), append);

    }

    /**
     * getCommand;
     * @param state current state;
     * @param c next char;
     * @return next command;
     */
    ICommand getCommand(final  State state, final char c) {
        if (hashMap.containsKey(new Pair<>(state, c))) {
            return hashMap.get(new Pair<>(state, c));
        } else {
            return hashMap.get(new Pair<>(state, (Character) null));
        }
    }

}

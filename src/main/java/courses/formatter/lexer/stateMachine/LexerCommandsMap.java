package courses.formatter.lexer.stateMachine;

import courses.formatter.pair.Pair;
import courses.formatter.statePackage.State;
import courses.formatter.lexer.stateMachine.lexerCommands.AppendCommand;
import courses.formatter.lexer.stateMachine.lexerCommands.FinishCommand;
import courses.formatter.lexer.stateMachine.lexerCommands.SkipCommand;
import courses.formatter.lexer.stateMachine.interfaces.ICommand;
import courses.formatter.statePackage.IState;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class LexerCommandsMap {
    private Map<Pair<IState, Character>, ICommand> hashMap;

    /**
     *
     */
    LexerCommandsMap() {
        hashMap = new HashMap<>();
        IState startState = new State("start");
        IState defaultState = new State("default");
        IState spaceState = new State("space");
        IState resState = new State("reserved");
        IState literalState = new State("literal");
        IState commentMaybeState = new State("commentMaybe");
        IState slCommentState = new State("slComment");
        IState mlCommentState = new State("mlComment");
        IState mlCommentEndMaybeState = new State("mlCommentEndMaybe");
        IState roundBrackets = new State("roundBrackets");

        ICommand append = new AppendCommand();
        ICommand skip = new SkipCommand();
        ICommand finish = new FinishCommand();

        hashMap.put(new Pair<>(defaultState, '('), append);
        hashMap.put(new Pair<>(startState, '('), append);
        hashMap.put(new Pair<>(roundBrackets, null), finish);
        hashMap.put(new Pair<>(defaultState, ')'), finish);


        hashMap.put(new Pair<>(defaultState, ' '), finish);

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
    ICommand getCommand(final IState state, final char c) {
        if (hashMap.containsKey(new Pair<>(state, c))) {
            return hashMap.get(new Pair<>(state, c));
        } else {
            return hashMap.get(new Pair<>(state, (Character) null));
        }
    }

}

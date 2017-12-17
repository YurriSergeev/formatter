package courses.formatter.lexer.stateMachine;

import courses.formatter.statePackage.IState;

/**
 *
 */
public class LexerStatesTransition {
    /**
     *
     * @param state current state;
     * @param c char;
     * @return next state
     */
    public static IState nextState(final IState state, final char c) {
        return (new LexerStatesMap()).getMap(state, c);
    }
}

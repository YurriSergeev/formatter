package courses.formatter.stateMachine;

/**
 *
 */
public class StatesTransition {
    /**
     *
     * @param state current state;
     * @param c char;
     * @return next state
     */
    public static State nextState(final State state, final char c) {
        return (new StatesMap()).getMap(state, c);
    }
}

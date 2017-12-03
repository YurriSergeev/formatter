package courses.formatter.stateMachine;

import courses.formatter.stateMachine.interfaces.IState;

/**
 *
 */
public class State implements IState {

    private String curState;

    /**
     * constructor
     * @param newState - state to name;
     */
    public State(final String newState) {
        curState = newState;
    }

    /**
     * @return state name;
     */
    public String getState() {
       return curState;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof State)) {
            return false;
        }
        State state = (State) o;
        return state.curState.equals(curState);
    }
    @Override
    public int hashCode() {
        return curState.hashCode();
    }
    @Override
    public String toString() {
        return curState;
    }
}

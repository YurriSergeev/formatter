package courses.formatter.statePackage;


/**
 *
 */
public class State implements IState {

    private String stateName;

    /**
     * constructor
     * @param newState - state to name;
     */
    public State(final String newState) {
        stateName = newState;
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
        return state.stateName.equals(stateName);
    }
    @Override
    public int hashCode() {
        return stateName.hashCode();
    }
    @Override
    public String toString() {
        return stateName;
    }

    /**
     *
     * @return current state name;
     */
    @Override
    public String getState() {
        return stateName;
    }
}

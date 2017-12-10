package courses.formatter.formatter.stateMachine;

import courses.formatter.lexer.IToken;
import courses.formatter.statePackage.IState;

/**
 *
 */
public class StatesTransition {
    private StatesMap statesMap;

    /**
     *
     */
    public StatesTransition() {
        this.statesMap = new StatesMap();
    }

    /**
     *
     * @param state ;
     * @param token ;
     * @return ;
     */
    public IState nextState(final IState state, final IToken token) {
        return statesMap.getNextState(state, token);
    }
}

package courses.formatter.formatter.stateMachine;


import courses.formatter.formatter.stateMachine.formatterCommands.*;
import courses.formatter.formatter.stateMachine.interfaces.ICommand;
import courses.formatter.lexer.IToken;
import courses.formatter.pair.Pair;
import courses.formatter.statePackage.IState;
import courses.formatter.statePackage.State;

import java.util.HashMap;
import java.util.Map;

/**
 * commands map for formatter;
 */
public class FormatterCommandsMap {
    private Map<Pair<IState, String>, ICommand> hashMap;

    /**
     *
     */
    public FormatterCommandsMap() {
        hashMap = new HashMap<>();

        IState defaultState = new State("default");
        IState nlState = new State("nlState");

        ICommand appendClBr = new AppendClosingBracket();
        ICommand append = new Append();
        ICommand appendOpBr = new AppendOpeningBracket();
        ICommand appendSemicolon = new AppendSemicolon();
        ICommand appendNlOpeningBr = new AppendNlOpeningBracket();
        ICommand appendAfterNl = new AppendAfterNl();
        ICommand skip = new SkipCommand();
        ICommand appendComment = new AppendComment();
        ICommand appendLiteral = new AppendLiteral();

        hashMap.put(new Pair<>(defaultState, null), append);
        hashMap.put(new Pair<>(defaultState, "openingBracket"), appendOpBr);
        hashMap.put(new Pair<>(defaultState, "semicolon"), appendSemicolon);
        hashMap.put(new Pair<>(defaultState, "newLine"), skip);
        hashMap.put(new Pair<>(defaultState, "spaces"), append);

        hashMap.put(new Pair<>(nlState, null), appendAfterNl);
        hashMap.put(new Pair<>(nlState, "openingBracket"), appendNlOpeningBr);
        hashMap.put(new Pair<>(nlState, "semicolon"), appendAfterNl);
        hashMap.put(new Pair<>(nlState, "closingBracket"), appendClBr);
        hashMap.put(new Pair<>(nlState, "newLine"), skip);
        hashMap.put(new Pair<>(nlState, "space"), skip);

        hashMap.put(new Pair<>(defaultState, "comment"), appendComment);
        hashMap.put(new Pair<>(nlState, "comment"), appendComment);

        hashMap.put(new Pair<>(defaultState, "literal"), appendLiteral);
        hashMap.put(new Pair<>(nlState, "literal"), appendLiteral);


    }

    /**
     *
     * @param state ;
     * @param token ;
     * @return ;
     */
    public ICommand getNextCommand(final IState state, final IToken token) {
        if (hashMap.containsKey(new Pair<>(state, token.getName()))) {
            return hashMap.get(new Pair<>(state, token.getName()));
        } else {
            return hashMap.get(new Pair<>(state, (String) null));
        }
    }
}

package courses.formatter.lexer.implementation;

import courses.formatter.io.reader.IReader;
import courses.formatter.io.reader.ReaderException;
import courses.formatter.lexer.ILexer;
import courses.formatter.lexer.IToken;
import courses.formatter.lexer.LexerException;
import courses.formatter.lexer.stateMachine.CommandsTransition;
import courses.formatter.statePackage.State;
import courses.formatter.lexer.stateMachine.StatesMap;
import courses.formatter.lexer.stateMachine.StatesTransition;
import courses.formatter.lexer.stateMachine.interfaces.ICommand;
import courses.formatter.lexer.stateMachine.interfaces.ILexemeBuilder;
import courses.formatter.statePackage.IState;

/**
 * Lexer class;
 */
public class Lexer implements ILexer {
    private IReader reader;
    private ILexemeBuilder lexeme;
    private int nextChar;
    private IState state;

    /**
     * constructor;
     * @param reader - reader;
     */
    public Lexer(final IReader reader) {
        this.reader = reader;
        lexeme = new LexemeBuilder();
        state = StatesMap.getStartState();
        nextChar = -1;
    }

    /**
     * hasToken;
     *
     * @return bool;
     * @throws LexerException - ex;
     */
    public boolean hasToken() throws LexerException {
        try {
            return reader.hasChar() || lexeme.isFinished();
        } catch (ReaderException e) {
            throw  new LexerException("lexer faild", e);
        }
    }

    /**
     * readToken
     *
     * @return IToken;
     * @throws LexerException ex;
     */
    public IToken readToken() throws LexerException {
        ICommand command;
        lexeme = new LexemeBuilder();
        state = new State("start");
        try {
            command = CommandsTransition.getCommand(state, (char) nextChar);
            command.execute(lexeme, (char) nextChar);
            state = StatesTransition.nextState(state, (char) nextChar);
            while (reader.hasChar()) {
                nextChar = reader.getChar();
                command = CommandsTransition.getCommand(state, (char) nextChar);
                command.execute(lexeme, (char) nextChar);
                state = StatesTransition.nextState(state, (char) nextChar);
                if (lexeme.isFinished()) {
                    return new Token(lexeme.toString(), lexeme.getName());
                }
            }
        } catch (ReaderException e) {
            throw new LexerException("lexer faild", e);
        }
        return new Token(lexeme.toString(), lexeme.getName());
    }

    /**
     * ...
     *
     * @return ..
     */
    public String getNextLex() {
        return null;
    }
}
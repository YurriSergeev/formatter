package courses.formatter.lexer.implementation;

import courses.formatter.io.reader.IReader;
import courses.formatter.io.reader.ReaderException;
import courses.formatter.lexer.ILexer;
import courses.formatter.lexer.IToken;
import courses.formatter.lexer.LexerException;
import courses.formatter.lexer.stateMachine.LexerCommandsTransition;
import courses.formatter.statePackage.State;
import courses.formatter.lexer.stateMachine.LexerStatesMap;
import courses.formatter.lexer.stateMachine.LexerStatesTransition;
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
        state = LexerStatesMap.getStartState();
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
            command = LexerCommandsTransition.getCommand(state, (char) nextChar);
            command.execute(lexeme, (char) nextChar);
            state = LexerStatesTransition.nextState(state, (char) nextChar);
            while (reader.hasChar()) {
                nextChar = reader.getChar();
                command = LexerCommandsTransition.getCommand(state, (char) nextChar);
                command.execute(lexeme, (char) nextChar);
                state = LexerStatesTransition.nextState(state, (char) nextChar);
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
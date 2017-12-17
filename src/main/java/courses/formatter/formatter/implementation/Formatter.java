package courses.formatter.formatter.implementation;

import courses.formatter.formatter.FormatterException;
import courses.formatter.formatter.IFormatter;
import courses.formatter.formatter.stateMachine.FormatterCommandsMap;
import courses.formatter.formatter.stateMachine.FormatterStatesMap;
import courses.formatter.formatter.stateMachine.Indent;
import courses.formatter.formatter.stateMachine.interfaces.ICommand;
import courses.formatter.io.writer.IWriter;
import courses.formatter.io.writer.WriterException;
import courses.formatter.lexer.ILexer;
import courses.formatter.lexer.IToken;
import courses.formatter.lexer.LexerException;
import courses.formatter.statePackage.IState;
import courses.formatter.statePackage.State;

/**
 * Formatter class;
 */
public final class Formatter implements IFormatter {
    /**
     * @param lexer  - lexer;
     * @param writer - writer;
     * @throws FormatterException - exception;
     */
    public void format(final ILexer lexer, final IWriter writer) throws FormatterException {
        IToken c;
        ICommand command;
        Indent indent = new Indent();
        IState state = new State("default");
        FormatterCommandsMap formatterCommandsMap = new FormatterCommandsMap();
        FormatterStatesMap formatterStatesMap = new FormatterStatesMap();
        try {
            while (lexer.hasToken()) {
                c = lexer.readToken();
                command = formatterCommandsMap.getNextCommand(state, c);
                command.execute(c, writer, indent);
                state = formatterStatesMap.getNextState(state, c);
            }
        } catch (LexerException | WriterException e) {
            throw new FormatterException("formatter faild", e);
        }
    }
}

package courses.formatter.formatter.stateMachine.interfaces;

import courses.formatter.io.writer.IWriter;
import courses.formatter.io.writer.WriterException;
import courses.formatter.lexer.IToken;

/**
 *
 */
public interface ICommand {
    /**
     *
     * @param token token;
     * @param writer writer;
     */
    void execute(IToken token, IWriter writer) throws WriterException;
}

package courses.formatter.formatter.stateMachine.interfaces;

import courses.formatter.formatter.stateMachine.Indent;
import courses.formatter.io.writer.IWriter;
import courses.formatter.io.writer.WriterException;
import courses.formatter.lexer.IToken;

/**
 *
 */
public interface ICommand {
    /**
     *
     * @param token ;
     * @param writer ;
     * @param indent ;
     * @throws WriterException ;
     */
    void execute(IToken token, IWriter writer, Indent indent) throws WriterException;
}

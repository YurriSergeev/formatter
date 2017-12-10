package courses.formatter.formatter.stateMachine.Commands;


import courses.formatter.formatter.stateMachine.interfaces.ICommand;
import courses.formatter.io.writer.IWriter;
import courses.formatter.io.writer.WriterException;
import courses.formatter.lexer.IToken;

/**
 *
 */
public class AppendCommand implements ICommand {

    /**
     * @param token  token;
     * @param writer writer;
     */
    public void execute(final IToken token, final IWriter writer) throws WriterException {

        writer.writeString(token.getLexeme());

    }
}

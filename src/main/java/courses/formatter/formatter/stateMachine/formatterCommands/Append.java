package courses.formatter.formatter.stateMachine.formatterCommands;


import courses.formatter.formatter.stateMachine.Indent;
import courses.formatter.formatter.stateMachine.interfaces.ICommand;
import courses.formatter.io.writer.IWriter;
import courses.formatter.io.writer.WriterException;
import courses.formatter.lexer.IToken;

/**
 *
 */
public class Append implements ICommand {

    /**
     * @param token  token;
     * @param writer writer;
     */
    public void execute(final IToken token, final IWriter writer, final Indent indent) throws WriterException {

        writer.writeString(token.getLexeme());

    }
}

package courses.formatter.formatter.stateMachine.formatterCommands;

import courses.formatter.formatter.stateMachine.Indent;
import courses.formatter.formatter.stateMachine.interfaces.ICommand;
import courses.formatter.io.writer.IWriter;
import courses.formatter.io.writer.WriterException;
import courses.formatter.lexer.IToken;

/**
 * comment writing;
 */
public class AppendComment implements ICommand {

    /**
     * @param token  ;
     * @param writer ;
     * @param indent ;
     * @throws WriterException ;
     */
    @Override
    public void execute(final IToken token, final IWriter writer, final Indent indent) throws WriterException {
        writer.writeString(token.getLexeme() + "\n");
    }
}

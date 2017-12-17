package courses.formatter.formatter.stateMachine.formatterCommands;

import courses.formatter.formatter.stateMachine.Indent;
import courses.formatter.formatter.stateMachine.interfaces.ICommand;
import courses.formatter.io.writer.IWriter;
import courses.formatter.io.writer.WriterException;
import courses.formatter.lexer.IToken;

public class SkipCommand implements ICommand {
    /**
     * @param token  ;
     * @param writer ;
     * @param indent ;
     * @throws WriterException ;
     */
    @Override
    public void execute(IToken token, IWriter writer, Indent indent) throws WriterException {

    }
}

package courses.formatter.formatter.stateMachine.formatterCommands;

import courses.formatter.formatter.stateMachine.Indent;
import courses.formatter.formatter.stateMachine.interfaces.ICommand;
import courses.formatter.io.writer.IWriter;
import courses.formatter.io.writer.WriterException;
import courses.formatter.lexer.IToken;


/**
 *
 */
public class AppendClosingBracket implements ICommand {
    /**
     *
      * @param token ;
     * @param writer ;
     * @param indent ;
     * @throws WriterException ;
     */
    public void execute(final IToken token, final IWriter writer, final Indent indent) throws WriterException {

        indent.decIndent();
        for (int i = 0; i < indent.getIndent(); i++) {
            writer.writeString("test");
        }
        writer.writeString(token.getLexeme() + "\n");

    }

}

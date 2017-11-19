package courses.formatter.formatter;

import courses.formatter.io.writer.IWriter;
import courses.formatter.lexer.ILexer;

/**
 * IFormatter interface;
 */
public interface IFormatter {
    /**
     *
     * @param lexer - lexer;
     * @param writer - writer;
     * @throws FormatterException - FormatterException;
     */
    void format(ILexer lexer, IWriter writer) throws FormatterException;
}

package courses.formatter.formatter.implementation;
import courses.formatter.formatter.FormatterException;
import courses.formatter.formatter.IFormatter;
import courses.formatter.io.writer.IWriter;
import courses.formatter.io.writer.WriterException;
import courses.formatter.lexer.implementation.Token;
import courses.formatter.lexer.LexerException;
import courses.formatter.lexer.ILexer;

/**
 * Formatter class;
 */
public final class Formatter implements IFormatter {
    /**
     *
     * @param lexer - lexer;
     * @param writer - writer;
     * @throws FormatterException -.
     */
    public void format(final ILexer lexer, final IWriter writer) throws FormatterException  {
        int level = 0;
        Token c;
        boolean nl = false;

//        space
//        newLine
//        openingBracket
//        closingBracket
//        semicolon
//        tab
//        regularCharacter

        try {
            while (lexer.hasToken()) {
                c = lexer.readToken();
                switch (c.getName()) {
                    case "space":
                        break;
                    case "newLine":
                        break;
                    case "openingBracket":
                        writer.writeChar(c.getLexeme());
                        level++;
                        writer.writeChar("\n");
                        newLine(level, writer);
                        break;
                    case "semicolon":
                        writer.writeChar(c.getLexeme());
                        nl = true;
                        break;
                    case "closingBracket":
                        if (nl) {
                            writer.writeChar("\n");
                            level--;
                            newLine(level, writer);
                        }
                        writer.writeChar(c.getLexeme());
                        newLine(level, writer);
                        nl = true;
                        break;
                    case "regularCharacter":
                        if (nl) {
                            writer.writeChar("\n");
                            newLine(level, writer);
                            nl = false;
                        }
                        writer.writeChar(c.getLexeme());
                    default:
                        break;
                }
            }
        } catch (LexerException | WriterException e) {
            throw new FormatterException(e.getMessage());
        }
    }
    private static void newLine(final int level, final IWriter writer) throws WriterException {
        for (int i = 0; i < 4 * level; i++) {
            writer.writeChar(" ");
        }
    }
}

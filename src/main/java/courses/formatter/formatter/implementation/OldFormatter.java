package courses.formatter.formatter.implementation;

import courses.formatter.formatter.FormatterException;
import courses.formatter.formatter.IFormatter;
import courses.formatter.io.writer.IWriter;
import courses.formatter.io.writer.WriterException;
import courses.formatter.lexer.ILexer;
import courses.formatter.lexer.IToken;
import courses.formatter.lexer.LexerException;

/**
 * Formatter class;
 */
public final class OldFormatter implements IFormatter {
    /**
     * @param lexer  - lexer;
     * @param writer - writer;
     * @throws FormatterException - exception;
     */
    public void format(final ILexer lexer, final IWriter writer) throws FormatterException {
        int level = 0;
        IToken c;
        boolean nl = false;

        boolean spaceNeed = false;
        try {
            while (lexer.hasToken()) {
                c = lexer.readToken();
                switch (c.getName()) {
                    case "space":
                        if (spaceNeed) {
                            writer.writeString(" ");
                        }
                        spaceNeed = false;
                        break;
                    case "newLine":
                        break;
                    case "openingBracket":
                        writer.writeString(c.getLexeme());
                        level++;
                        writer.writeString("\n");
                        newLine(level, writer);
                        spaceNeed = false;
                        break;
                    case "semicolon":
                        writer.writeString(c.getLexeme());
                        nl = true;
                        spaceNeed = false;
                        break;
                    case "closingBracket":
                        if (nl) {
                            writer.writeString("\n");
                            level--;
                            newLine(level, writer);
                        }
                        writer.writeString(c.getLexeme());
                        newLine(level, writer);
                        nl = true;
                        spaceNeed = false;
                        break;
                    case "literal":
                        writer.writeString(c.getLexeme());
                        spaceNeed = true;
                        break;
                    case "comment":
                        writer.writeString(c.getLexeme());
                        spaceNeed = false;
                        break;
                    case "regularCharacter":
                        if (nl) {
                            writer.writeString("\n");
                            newLine(level, writer);
                            nl = false;
                        }
                        writer.writeString(c.getLexeme());
                        spaceNeed = true;
                        break;
                    default:
                        break;
                }
            }
        } catch (LexerException | WriterException e) {
            throw new FormatterException("formatter faild", e);
        }
    }

    private static void newLine(final int level, final IWriter writer) throws WriterException {
        final int indent = 4;
        for (int i = 0; i < indent * level; i++) {
            writer.writeString(" ");
        }
    }
}

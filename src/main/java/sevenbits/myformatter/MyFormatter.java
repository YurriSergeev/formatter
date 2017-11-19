package sevenbits.myformatter;
import sevenbits.myformatter.interfaces.IReader;
import sevenbits.myformatter.interfaces.IWriter;
import sevenbits.myformatter.exceptions.ReaderException;
import sevenbits.myformatter.exceptions.WriterException;

/**
 * MyFormatter class;
 */
public final class MyFormatter {
    /**
     * format
     * @param reader - reader;
     * @param writer - writer;
     * @throws ReaderException - exception of reader;
     * @throws WriterException - exception of writer;
     */
    public void format(final IReader reader, final IWriter writer) throws ReaderException, WriterException {
        int level = 0;
        char c;
        boolean nl = false;
        while (reader.hasChar()) {
            c = reader.readChar();
            switch (c) {
                case ' ':
                    break;
                case '\n':
                    break;
                case '{':
                    writer.writeChar(c);
                    level++;
                    writer.writeChar('\n');
                    newLine(level, writer);
                    break;
                case ';':
                    writer.writeChar(c);
                    nl = true;
                    break;
                case '}':
                    if (nl) {
                        writer.writeChar('\n');
                        level--;
                        newLine(level, writer);
                    }
                    writer.writeChar(c);
                    newLine(level, writer);
                    nl = true;
                    break;
                default:
                    if (nl) {
                        writer.writeChar('\n');
                        newLine(level, writer);
                        nl = false;
                    }
                    writer.writeChar(c);
            }
        }
    }
    private static void newLine(final int level, final IWriter writer) throws WriterException {
        for (int i = 0; i < 4 * level; i++) {
            writer.writeChar(' ');
        }
    }
}

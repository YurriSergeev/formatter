package courses.formatter;
import courses.formatter.io.writer.implementation.FileWriter;
import courses.formatter.formatter.implementation.Formatter;
import courses.formatter.formatter.FormatterException;
import courses.formatter.io.closable.CloseException;
import courses.formatter.io.reader.IReader;
import courses.formatter.io.writer.IWriter;
import courses.formatter.io.reader.ReaderException;
import courses.formatter.io.writer.WriterException;
import courses.formatter.io.reader.implementation.FileReader;
import courses.formatter.lexer.implementation.Lexer;

/**
 * Main class;
 */
public final class Main {
    private Main() {}

    /**
     * main() - point of entry;
     * @param args - using for getting filename(s);
     * @throws ReaderException - ReaderException;
     * @throws WriterException - WriterException;
     * @throws CloseException - CloseException;
     * @throws FormatterException - FormatterException;
     */
    public static void  main(final String[] args)  throws ReaderException, WriterException, CloseException, FormatterException {
        if (args.length == 0) {
            System.out.print("Usage: java -jar formatter in.java [out.java]");
            return;
        }
        try (
                FileReader reader = new FileReader(args[0]);
                FileWriter writer = new FileWriter(args.length > 1 ? args[1] : "res.java");
        ) {
        Formatter formatter = new Formatter();
        Lexer lexer = new Lexer(reader);
        formatter.format(lexer, writer);
        }
    }
}

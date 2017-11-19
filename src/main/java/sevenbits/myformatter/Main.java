package sevenbits.myformatter;
import sevenbits.myformatter.exceptions.CloseException;
import sevenbits.myformatter.interfaces.IReader;
import sevenbits.myformatter.interfaces.IWriter;
import sevenbits.myformatter.exceptions.ReaderException;
import sevenbits.myformatter.exceptions.WriterException;
import sevenbits.myformatter.fileIO.MyFileReader;
import sevenbits.myformatter.fileIO.MyFileWriter;

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
     */
    public static void  main(final String[] args) throws ReaderException, WriterException, CloseException {
        if (args.length == 0) {
            System.out.print("error of args");
            return;
        }
        IReader reader = new MyFileReader(args[0]);
        IWriter writer = new MyFileWriter(args.length > 1 ? args[1] : "res.java");
        MyFormatter formatter = new MyFormatter();
        formatter.format(reader, writer);
        reader.close();
        writer.close();
    }
}

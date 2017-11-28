package courses.formatter.io.writer;

/**
 * IWriter interface;
 */
public interface IWriter {
    /**
     * writeString;
     * @param str - string; to write
     * @throws WriterException - exception of writer;
     */
    void writeString(String str) throws WriterException;
}

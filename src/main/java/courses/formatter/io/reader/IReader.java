package courses.formatter.io.reader;

/**
 * IReader interface;
 */
public interface IReader {
    /**
     * readChar() - check the existence of the next char;
     * @return exists or does not exist;
     * @throws ReaderException - exception of reader;
     */
    boolean hasChar() throws ReaderException;

    /**
     * getChar() read next char;
     * @return char;
     * @throws ReaderException - exception of reader;
     */
    char getChar() throws ReaderException;
}

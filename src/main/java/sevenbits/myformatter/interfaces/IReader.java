package sevenbits.myformatter.interfaces;

import sevenbits.myformatter.exceptions.CloseException;
import sevenbits.myformatter.exceptions.ReaderException;

/**
 * IReader interface;
 */
public interface IReader  {
    /**
     * hasChar() - check the existence of the next char;
     * @return exists or does not exist;
     * @throws ReaderException - exception of reader;
     */
    boolean hasChar() throws ReaderException;

    /**
     * readChar() read next char;
     * @return char;
     * @throws ReaderException - exception of reader;
     */
    char readChar() throws ReaderException;

    /**
     * close() - closing of file;
     * @throws ReaderException - exception of reader;
     */
    void close() throws CloseException;
}

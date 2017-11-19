package sevenbits.myformatter.interfaces;

import sevenbits.myformatter.exceptions.CloseException;
import sevenbits.myformatter.exceptions.WriterException;

/**
 * IWriter interface;
 */
public interface IWriter  {
    /**
     * writeChar;
     * @param c - char;
     * @throws WriterException - exception of writer;
     */
    void writeChar(char c) throws WriterException;
    /**
     * close;
     * @throws WriterException - exception of writer;
     */
    void close() throws CloseException;
}

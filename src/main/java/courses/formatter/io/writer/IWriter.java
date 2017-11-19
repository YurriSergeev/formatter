package courses.formatter.io.writer;

import courses.formatter.io.closable.IClosable;

/**
 * IWriter interface;
 */
public interface IWriter extends IClosable {
    /**
     * writeChar;
     * @param c - char;
     * @throws WriterException - exception of writer;
     */
    void writeChar(String c) throws WriterException;
}

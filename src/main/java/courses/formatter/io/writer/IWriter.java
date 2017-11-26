package courses.formatter.io.writer;

import courses.formatter.io.closable.IClosable;

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

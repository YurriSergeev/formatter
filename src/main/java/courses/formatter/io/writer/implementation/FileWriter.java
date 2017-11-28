package courses.formatter.io.writer.implementation;

import courses.formatter.io.closable.IClosable;
import courses.formatter.io.closable.CloseException;
import courses.formatter.io.writer.IWriter;
import courses.formatter.io.writer.WriterException;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * FileWriter class;
 */
public class FileWriter implements IWriter, IClosable {
    private BufferedWriter buf;
    /**
     * FileWriter - constructor;
     * @param file - file arg;
     * @throws WriterException - exception of writer;
     */
    public FileWriter(final String file) throws WriterException {
        try {
            buf = new BufferedWriter(new java.io.FileWriter(file));
        } catch (IOException e) {
            throw new WriterException("some problem with writing");
        }
    }
    /**
     * writeString - write one char;
     * @param str - string to write;
     * @throws WriterException - exception of writer;
     */
    public void writeString(final String str) throws WriterException {
        try {
            buf.append(str);
        } catch (IOException e) {
            throw new WriterException("some problem with writing");
        }
    }

    /**
     *
     * @throws CloseException - CloseException;
     */
    public void close() throws CloseException {
        try {
            buf.close();
        } catch (IOException e) {
            throw new CloseException("some problem with reading");
        }
    }
}

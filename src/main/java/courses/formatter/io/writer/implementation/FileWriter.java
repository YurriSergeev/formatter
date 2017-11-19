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
     * writeChar - write one char;
     * @param c - char;
     * @throws WriterException - exception of writer;
     */
    public void writeChar(final String c) throws WriterException {
        try {
            buf.append(c);
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

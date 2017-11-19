package sevenbits.myformatter.fileIO;

import sevenbits.myformatter.exceptions.CloseException;
import sevenbits.myformatter.exceptions.WriterException;
import sevenbits.myformatter.interfaces.IWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * MyFileWriter class;
 */
public class MyFileWriter implements IWriter {
    private BufferedWriter buf;
    /**
     * MyFileWriter - constructor;
     * @param file - file arg;
     * @throws WriterException - exception of writer;
     */
    public MyFileWriter(final String file) throws WriterException {
        try {
            buf = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            throw new WriterException("some problem with writing");
        }
    }
    /**
     * writeChar - write one char;
     * @param c - char;
     * @throws WriterException - exception of writer;
     */
    public void writeChar(final char c) throws WriterException {
        try {
            buf.append(c);
        } catch (IOException e) {
            throw new WriterException("some problem with writing");
        }
    }
    /**
     * close - closing;
     * @throws WriterException - exception of writer;
     */
    public void close() throws CloseException {
        try {
            buf.close();
        } catch (IOException e) {
            throw new CloseException("some problem with writing");
        }
    }
}

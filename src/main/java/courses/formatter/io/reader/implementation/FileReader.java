package courses.formatter.io.reader.implementation;

import courses.formatter.io.closable.IClosable;
import courses.formatter.io.reader.IReader;
import courses.formatter.io.closable.CloseException;
import courses.formatter.io.reader.ReaderException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileReader class;
 */
public class FileReader implements IReader, IClosable {
    private int sym = -1;
    private BufferedReader buf;
    /**
     * FileReader - constructor;
     * @param fileName - name of file;
     * @throws ReaderException - exception of reading;
     */
    public FileReader(final String fileName) throws ReaderException {
        try {
            buf = new BufferedReader(new java.io.FileReader(fileName));
            sym = buf.read();
        } catch (IOException e) {
          throw new ReaderException("some problem with reading");
        }
    }
    /**
     * readChar() - check the existence of the next char;
     * @return exists or does not exist;
     * @throws ReaderException - exception of reader;
     */
    public boolean hasChar() throws ReaderException {
        return sym != -1;
    }
    /**
     * getChar() read next char;
     * @return char;
     * @throws ReaderException - exception of reader;
     */
    public char getChar() throws ReaderException {
        try {
            int prev = sym;
            sym = buf.read();
            return (char) prev;
        } catch (IOException e) {
            throw new ReaderException("some problem with reading");
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

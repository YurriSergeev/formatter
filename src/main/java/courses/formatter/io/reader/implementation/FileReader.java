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
    private char sym;
    private BufferedReader buf;
    /**
     * FileReader - constructor;
     * @param fileName - name of file;
     * @throws ReaderException - exception of reading;
     */
    public FileReader(final String fileName) throws ReaderException {
        try {
            buf = new BufferedReader(new java.io.FileReader(fileName));
        } catch (FileNotFoundException e) {
          throw new ReaderException("some problem with reading");
        }
    }
    /**
     * readChar() - check the existence of the next char;
     * @return exists or does not exist;
     * @throws ReaderException - exception of reader;
     */
    public boolean hasChar() throws ReaderException {
        try {
            buf.mark(1);
            int c = buf.read();
            buf.reset();
            return c != -1;
        } catch (IOException e) {
            throw new ReaderException("some problem with reading");
        }
    }
    /**
     * getChar() read next char;
     * @return char;
     * @throws ReaderException - exception of reader;
     */
    public char getChar() throws ReaderException {
        int c = ' ';
        try {
            c = buf.read();
        } catch (IOException e) {
            new ReaderException("some problem with reading");
        }
        return (char)c;
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

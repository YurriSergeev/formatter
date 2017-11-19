package sevenbits.myformatter.fileIO;

import sevenbits.myformatter.interfaces.IClosable;
import sevenbits.myformatter.exceptions.CloseException;
import sevenbits.myformatter.exceptions.ReaderException;
import sevenbits.myformatter.interfaces.IReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;

/**
 * MyFileReader class;
 */
public class MyFileReader implements IReader, IClosable {
    private char sym;
    /**
     * never used, but requires implementation;
     * @return nothing;
     */
    public String myToString() {
        return "";
    }
    private BufferedReader buf;
    /**
     * MyFileReader - constructor;
     * @param fileName - name of file;
     * @throws ReaderException - exception of reading;
     */
    public MyFileReader(final String fileName) throws ReaderException {
        try {
            buf = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
          throw new ReaderException("some problem with reading");
        }
    }
    /**
     * hasChar() - check the existence of the next char;
     * @return exists or does not exist;
     * @throws ReaderException - exception of reader;
     */
    public boolean hasChar() throws ReaderException {
        try {
            int a = buf.read();
            sym = (char) a;
            return a != -1;
        } catch (IOException e) {
            throw new ReaderException("some problem with reading");
        }
    }
    /**
     * readChar() read next char;
     * @return char;
     * @throws ReaderException - exception of reader;
     */
    public char readChar() throws ReaderException {
        return sym;
    }
    /**
     * close() - closing of file;
     * @throws ReaderException - exception of reader;
     */
    public void close() throws CloseException {
        try {
            buf.close();
        } catch (IOException e) {
            throw new CloseException("some problem with reading");
        }
    }
}

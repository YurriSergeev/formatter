package courses.formatter.io.reader.implementation;

import courses.formatter.io.reader.IReader;

/**
 * StringReader class;
 */
public class StringReader implements IReader {
    private String str;
    private int i = 0;
    /**
     * StringReader;
     * @param s - input string;
     */
    public StringReader(final String s) {
        this.str = s;
    }
    /**
     * readChar;
     * @return - check the existence of the next char;
     */
    public boolean hasChar() {
        return str.length() > i;
    }
    /**
     * getChar;
     * @return - char;
     */
    public char getChar() {
        char c;
        c = str.charAt(i);
        i++;
        return c;
    }
    /**
     * close;
     */
    public void close() {
    }
}

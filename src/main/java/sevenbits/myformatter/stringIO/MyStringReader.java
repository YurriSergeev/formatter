package sevenbits.myformatter.stringIO;

import sevenbits.myformatter.interfaces.IReader;

/**
 * MyStringReader class;
 */
public class MyStringReader implements IReader {
    private String str;
    private int i = 0;
    /**
     * MyStringReader;
     * @param s - input string;
     */
    public MyStringReader(final String s) {
        this.str = s;
    }
    /**
     * hasChar;
     * @return - check the existence of the next char;
     */
    public boolean hasChar() {
        return str.length() > i;
    }
    /**
     * readChar;
     * @return - char;
     */
    public char readChar() {
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

package sevenbits.myformatter.stringIO;

import sevenbits.myformatter.interfaces.IWriter;

/**
 * MyStringWriter class;
 */
public class MyStringWriter implements IWriter {
    private StringBuilder str;
    /**
     * toString
     * @return str;
     */
    public String toString() {
        return str.toString();
    }
    /**
     * MyStringWriter;
     */
    public MyStringWriter() {
        str = new StringBuilder();
    }

    /**
     * writeChar;
     * @param c - char;
     */
    public void writeChar(final char c) {
        str.append(c);
    }
    /**
     * close;
     */
    public void close(){
    }
}

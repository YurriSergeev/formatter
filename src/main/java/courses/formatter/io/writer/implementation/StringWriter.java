package courses.formatter.io.writer.implementation;

import courses.formatter.io.writer.IWriter;

/**
 * StringWriter class;
 */
public class StringWriter implements IWriter {
    private StringBuilder str;
    /**
     * toString
     * @return str;
     */
    public String toString() {
        return str.toString();
    }
    /**
     * StringWriter;
     */
    public StringWriter() {
        str = new StringBuilder();
    }

    /**
     * writeChar;
     * @param c - char;
     */
    public void writeChar(final String c) {
        str.append(c);
    }
    /**
     * close;
     */
    public void close(){
    }
}

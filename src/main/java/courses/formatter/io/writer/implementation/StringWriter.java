package courses.formatter.io.writer.implementation;

import courses.formatter.io.writer.IWriter;

/**
 * StringWriter class;
 */
public class StringWriter implements IWriter {
    private StringBuilder strB;
    /**
     * toString
     * @return strB;
     */
    public String toString() {
        return strB.toString();
    }
    /**
     * StringWriter;
     */
    public StringWriter() {
        strB = new StringBuilder();
    }
    /**
     * writeString;
     * @param str - char;
     */
    public void writeString(final String str) {
        strB.append(str);
    }
}

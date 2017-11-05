package com.project.myformatter.StringIO;

import com.project.myformatter.IWriter;

public class myStringWriter implements IWriter {
    private StringBuilder str;
    public String toString() {
        return str.toString();
    }
    public myStringWriter() {
        str = new StringBuilder();
    }
    public void writeChar(final char c) {
        str.append(c);
    }
    public void close(){
    }
}

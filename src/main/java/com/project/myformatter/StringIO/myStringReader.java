package com.project.myformatter.StringIO;

import com.project.myformatter.IReader;

public class myStringReader implements IReader{
    private String str;
    private int i = 0;

    public myStringReader (final String s) {
        this.str = s;
    }
    public boolean hasChar() {
        return str.length() > i;
    }
    public char readChar() {
        char c;
        c = str.charAt(i);
        i++;
        return c;
    }
    public void close() {
    }
}

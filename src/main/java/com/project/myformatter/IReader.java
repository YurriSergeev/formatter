package com.project.myformatter;

import com.project.myformatter.Exceptions.ReaderException;

public interface IReader  {
    boolean hasChar() throws ReaderException;
    char readChar() throws ReaderException;
    void close() throws ReaderException;
}

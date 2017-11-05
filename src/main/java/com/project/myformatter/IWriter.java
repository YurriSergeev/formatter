package com.project.myformatter;

import com.project.myformatter.Exceptions.WriterException;

public interface IWriter  {
    void writeChar(char c) throws WriterException;
    void close() throws WriterException;
}

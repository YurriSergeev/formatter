package com.project.myformatter.FileIO;

import com.project.myformatter.Exceptions.WriterException;
import com.project.myformatter.IWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class myFileWriter implements IWriter{
    private BufferedWriter buf;
    public myFileWriter(final String file) throws WriterException {
        try{
            buf = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            throw new WriterException("some problem with writing");
        }
    }
    public void writeChar(final char c) throws WriterException{
        try{
            buf.append(c);
        }catch (IOException e){
            throw new WriterException("some problem with writing");
        }
    }
    public void close() throws WriterException{
        try {
            buf.close();
        } catch (IOException e) {
            throw new WriterException("some problem with writing");
        }
    }
}

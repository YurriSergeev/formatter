package com.project.myformatter.FileIO;

import com.project.myformatter.Exceptions.ReaderException;
import com.project.myformatter.IReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;

public class myFileReader implements IReader {
    public String myToString(){
        return "";
    }
    private BufferedReader buf;
    public myFileReader(final String fileName) throws  ReaderException{
        try{
            buf = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
          throw new ReaderException("some problem with reading");
        }
    }
    public boolean hasChar() throws ReaderException{
        try{
            buf.mark(1);
            int c = buf.read();
            buf.reset();
            return c != -1;
        } catch (IOException e){
            throw new ReaderException("some problem with reading");
        }
    }
    public char readChar() throws ReaderException{
        try {
            return (char)buf.read();
        } catch (IOException e){
            throw new ReaderException("some problem with reading");
        }
    }
    public void close() throws ReaderException{
        try {
            buf.close();
        } catch (IOException e){
            throw new ReaderException("some problem with reading");
        }
    }
}

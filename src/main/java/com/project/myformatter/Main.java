package com.project.myformatter;
import com.project.myformatter.Exceptions.ReaderException;
import com.project.myformatter.Exceptions.WriterException;
import com.project.myformatter.FileIO.myFileReader;
import com.project.myformatter.FileIO.myFileWriter;

public class Main {
    public static void  main(final String[] args) throws ReaderException, WriterException {
        if (args.length == 0){
            System.out.print("error of args");
            return;
        }
        IReader reader = new myFileReader(args[0]);
        IWriter writer = new myFileWriter(args.length > 1 ? args[1] : "res.txt");
        myFormatter.format(reader, writer);
    }
}

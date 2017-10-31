package com.project.formatter;
import java.io.*;
import static com.project.formatter.Formatter.format;
public class Main {
    public static void  main(final String[] args){
        if (args.length == 0){
            System.out.print("error of args");
            return;
        }
        File originalFile = new File(args[0]);
        File newFile = new File(args.length > 1 ? args[1] : "res.txt");
        try{
            if(!originalFile.exists()){
                throw new IOException();
            }
            BufferedReader original = new BufferedReader(new FileReader(originalFile));
            BufferedWriter newOne = new BufferedWriter(new FileWriter(newFile));
            format(original, newOne);
            original.close();
            newOne.close();
        } catch (IOException e){
            System.out.print("error of file");
        }
    }
}

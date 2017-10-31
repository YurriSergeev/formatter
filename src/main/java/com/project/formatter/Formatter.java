package com.project.formatter;
import java.io.*;
final class Formatter {
    public static void format(BufferedReader original, BufferedWriter newOne){
        int level = 0;
        int c;
        boolean nl = false;
        try{
            while ((c = original.read()) != -1){
                switch (c){
                    case '{':
                        newOne.write(c);
                        level++;
                        newOne.write('\n');
                        newIndetion(level, newOne);
                        break;
                    case ';':
                        newOne.write(c);
                        nl = true;
                        break;
                    case '}':
                        if (nl){
                            newOne.write('\n');
                            level--;
                            newIndetion(level, newOne);
                        }
                        newOne.write(c);
                        newIndetion(level, newOne);
                        nl = true;
                        break;
                    default:
                        if (nl){
                            newOne.write('\n');
                            newIndetion(level, newOne);
                            nl = false;
                        }
                        newOne.write(c);
                }
            }
        }
        catch (IOException e){
            System.out.println("some error");
        }
    }
    private static void newIndetion(int level, BufferedWriter newOne){
        try{
            for (int i = 0; i < level; i++) {
                newOne.write("    ");
            }
        }
        catch (IOException e){
            System.out.println("some error");
        }

    }
}

package com.project.myformatter;
import com.project.myformatter.Exceptions.ReaderException;
import com.project.myformatter.Exceptions.WriterException;

final public class myFormatter {
    public static void format(final IReader reader, final IWriter writer) throws ReaderException, WriterException{
        int level = 0;
        char c;
        boolean nl = false;
        while (reader.hasChar()){
            c = reader.readChar();
            switch (c){
                case '\n':
                    break;
                case '{':
                    writer.writeChar(c);
                    level++;
                    writer.writeChar('\n');
                    newLine(level, writer);
                    break;
                case ';':
                    writer.writeChar(c);
                    nl = true;
                    break;
                case '}':
                    if (nl){
                        writer.writeChar('\n');
                        level--;
                        newLine(level, writer);
                    }
                    writer.writeChar(c);
                    newLine(level, writer);
                    nl = true;
                    break;
                default:
                    if (nl){
                        writer.writeChar('\n');
                        newLine(level, writer);
                        nl = false;
                    }
                    writer.writeChar(c);
            }
        }
        reader.close();
        writer.close();
    }
    private static void newLine(int level, IWriter writer) throws WriterException{
        for (int i = 0; i < 4*level; i++) {
            writer.writeChar(' ');
        }
    }
}

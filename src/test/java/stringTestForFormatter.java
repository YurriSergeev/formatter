import sevenbits.myformatter.exceptions.ReaderException;
import sevenbits.myformatter.exceptions.WriterException;
import sevenbits.myformatter.interfaces.IReader;
import sevenbits.myformatter.interfaces.IWriter;
import sevenbits.myformatter.stringIO.MyStringReader;
import sevenbits.myformatter.stringIO.MyStringWriter;
import sevenbits.myformatter.MyFormatter;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class stringTestForFormatter {
    private MyFormatter formatter;
    @Before
    public void init() {
        formatter= new MyFormatter();
    }
    @Test
    public void test1() throws ReaderException, WriterException {
        IReader reader = new MyStringReader("aaaa{bbbb;cccc;}");
        IWriter writer = new MyStringWriter();
        formatter.format(reader, writer);
        assertEquals("aaaa{\n    bbbb;\n    cccc;\n}", writer.toString());
    }
    @Test
    public void test2() throws ReaderException, WriterException {
        IReader reader = new MyStringReader("aaaa\n\n\n\n{bbbb\n\n\n\n;\n\n\n\ncccc\n\n\n\n;\n\n\n\n}");
        IWriter writer = new MyStringWriter();
        formatter.format(reader, writer);
        assertEquals("aaaa{\n    bbbb;\n    cccc;\n}", writer.toString());
    }
    @Test
    public void test3() throws ReaderException, WriterException {
        IReader reader = new MyStringReader("aaaa        {       bbbb       ;        cccc    ;            }");
        IWriter writer = new MyStringWriter();
        formatter.format(reader, writer);
        assertEquals("aaaa{\n    bbbb;\n    cccc;\n}", writer.toString());
    }
    @Test
    public void test4() throws ReaderException, WriterException {
        IReader reader = new MyStringReader("aa;aa{bb;bb;cc;cc;}");
        IWriter writer = new MyStringWriter();
        MyFormatter formatter = new MyFormatter();
        formatter.format(reader, writer);
        assertEquals("aa;\naa{\n    bb;\n    bb;\n    cc;\n    cc;\n}", writer.toString());
    }
}
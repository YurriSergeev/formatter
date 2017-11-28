

import courses.formatter.formatter.FormatterException;
import courses.formatter.formatter.implementation.Formatter;
import courses.formatter.io.reader.IReader;
import courses.formatter.io.reader.ReaderException;
import courses.formatter.io.reader.implementation.StringReader;
import courses.formatter.io.writer.IWriter;
import courses.formatter.io.writer.WriterException;
import courses.formatter.io.writer.implementation.StringWriter;
import courses.formatter.lexer.implementation.Lexer;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public final class TestsForFormatter {
    private Formatter formatter;
    @Before
    public void init() {
        formatter= new Formatter();
    }
    @Test
    public void test1() throws ReaderException, WriterException, FormatterException {
        IReader reader = new StringReader("aaaa{bbbb;cccc;}");
        IWriter writer = new StringWriter();
        Lexer lexer = new Lexer(reader);
        formatter.format(lexer, writer);
        TestCase.assertEquals("aaaa{\n    bbbb;\n    cccc;\n}", writer.toString());
    }
    @Test
    public void test2() throws ReaderException, WriterException, FormatterException {
        IReader reader = new StringReader("aaaa\n\n\n\n{bbbb\n\n\n\n;\n\n\n\ncccc\n\n\n\n;\n\n\n\n}");
        IWriter writer = new StringWriter();
        Lexer lexer = new Lexer(reader);
        formatter.format(lexer, writer);
        TestCase.assertEquals("aaaa{\n    bbbb;\n    cccc;\n}", writer.toString());
    }
    @Test
    public void test3() throws ReaderException, WriterException, FormatterException {
        IReader reader = new StringReader("aaaa        {       bbbb       ;        cccc    ;            }");
        IWriter writer = new StringWriter();
        Lexer lexer = new Lexer(reader);
        formatter.format(lexer, writer);
        TestCase.assertEquals("aaaa{\n    bbbb;\n    cccc;\n}", writer.toString());
    }
    @Test
    public void test4() throws ReaderException, WriterException, FormatterException {
        IReader reader = new StringReader("aa;aa{bb;bb;cc;cc;}");
        IWriter writer = new StringWriter();
        Formatter formatter = new Formatter();
        Lexer lexer = new Lexer(reader);
        formatter.format(lexer, writer);
        TestCase.assertEquals("aa;\naa{\n    bb;\n    bb;\n    cc;\n    cc;\n}", writer.toString());
    }
    @Test //test of supporting string literals
    public void test5() throws ReaderException, WriterException, FormatterException {
        IReader reader = new StringReader("t(t,    e,    s,    t);y(\"t,    e,    s,    t\");");
        IWriter writer = new StringWriter();
        Formatter formatter = new Formatter();
        Lexer lexer = new Lexer(reader);
        formatter.format(lexer, writer);
        TestCase.assertEquals("t(t, e, s, t);\ny(\"t,    e,    s,    t\");", writer.toString());
    }
}
package testsForFormatter;

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
    public void simpleTestOfNewLine() throws ReaderException, WriterException, FormatterException {
        IReader reader = new StringReader("aaaa{bbbb;cccc;}");
        IWriter writer = new StringWriter();
        Lexer lexer = new Lexer(reader);
        formatter.format(lexer, writer);
        TestCase.assertEquals("aaaa{\n    bbbb;\n    cccc;\n}", writer.toString());
    }
    @Test
    public void moreNewLine() throws ReaderException, WriterException, FormatterException {
        IReader reader = new StringReader("aaaa\n\n\n\n{bbbb\n\n\n\n;\n\n\n\ncccc\n\n\n\n;\n\n\n\n}");
        IWriter writer = new StringWriter();
        Lexer lexer = new Lexer(reader);
        formatter.format(lexer, writer);
        TestCase.assertEquals("aaaa{\n    bbbb;\n    cccc;\n}", writer.toString());
    }
    @Test
    public void testOfSLComment() throws ReaderException, WriterException, FormatterException {
        IReader reader = new StringReader("a{b;c;}\n//test of sl comment\na{b;c;}");
        IWriter writer = new StringWriter();
        Formatter formatter = new Formatter();
        Lexer lexer = new Lexer(reader);
        formatter.format(lexer, writer);
        TestCase.assertEquals("a{\n    b;\n    c;\n}//test of sl comment\na{\n    b;\n    c;\n}", writer.toString());
    }
    @Test
    public void testOfLiteral() throws ReaderException, WriterException, FormatterException {
        IReader reader = new StringReader("a{b(t,    e,    s,    t)\n;c(\"t,    e,    s,    t,    \");}");
        IWriter writer = new StringWriter();
        Formatter formatter = new Formatter();
        Lexer lexer = new Lexer(reader);
        formatter.format(lexer, writer);
        TestCase.assertEquals("a{\n    b(t, e, s, t);\n    c(\"t,    e,    s,    t,    \");\n}", writer.toString());
    }
    @Test
    public void testOfmlComment() throws ReaderException, WriterException, FormatterException {
        IReader reader = new StringReader("a{b;c;}\n/* test of ml {}{}{}{}{};;;;;;;;;\ncomment\n */\na{b;c;}");
        IWriter writer = new StringWriter();
        Formatter formatter = new Formatter();
        Lexer lexer = new Lexer(reader);
        formatter.format(lexer, writer);
        TestCase.assertEquals("a{\n    b;\n    c;\n}/* test of ml {}{}{}{}{};;;;;;;;;\ncomment\n */\na{\n    b;\n    c;\n}", writer.toString());
    }
}
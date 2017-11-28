import courses.formatter.io.reader.ReaderException;
import courses.formatter.io.reader.implementation.StringReader;
import courses.formatter.lexer.LexerException;
import courses.formatter.lexer.implementation.Lexer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class TestsForLexer {
    private Lexer lexer;
    @Test
    public void test1() throws LexerException, ReaderException {
        lexer = new Lexer(new StringReader("q"));
        assertEquals("regularCharacter", lexer.readToken().getName());
    }
    @Test
    public void test2() throws LexerException, ReaderException {
        lexer = new Lexer(new StringReader("{"));
        assertEquals("openingBracket", lexer.readToken().getName());
    }
    @Test
    public void test3() throws LexerException, ReaderException {
        lexer = new Lexer(new StringReader("\n"));
        assertEquals("newLine", lexer.readToken().getName());
    }
    @Test
    public void test4() throws LexerException, ReaderException {
        lexer = new Lexer(new StringReader("\""));
        assertEquals("literal", lexer.readToken().getName());
    }
    @Test
    public void test5() throws LexerException, ReaderException {
        lexer = new Lexer(new StringReader("//1231312"));
        assertEquals("slComment", lexer.readToken().getName());
    }
}
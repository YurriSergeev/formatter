package testsForLexer;

import courses.formatter.io.reader.ReaderException;
import courses.formatter.io.reader.implementation.StringReader;
import courses.formatter.lexer.LexerException;
import courses.formatter.lexer.implementation.Lexer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class TestsForLexer {
    private Lexer lexer;
    @Test
    public void testRegChar() throws LexerException, ReaderException {
        lexer = new Lexer(new StringReader("t"));
        assertEquals("regularCharacter", lexer.readToken().getName());
    }
    @Test
    public void testOfOpeningBr() throws LexerException, ReaderException {
        lexer = new Lexer(new StringReader("{"));
        assertEquals("openingBracket", lexer.readToken().getName());
    }
    @Test
    public void testNewLine() throws LexerException, ReaderException {
        lexer = new Lexer(new StringReader("\n"));
        assertEquals("newLine", lexer.readToken().getName());
    }
    @Test
    public void testLiteral() throws LexerException, ReaderException {
        lexer = new Lexer(new StringReader("\""));
        assertEquals("literal", lexer.readToken().getName());
    }
    @Test
    public void testSlComment() throws LexerException, ReaderException {
        lexer = new Lexer(new StringReader("//1231312"));
        assertEquals("comment", lexer.readToken().getName());
    }
}
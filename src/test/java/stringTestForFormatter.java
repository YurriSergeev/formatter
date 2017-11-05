import com.project.myformatter.Exceptions.ReaderException;
import com.project.myformatter.Exceptions.WriterException;
import com.project.myformatter.IReader;
import com.project.myformatter.IWriter;
import com.project.myformatter.StringIO.myStringReader;
import com.project.myformatter.StringIO.myStringWriter;
import com.project.myformatter.myFormatter;
import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;
import static junit.framework.TestCase.assertEquals;


public class stringTestForFormatter{
    @Test
    public void test1() throws ReaderException, WriterException{
        IReader reader = new myStringReader("aaaa{bbbb;cccc;}");
        IWriter writer = new myStringWriter();
        myFormatter.format(reader, writer);
        assertEquals("aaaa{\n    bbbb;\n    cccc;\n}", writer.toString());
    }
}
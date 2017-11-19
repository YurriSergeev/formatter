package sevenbits.myformatter.interfaces;

import sevenbits.myformatter.exceptions.ReaderException;
import sevenbits.myformatter.exceptions.WriterException;

/**
 * IMyFormatter interface;
 */
public interface IMyFormatter {
    void format(IReader reader, IWriter writer) throws ReaderException, WriterException;
}

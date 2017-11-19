package sevenbits.myformatter.interfaces;

import sevenbits.myformatter.exceptions.CloseException;

/**
 * IClosable interface;
 */
public interface IClosable  extends AutoCloseable {
    void close() throws CloseException;
}

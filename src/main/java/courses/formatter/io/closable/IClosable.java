package courses.formatter.io.closable;

/**
 * IClosable interface;
 */
public interface IClosable  extends AutoCloseable {
    void close() throws CloseException;
}

package courses.formatter.io.closable;

/**
 * IClosable interface;
 */
public interface IClosable  extends AutoCloseable {
    /**
     * close;
     * @throws CloseException - ex;
     */
    void close() throws CloseException;
}

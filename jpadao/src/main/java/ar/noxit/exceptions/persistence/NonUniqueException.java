package ar.noxit.exceptions.persistence;

/**
 * Non Unique Exception
 * 
 * @author Mauro Ciancio
 * 
 */
public class NonUniqueException extends PersistenceException {

    /**
     * {@inheritDoc}
     */
    public NonUniqueException() {
    }

    /**
     * {@inheritDoc}
     */
    public NonUniqueException(String message) {
        super(message);
    }

    /**
     * {@inheritDoc}
     */
    public NonUniqueException(Throwable cause) {
        super(cause);
    }

    /**
     * {@inheritDoc}
     */
    public NonUniqueException(String message, Throwable cause) {
        super(message, cause);
    }

}

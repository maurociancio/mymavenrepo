package ar.noxit.exceptions.persistence;

/**
 * DB Connection Exception
 * 
 * @author Mauro Ciancio
 * 
 */
public class DBConnectionException extends PersistenceException {

    /**
     * {@inheritDoc}
     */
    public DBConnectionException() {
    }

    /**
     * {@inheritDoc}
     */
    public DBConnectionException(String message) {
        super(message);
    }

    /**
     * {@inheritDoc}
     */
    public DBConnectionException(Throwable cause) {
        super(cause);
    }

    /**
     * {@inheritDoc}
     */
    public DBConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

}

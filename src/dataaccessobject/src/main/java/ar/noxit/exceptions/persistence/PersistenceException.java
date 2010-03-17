package ar.noxit.exceptions.persistence;

import ar.noxit.exceptions.NoxitException;

/**
 * Persistence base exception
 * 
 * @author Mauro Ciancio
 * 
 */
public class PersistenceException extends NoxitException {

    /**
     * {@inheritDoc}
     */
    public PersistenceException() {
    }

    /**
     * {@inheritDoc}
     */
    public PersistenceException(String message) {
        super(message);
    }

    /**
     * {@inheritDoc}
     */
    public PersistenceException(Throwable cause) {
        super(cause);
    }

    /**
     * {@inheritDoc}
     */
    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}

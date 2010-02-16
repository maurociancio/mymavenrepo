package ar.noxit.exceptions;

/**
 * Noxit base exception
 * 
 * @author Mauro Ciancio
 * 
 */
public class NoxitException extends Exception {

    /**
     * {@inheritDoc}
     */
    public NoxitException() {
    }

    /**
     * {@inheritDoc}
     */
    public NoxitException(String message) {
        super(message);
    }

    /**
     * {@inheritDoc}
     */
    public NoxitException(Throwable cause) {
        super(cause);
    }

    /**
     * {@inheritDoc}
     */
    public NoxitException(String message, Throwable cause) {
        super(message, cause);
    }
}

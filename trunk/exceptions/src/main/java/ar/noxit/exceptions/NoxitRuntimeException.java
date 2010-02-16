package ar.noxit.exceptions;

/**
 * Noxit base Runtime Exception
 * 
 * @author Mauro Ciancio
 * 
 */
public class NoxitRuntimeException extends RuntimeException {

    /**
     * {@inheritDoc}
     */
    public NoxitRuntimeException() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    public NoxitRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * {@inheritDoc}
     */
    public NoxitRuntimeException(String message) {
        super(message);
    }

    /**
     * {@inheritDoc}
     */
    public NoxitRuntimeException(Throwable cause) {
        super(cause);
    }

}

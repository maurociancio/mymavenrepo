package ar.noxit.exceptions.persistence;

/**
 * Object Not Found Exception
 * 
 * @author Mauro Ciancio
 * 
 */
public class ObjectNotFoundException extends PersistenceException {

    /**
     * {@inheritDoc}
     */
    public ObjectNotFoundException() {
    }

    /**
     * {@inheritDoc}
     */
    public ObjectNotFoundException(String message) {
        super(message);
    }

    /**
     * {@inheritDoc}
     */
    public ObjectNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * {@inheritDoc}
     */
    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}

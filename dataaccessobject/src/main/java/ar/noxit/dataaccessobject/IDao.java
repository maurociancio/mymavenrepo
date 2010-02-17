package ar.noxit.dataaccessobject;

import ar.noxit.exceptions.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;

/**
 * Data Access Object interface to a source of information
 * 
 * @author Mauro Ciancio
 * 
 * @param <T>
 *            class to be stored
 * @param <K>
 *            class of the identifier
 */
public interface IDao<T, K extends Serializable> {

    /**
     * Returns the object specified by the key argument
     * 
     * @param key
     *            to be looked for
     * @return the object
     * @throws PersistenceException
     *             if the object cannot be retrieved
     */
    public T get(K key) throws PersistenceException;

    /**
     * Returns a list containing the objects
     * 
     * @return a list of all objects
     * @throws PersistenceException
     *             if the objects cannot be retrieved
     */
    public List<T> getAll() throws PersistenceException;

    /**
     * Stores an object in the underlying storage
     * 
     * @param object
     *            to be stored
     * @throws PersistenceException
     *             if the object cannot be stored
     */
    public void save(T object) throws PersistenceException;

    /**
     * Removes a object from the underlying storage
     * 
     * @param object
     *            to be removed
     * @throws PersistenceException
     *             if the object cannot be removed
     */
    public void delete(T object) throws PersistenceException;
}

package ar.noxit.dataaccessobject.jpa;

import ar.noxit.dataaccessobject.IDao;
import ar.noxit.exceptions.persistence.DBConnectionException;
import ar.noxit.exceptions.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Abstract JPA DAO. A dao using JPA to access the underlying storage. Four
 * operations are provided (get, getAll, save, delete).
 * 
 * @author Mauro Ciancio
 * 
 * @param <T>
 *            class to be stored using JPA
 * @param <K>
 *            class' identifier
 */
public class AbstractJPADao<T, K extends Serializable> implements IDao<T, K> {

    /**
     * Entity's class
     */
    protected final Class<? extends T> clazz;
    /**
     * Entity Manager
     */
    private EntityManager entityManager = null;

    /**
     * Constructs a new Dao using entity's class
     * 
     * @param clazz
     *            of the entity
     */
    public AbstractJPADao(Class<? extends T> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Entity's class cannot be null");
        }

        this.clazz = clazz;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(K key) throws PersistenceException {
        if (key == null) {
            throw new IllegalArgumentException("id cannot be null");
        }

        EntityManager em = getEntityManager();
        checkEntityManager(em);

        return em.find(clazz, key);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll() throws PersistenceException {
        return createQuery("from " + clazz.getSimpleName()).getResultList();
    }

    /**
     * Creates a new query using the query string passed as argument.
     * 
     * @param query
     *            to be created
     * @return a query object
     * @throws PersistenceException
     *             if the query cannot be created
     */
    protected Query createQuery(String query) throws PersistenceException {
        if (query == null) {
            throw new IllegalArgumentException("query cannot be null");
        }

        EntityManager em = getEntityManager();
        checkEntityManager(em);

        return em.createQuery(query);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(T object) throws PersistenceException {
        EntityManager em = getEntityManager();
        checkEntityManager(em);

        em.persist(object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(T object) throws PersistenceException {
        EntityManager em = getEntityManager();
        checkEntityManager(em);

        em.remove(object);
    }

    /**
     * Returns a entity manager
     * 
     * @return the entity manager
     */
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Checks entity manager's state
     * 
     * @param em
     *            to be checked
     * @throws PersistenceException
     *             if the {@link EntityManager} is not valid (no connection or
     *             null)
     */
    private void checkEntityManager(EntityManager em) throws PersistenceException {
        if (em == null) {
            throw new IllegalArgumentException("entity manager cannot be null");
        }
        if (!em.isOpen()) {
            throw new DBConnectionException("the entity manager's session is closed");
        }
    }
}

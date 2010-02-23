package ar.noxit.dataaccessobject.jpa;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 * A dao that uses Warp and Guice to obtain the EntityManager
 * 
 * @author Mauro Ciancio
 * 
 * @param <T>
 *            {@link AbstractJPADao#AbstractJPADao(Class)}
 * @param <K>
 *            {@link AbstractJPADao#AbstractJPADao(Class)}
 */
abstract public class AbstractGuiceWarpJPADao<T, K extends Serializable> extends AbstractJPADao<T, K> {

    /**
     * A entity manager provider. It's managed by warp and google guice.
     */
    @Inject
    private Provider<EntityManager> entityManager;

    /**
     * Creates a new DAO
     * 
     * @param clazz
     *            to be used with jpa
     */
    public AbstractGuiceWarpJPADao(Class<? extends T> clazz) {
        super(clazz);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EntityManager getEntityManager() {
        return entityManager.get();
    }
}

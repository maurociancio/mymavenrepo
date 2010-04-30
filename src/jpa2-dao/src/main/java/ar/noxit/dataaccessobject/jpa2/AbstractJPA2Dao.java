package ar.noxit.dataaccessobject.jpa2;

import ar.noxit.dataaccessobject.IDao;
import ar.noxit.exceptions.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractJPA2Dao<T, K extends Serializable> implements IDao<T, K> {

    private EntityManager entityManager = null;
    private Class<? extends T> clazz;

    public AbstractJPA2Dao(Class<? extends T> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("class cant be null");
        }
        this.clazz = clazz;
    }

    @Override
    public T get(K key) throws PersistenceException {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        EntityManager em = getEntityManager();
        return em.find(clazz, key);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() throws PersistenceException {
        EntityManager em = getEntityManager();
        return em.createQuery("from " + clazz.getSimpleName()).getResultList();
    }

    @Override
    public void save(T object) throws PersistenceException {
        EntityManager em = getEntityManager();
        em.persist(object);
    }

    @Override
    public void delete(T object) throws PersistenceException {
        EntityManager em = getEntityManager();
        em.remove(object);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}

package ar.noxit.dataaccessobject.hibernate;

import ar.noxit.dataaccessobject.IDao;
import ar.noxit.exceptions.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateDao<T, K extends Serializable> implements IDao<T, K> {

    private SessionFactory sessionFactory;
    private final String entityName;

    public HibernateDao(Class<? extends T> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("class no puede ser null");
        }
        this.entityName = clazz.getSimpleName();
    }

    public HibernateDao(String entityName) {
        if (entityName == null) {
            throw new IllegalArgumentException("entityName no puede ser null");
        }
        this.entityName = entityName;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void delete(T object) throws PersistenceException {
        getSession().delete(entityName, object);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(K id) throws PersistenceException {
        return (T) getSession().get(entityName, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() throws PersistenceException {
        return getSession().createQuery("from " + entityName).list();
    }

    @Override
    public void save(T object) throws PersistenceException {
        getSession().persist(entityName, object);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

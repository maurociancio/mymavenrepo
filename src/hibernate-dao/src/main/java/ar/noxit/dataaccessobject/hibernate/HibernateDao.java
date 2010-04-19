package ar.noxit.dataaccessobject.hibernate;

import ar.noxit.dataaccessobject.IDao;
import ar.noxit.exceptions.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateDao<T, K extends Serializable> implements IDao<T, K> {

    private SessionFactory sessionFactory;
    private final Class<? extends T> clazz;

    public HibernateDao(Class<? extends T> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("class no puede ser null");
        }
        this.clazz = clazz;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void delete(T object) throws PersistenceException {
        getSession().delete(clazz.getSimpleName(), object);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(K id) throws PersistenceException {
        return (T) getSession().get(clazz.getSimpleName(), id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() throws PersistenceException {
        return getSession().createQuery("from " + clazz.getSimpleName()).list();
    }

    @Override
    public void save(T object) throws PersistenceException {
        getSession().persist(clazz.getSimpleName(), object);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

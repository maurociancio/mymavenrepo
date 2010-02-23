package ar.noxit.dataaccessobject.hibernate;

import ar.noxit.dataaccessobject.IDao;
import java.lang.reflect.Method;
import javax.persistence.PersistenceException;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.ObjectNotFoundException;

/**
 * An Hibernate exception translator implemented using a cglib interceptor
 * 
 * @author Mauro Ciancio
 * 
 */
public class HibernateExceptionTranslatorInterceptor implements MethodInterceptor {

    /**
     * Dao to be wrapped
     */
    private IDao<?, ?> dao;

    /**
     * Creates a new interceptor to wrap the dao argument
     * 
     * @param dao
     *            to be wrapped
     */
    public HibernateExceptionTranslatorInterceptor(IDao<?, ?> dao) {
        if (dao == null) {
            throw new IllegalArgumentException("dao cannot be null");
        }

        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        try {
            return method.invoke(dao, args);
        } catch (PersistenceException e) {
            // jpa exception
            try {
                throw e.getCause();
            } catch (ObjectNotFoundException ex) {
                throw new ar.noxit.exceptions.persistence.ObjectNotFoundException("El objeto no se encontró", ex);
            } catch (NonUniqueObjectException ex) {
                throw new ar.noxit.exceptions.persistence.NonUniqueException("Objecto duplicado", e);
            } catch (Throwable ex) {
                throw new ar.noxit.exceptions.persistence.PersistenceException("Excepción irrecuperable", ex);
            }
        } catch (Exception ex) {
            // other exception type
            if (!(ex instanceof ar.noxit.exceptions.persistence.PersistenceException)) {
                throw new ar.noxit.exceptions.persistence.PersistenceException("Excepción irrecuperable", ex);
            }
            throw ex;
        }
    }
}

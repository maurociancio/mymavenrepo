package ar.noxit.dataaccessobject.hibernate;

import ar.noxit.dataaccessobject.IExceptionTranslatorWrapper;

import ar.noxit.dataaccessobject.IDao;
import java.io.Serializable;
import net.sf.cglib.proxy.Enhancer;

/**
 * An exception wrapper for the Hibernate API.
 * 
 * @author Mauro Ciancio
 * 
 */
public class HibernateExceptionTranslatorWrapper implements IExceptionTranslatorWrapper {

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T, K extends Serializable> IDao<T, K> translationWrapper(IDao<T, K> dao) {
        return (IDao<T, K>) Enhancer.create(IDao.class, new HibernateExceptionTranslatorInterceptor(dao));
    }
}

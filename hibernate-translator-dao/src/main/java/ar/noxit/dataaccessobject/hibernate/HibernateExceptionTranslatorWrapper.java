package ar.noxit.dataaccessobject.hibernate;

import ar.noxit.dataaccessobject.IDao;
import ar.noxit.dataaccessobject.IExceptionTranslatorWrapper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    public <T, K extends Serializable> IDao<T, K> translationWrapper(IDao<T, K> dao, Class<?> extraInterfaces[]) {
        Class<?> extraInterfac[] = extraInterfaces;
        if (extraInterfac == null) {
            extraInterfac = new Class<?>[] {};
        }

        List<Class<?>> interfaces = new ArrayList(Arrays.asList(extraInterfac));
        interfaces.add(IDao.class);

        return (IDao<T, K>) Enhancer.create(null, createArray(interfaces), new HibernateExceptionTranslatorInterceptor(
                dao));
    }

    private Class<?>[] createArray(List<Class<?>> interfaces) {
        Class<?> extraInterfaces[] = new Class<?>[interfaces.size()];
        for (int i = 0; i < interfaces.size(); i++)
            extraInterfaces[i] = interfaces.get(i);
        return extraInterfaces;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, K extends Serializable> IDao<T, K> translationWrapper(IDao<T, K> dao) {
        return translationWrapper(dao, null);
    }
}

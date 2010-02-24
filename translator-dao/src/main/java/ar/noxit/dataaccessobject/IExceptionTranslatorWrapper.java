package ar.noxit.dataaccessobject;

import java.io.Serializable;

/**
 * An exception translation wrapper that wraps a dao. When an exception is
 * raised, it translate into the proper exception.
 * 
 * @author Mauro Ciancio
 * 
 */
public interface IExceptionTranslatorWrapper {

    /**
     * Wraps a dao.
     * 
     * @param <T>
     *            type of the class
     * @param <K>
     *            type of the class' id
     * @param dao
     *            to be wrapped
     * @return a wrapped dao
     */
    public <T, K extends Serializable> IDao<T, K> translationWrapper(IDao<T, K> dao);

    /**
     * Wraps a dao.
     * 
     * @param <T>
     *            type of the class
     * @param <K>
     *            type of the class' id
     * @param dao
     *            to be wrapped
     * @param extraInterfaces
     *            interfaces to be implemented (can be null)
     * @return a wrapped dao
     */
    public <T, K extends Serializable> IDao<T, K> translationWrapper(IDao<T, K> dao, Class<?> extraInterfaces[]);
}

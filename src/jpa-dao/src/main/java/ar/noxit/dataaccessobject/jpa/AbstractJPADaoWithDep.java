package ar.noxit.dataaccessobject.jpa;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractJPADaoWithDep<T, K extends Serializable> extends AbstractJPADao<T, K> {

    private EntityManager em;

    public AbstractJPADaoWithDep(Class<? extends T> clazz) {
        super(clazz);
    }

    @PersistenceContext
    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

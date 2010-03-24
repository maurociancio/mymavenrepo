package ar.noxit.dataaccessobject.hibernate;

import ar.noxit.dataaccessobject.IDao;

public abstract class HibernateTranslator {

    public static IDao<?, ?> get(IDao<?, ?> instance) {
        Class<?>[] interfaces = instance.getClass().getInterfaces();
        return new HibernateExceptionTranslatorWrapper().translationWrapper(instance, interfaces);
    }

    private HibernateTranslator() {
    }
}

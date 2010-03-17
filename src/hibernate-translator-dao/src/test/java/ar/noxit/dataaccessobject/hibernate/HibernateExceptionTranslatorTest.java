package ar.noxit.dataaccessobject.hibernate;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import ar.noxit.dataaccessobject.IDao;
import ar.noxit.dataaccessobject.IExceptionTranslatorWrapper;
import ar.noxit.exceptions.persistence.NonUniqueException;
import javax.persistence.PersistenceException;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.ObjectNotFoundException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HibernateExceptionTranslatorTest {

    private IDao<Long, Long> mockDao;
    private IDao<Long, Long> wrappedDao;
    private IExceptionTranslatorWrapper wrapper;

    @BeforeMethod
    @SuppressWarnings("unchecked")
    public void setUp() {
        mockDao = createMock(IDao.class);
        wrapper = new HibernateExceptionTranslatorWrapper();
        wrappedDao = wrapper.translationWrapper(mockDao);
    }

    @Test(expectedExceptions = NonUniqueException.class)
    public void testNonUniqueException() throws Exception {
        expect(mockDao.get(1L)).andThrow(new PersistenceException(new NonUniqueObjectException(1, null)));
        replay(mockDao);

        wrappedDao.get(1L);
    }

    @Test(expectedExceptions = ar.noxit.exceptions.persistence.ObjectNotFoundException.class)
    public void testObjectNotFoundException() throws Exception {
        expect(mockDao.get(1L)).andThrow(new PersistenceException(new ObjectNotFoundException(1, null)));
        replay(mockDao);

        wrappedDao.get(1L);
    }

    @Test(expectedExceptions = ar.noxit.exceptions.persistence.PersistenceException.class)
    public void testOtherException() throws Exception {
        expect(mockDao.get(1L)).andThrow(new PersistenceException());
        replay(mockDao);

        wrappedDao.get(1L);
    }
}

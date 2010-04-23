package ar.noxit.web.wicket.provider;

import ar.noxit.exceptions.NoxitException;
import ar.noxit.exceptions.NoxitRuntimeException;
import java.util.List;

public abstract class SimpleDataProvider<T> extends DataProvider<T> {

    @Override
    protected List<T> loadList() {
        try {
            return doLoadList();
        } catch (NoxitException e) {
            throw new NoxitRuntimeException(e);
        }
    }

    protected abstract List<T> doLoadList() throws NoxitException;
}

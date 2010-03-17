package ar.noxit.web.wicket.provider;

import ar.noxit.exceptions.NoxitException;
import ar.noxit.exceptions.NoxitRuntimeException;
import ar.noxit.utils.Identifiable;
import java.io.Serializable;
import java.util.List;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public abstract class CacheableDataProvider<K extends Serializable, T extends Identifiable<K>> extends DataProvider<T> {

    private transient List<T> data = null;

    @Override
    protected List<T> loadList() {
        try {
            if (this.data == null) {
                this.data = doLoadList();
            }
            return this.data;
        } catch (NoxitException ex) {
            throw new NoxitRuntimeException(ex);
        }
    }

    protected abstract List<T> doLoadList() throws NoxitException;

    @Override
    public IModel<T> model(final T object) {
        return new LoadableDetachableModel<T>(object) {

            private K id = object.getId();

            @Override
            protected T load() {
                for (T obj : loadList()) {
                    if (obj.getId().equals(id)) {
                        return obj;
                    }
                }

                // @todo
                return null;
            }
        };
    }

    @Override
    public void detach() {
        super.detach();

        this.data = null;
    }
}

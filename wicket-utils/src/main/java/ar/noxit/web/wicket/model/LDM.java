package ar.noxit.web.wicket.model;

import ar.noxit.exceptions.NoxitRuntimeException;

import ar.noxit.exceptions.NoxitException;

import org.apache.wicket.model.LoadableDetachableModel;

public abstract class LDM<T> extends LoadableDetachableModel<T> {

    @Override
    protected T load() {
        try {
            return doLoad();
        } catch (NoxitException ex) {
            throw new NoxitRuntimeException(ex);
        }
    }

    protected abstract T doLoad() throws NoxitException;
}

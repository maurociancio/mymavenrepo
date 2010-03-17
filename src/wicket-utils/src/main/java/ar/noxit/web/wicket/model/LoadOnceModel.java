package ar.noxit.web.wicket.model;

import ar.noxit.exceptions.NoxitRuntimeException;

import ar.noxit.exceptions.NoxitException;

import org.apache.wicket.model.IModel;

public abstract class LoadOnceModel<T> implements IModel<T> {

    private T object = null;
    private boolean loaded = false;

    public LoadOnceModel() {
        this(null);
    }

    private LoadOnceModel(T object) {
        this.object = object;
    }

    @Override
    public T getObject() {
        if (!this.loaded) {
            try {
                this.object = doLoad();
                this.loaded = true;
            } catch (NoxitException ex) {
                throw new NoxitRuntimeException(ex);
            }
        }
        return object;
    }

    protected abstract T doLoad() throws NoxitException;

    @Override
    public void setObject(T object) {
        this.loaded = true;
        this.object = object;
    }

    @Override
    public void detach() {
    }
}

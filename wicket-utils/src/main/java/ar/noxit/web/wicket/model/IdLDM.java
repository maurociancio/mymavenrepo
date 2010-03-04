package ar.noxit.web.wicket.model;

import ar.noxit.exceptions.NoxitException;
import ar.noxit.exceptions.NoxitRuntimeException;
import java.io.Serializable;
import org.apache.wicket.model.IModel;

public abstract class IdLDM<T, K extends Serializable> implements IModel<T> {

    private transient T object = null;
    private boolean attached = false;
    private final IModel<K> idModel;

    public IdLDM(IModel<K> idModel) {
        checkIdModel(idModel);
        this.idModel = idModel;
    }

    public IdLDM(IModel<K> idModel, T object) {
        checkIdModel(idModel);
        this.idModel = idModel;

        attach(object);
    }

    @Override
    public T getObject() {
        try {
            if (!this.attached) {
                K id = idModel.getObject();
                attach(id != null ? doLoad(id) : null);
            }
            return object;
        } catch (NoxitException e) {
            throw new NoxitRuntimeException(e);
        }
    }

    @Override
    public void setObject(T object) {
        attach(object);
    }

    @Override
    public void detach() {
        this.attached = false;
        this.object = null;
        this.idModel.detach();
    }

    protected void attach(T object) {
        this.attached = true;
        this.object = object;
        if (object != null) {
            idModel.setObject(getObjectId(object));
        }
    }

    protected abstract T doLoad(K id) throws NoxitException;

    protected abstract K getObjectId(T object);

    private void checkIdModel(IModel<K> idModel) {
        if (idModel == null)
            throw new IllegalArgumentException("id model cannot be null");
    }
}

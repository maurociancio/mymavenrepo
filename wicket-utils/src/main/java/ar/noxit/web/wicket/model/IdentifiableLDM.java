package ar.noxit.web.wicket.model;

import org.apache.wicket.model.IModel;
import ar.noxit.utils.Identifiable;
import java.io.Serializable;

public abstract class IdentifiableLDM<K extends Serializable, T extends Identifiable<K>> extends IdLDM<T, K> {

    public IdentifiableLDM(IModel<K> idModel) {
        super(idModel);
    }

    public IdentifiableLDM(IModel<K> idModel, T object) {
        super(idModel, object);
    }

    @Override
    protected K getObjectId(T object) {
        return object.getId();
    }
}

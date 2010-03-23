package ar.noxit.web.wicket.column;

import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

public abstract class AbstractReadOnlyColumn<T> extends AbstractLabelColumn<T> {

    public AbstractReadOnlyColumn(IModel<String> displayModel, String sortProperty) {
        super(displayModel, sortProperty);
    }

    public AbstractReadOnlyColumn(IModel<String> displayModel) {
        super(displayModel);
    }

    @Override
    protected IModel<String> createDisplayModel(final IModel<T> rowModel) {
        return new AbstractReadOnlyModel<String>() {

            @Override
            public String getObject() {
                T object = rowModel.getObject();
                if (object == null) {
                    return AbstractReadOnlyColumn.this.getLabelStringWhenNullObject();
                }
                return AbstractReadOnlyColumn.this.getLabelString(object);
            }
        };
    }

    protected abstract String getLabelString(T object);

    protected String getLabelStringWhenNullObject() {
        return getLabelString(null);
    }
}

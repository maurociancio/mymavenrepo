package ar.noxit.web.wicket.model;

import org.apache.wicket.model.IModel;

/**
 * A model that returns a default value if the delegate returns null
 * 
 * @author Mauro Ciancio
 * 
 * @param <T>
 */
public class DefaultValueModel<T> implements IModel<T> {

    /**
     * Default value
     */
    private T defaultValue = null;
    /**
     * Delegate Model
     */
    private IModel<T> model = null;

    /**
     * 
     * @param defaultValue
     *            to be returned when the delegate model returns null
     * @param model
     *            delegate model
     */
    public DefaultValueModel(T defaultValue, IModel<T> model) {
        if (model == null)
            throw new IllegalArgumentException("model cannot be null");
        this.defaultValue = defaultValue;
        this.model = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getObject() {
        T obj = getValue();
        if (obj == null) {
            T defaultValue = getDefaultValue();
            model.setObject(defaultValue);
            return defaultValue;
        }
        return obj;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setObject(T object) {
        model.setObject(object);
    }

    /**
     * Returns the default value
     * 
     * @return default value
     */
    protected T getDefaultValue() {
        return defaultValue;
    }

    /**
     * Returns the delegate model's value
     * 
     * @return delegate model's value
     */
    protected T getValue() {
        return model.getObject();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void detach() {
        model.detach();
    }
}

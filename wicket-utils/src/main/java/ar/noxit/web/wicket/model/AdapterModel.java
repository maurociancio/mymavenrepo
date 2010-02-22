package ar.noxit.web.wicket.model;

import org.apache.wicket.model.IModel;

/**
 * Simplifies implementing wrapper models that adapt from model object of one
 * type to another
 * 
 * @author igor.vaynberg
 * 
 * @param <N>
 *            new type
 * @param <O>
 *            old type
 */
public abstract class AdapterModel<N, O> implements IModel<N> {
    private static final long serialVersionUID = 1L;

    /** delegate model */
    private final IModel<O> delegate;

    /**
     * Constructor
     * 
     * @param delegate
     *            model to be wrapped
     */
    public AdapterModel(IModel<O> delegate) {
        this.delegate = delegate;
    }

    /** {@inheritDoc} */
    public N getObject() {
        return getObject(delegate);
    }

    /**
     * Translates from <code>IModel</code> of type <code>T</code> to object of
     * type <code>A</code>
     * 
     * @param delegate
     * @return adapter value of <code>delegate</code> model
     */
    protected abstract N getObject(IModel<O> delegate);

    /** {@inheritDoc} */
    public void setObject(N object) {
        setObject(object, delegate);
    }

    /**
     * Translates from object of type <code>A</code> to <code>IModel</code> of
     * type <code>T</code>
     * 
     * @param object
     *            adapted object that needs to be unadopted
     * @param delegate
     *            delegate model whose value should be set to unadopted version
     *            of <code>object</code>
     */
    protected abstract void setObject(N object, IModel<O> delegate);

    /** {@inheritDoc} */
    public void detach() {
        delegate.detach();
    }
}
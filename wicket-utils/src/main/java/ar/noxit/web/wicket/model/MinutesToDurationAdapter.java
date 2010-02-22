package ar.noxit.web.wicket.model;

import org.apache.wicket.model.IModel;
import org.joda.time.Duration;

/**
 * A model class used to adapt from minutes (int) to duration.
 * 
 * @author Mauro Ciancio
 * 
 */
public class MinutesToDurationAdapter extends AdapterModel<Integer, Duration> {

    /**
     * Creates an adapter using a model.
     * 
     * @param delegate
     */
    public MinutesToDurationAdapter(IModel<Duration> delegate) {
        super(delegate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getObject(IModel<Duration> delegate) {
        Duration duration = delegate.getObject();
        return duration != null ? Long.valueOf(duration.getStandardSeconds() / 60).intValue() : null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setObject(Integer object, IModel<Duration> delegate) {
        delegate.setObject(object != null ? Duration.standardMinutes(object) : null);
    }
}

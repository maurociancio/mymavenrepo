package ar.noxit.web.wicket.image.model;

import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.joda.time.Duration;

/**
 * A model that converts from {@link Duration} to string.
 * 
 * @author Mauro Ciancio
 * 
 */
public class DurationStringModel extends AbstractReadOnlyModel<String> {

    /**
     * Duration Model
     */
    private IModel<Duration> durationModel;

    /**
     * Constructs a new DurationStringModel using a duration model
     * 
     * @param durationModel
     *            that provides the Duration
     */
    public DurationStringModel(IModel<Duration> durationModel) {
        if (durationModel == null) {
            throw new IllegalArgumentException("duration model cannot be null");
        }
        this.durationModel = durationModel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getObject() {
        Duration duration = durationModel.getObject();
        if (duration == null)
            return null;

        long duracionEnSegundos = duration.getStandardSeconds();
        long minutos = (duracionEnSegundos / 60) % 60;
        long horas = duracionEnSegundos / (60 * 60);
        long segundos = duracionEnSegundos % 60;

        return (horas > 0 ? horas + ":" : "0:") + ((minutos < 10 ? "0" : "") + minutos + ":")
                + (segundos < 10 ? "0" : "") + segundos;
    }
}

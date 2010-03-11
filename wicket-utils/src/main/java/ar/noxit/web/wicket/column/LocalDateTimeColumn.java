package ar.noxit.web.wicket.column;

import ar.noxit.web.wicket.model.LocalDateTimeFormatModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.joda.time.LocalDateTime;

public class LocalDateTimeColumn<T> extends AbstractLabelColumn<T> {

    private String property;

    public LocalDateTimeColumn(IModel<String> displayModel, String property) {
        super(displayModel);
        this.property = property;
    }

    public LocalDateTimeColumn(IModel<String> displayModel, String sortProperty, String property) {
        super(displayModel, sortProperty);
        this.property = property;
    }

    @Override
    protected IModel<String> createDisplayModel(IModel<T> rowModel) {
        return new LocalDateTimeFormatModel(new PropertyModel<LocalDateTime>(rowModel, property));
    }
}
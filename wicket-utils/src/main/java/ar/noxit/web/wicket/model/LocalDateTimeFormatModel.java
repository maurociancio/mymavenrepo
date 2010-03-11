package ar.noxit.web.wicket.model;

import org.apache.wicket.model.IModel;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class LocalDateTimeFormatModel extends AbstractLocalDateTimeFormatModel {

    public LocalDateTimeFormatModel(IModel<LocalDateTime> delegate) {
        super(delegate);
    }

    @Override
    protected DateTimeFormatter getFormatter() {
        return DateTimeFormat.forPattern("dd/MM/YYYY HH:mm");
    }
}

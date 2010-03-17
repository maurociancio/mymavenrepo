package ar.noxit.web.wicket.model;

import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;

public abstract class AbstractLocalDateTimeFormatModel extends AbstractReadOnlyModel<String> {

    private IModel<LocalDateTime> delegate;

    public AbstractLocalDateTimeFormatModel(IModel<LocalDateTime> delegate) {
        if (delegate == null) {
            throw new IllegalArgumentException("delegate model cannot be null");
        }
        this.delegate = delegate;
    }

    protected abstract DateTimeFormatter getFormatter();

    private DateTimeFormatter doGetFormatter() {
        DateTimeFormatter formatter = getFormatter();
        if (formatter == null) {
            throw new IllegalStateException("formatter cannot be null");
        }
        return formatter;
    }

    @Override
    public String getObject() {
        LocalDateTime dateTime = delegate.getObject();
        if (dateTime == null)
            return getNullValue();
        return doGetFormatter().print(dateTime);
    }

    protected String getNullValue() {
        return "";
    }
}

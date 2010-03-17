package ar.noxit.web.wicket.model;

import java.util.Date;
import org.apache.wicket.model.IModel;
import org.joda.time.LocalDate;

public class Date2LocalDateModelAdapter extends AdapterModel<Date, LocalDate> {

    public Date2LocalDateModelAdapter(IModel<LocalDate> delegate) {
        super(delegate);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected Date getObject(IModel<LocalDate> delegate) {
        LocalDate date = delegate.getObject();
        if (date == null)
            return null;
        int year = date.getYear();
        int monthOfYear = date.getMonthOfYear();
        int dayOfMonth = date.getDayOfMonth();
        return new Date(year, monthOfYear, dayOfMonth);
    }

    @Override
    protected void setObject(Date object, IModel<LocalDate> delegate) {
        if (object == null)
            delegate.setObject(null);
        else {
            delegate.setObject(new LocalDate(object));
        }
    }
}

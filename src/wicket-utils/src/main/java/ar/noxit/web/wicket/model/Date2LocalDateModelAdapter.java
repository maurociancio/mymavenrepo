package ar.noxit.web.wicket.model;

import java.util.Calendar;
import java.util.Date;
import org.apache.wicket.model.IModel;
import org.joda.time.LocalDate;

public class Date2LocalDateModelAdapter extends AdapterModel<Date, LocalDate> {

    public Date2LocalDateModelAdapter(IModel<LocalDate> delegate) {
        super(delegate);
    }

    @Override
    protected Date getObject(IModel<LocalDate> delegate) {
        LocalDate date = delegate.getObject();
        if (date == null)
            return null;

        Calendar calendar = Calendar.getInstance();
        calendar.set(date.getYear(), date.getMonthOfYear() - 1, date.getDayOfMonth(), 0, 0, 0);
        return calendar.getTime();
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

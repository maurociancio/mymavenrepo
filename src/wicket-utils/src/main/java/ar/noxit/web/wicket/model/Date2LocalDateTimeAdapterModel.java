package ar.noxit.web.wicket.model;

import java.util.Calendar;
import java.util.Date;
import org.apache.wicket.model.IModel;
import org.joda.time.LocalDateTime;

/**
 * Adapter Model that converts from Date to LocalDateTime
 * 
 * @author Mauro Ciancio
 * 
 */
public class Date2LocalDateTimeAdapterModel extends AdapterModel<Date, LocalDateTime> {

    public Date2LocalDateTimeAdapterModel(IModel<LocalDateTime> delegate) {
        super(delegate);
    }

    @Override
    protected Date getObject(IModel<LocalDateTime> delegate) {
        LocalDateTime ldt = delegate.getObject();
        if (ldt == null)
            return null;

        int year = ldt.getYear();
        int monthOfYear = ldt.getMonthOfYear();
        int dayOfMonth = ldt.getDayOfMonth();
        int hourOfDay = ldt.getHourOfDay();
        int minuteOfHour = ldt.getMinuteOfHour();
        int secondOfMinute = ldt.getSecondOfMinute();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthOfYear - 1, dayOfMonth, hourOfDay, minuteOfHour, secondOfMinute);
        return calendar.getTime();
    }

    @Override
    protected void setObject(Date object, IModel<LocalDateTime> delegate) {
        if (object == null) {
            delegate.setObject(null);
        } else {
            delegate.setObject(new LocalDateTime(object));
        }
    }
}

package ar.noxit.web.wicket.model;

import java.util.Calendar;
import java.util.Date;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.joda.time.LocalDate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Date2LocalDateAdapterModelTest {

    @Test
    public void testAdapter() {
        LocalDate localDate = new LocalDate();
        Model<LocalDate> model = Model.of(localDate);

        IModel<Date> adapter = new Date2LocalDateModelAdapter(model);
        Date date = adapter.getObject();

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        Assert.assertEquals(localDate.getYear(), c.get(Calendar.YEAR));
        Assert.assertEquals(localDate.getMonthOfYear(), c.get(Calendar.MONTH) + 1);
        Assert.assertEquals(localDate.getDayOfMonth(), c.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void testSettingAdapter() {
        Model<LocalDate> model = new Model<LocalDate>();

        IModel<Date> adapter = new Date2LocalDateModelAdapter(model);
        Date object = new Date();
        adapter.setObject(object);

        Calendar c = Calendar.getInstance();
        c.setTime(object);

        LocalDate ld = model.getObject();
        Assert.assertEquals(ld.getYear(), c.get(Calendar.YEAR));
        Assert.assertEquals(ld.getMonthOfYear(), c.get(Calendar.MONTH) + 1);
        Assert.assertEquals(ld.getDayOfMonth(), c.get(Calendar.DAY_OF_MONTH));
    }
}

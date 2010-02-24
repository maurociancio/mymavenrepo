package ar.noxit.web.wicket.provider;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;

public abstract class DataProvider<T> extends SortableDataProvider<T> {

    private final Map<String, Comparator<T>> comparators = new HashMap<String, Comparator<T>>();

    public void addComparator(String field, Comparator<T> comparator) {
        this.comparators.put(field, comparator);
    }

    public Comparator<T> getComparator(String field) {
        return this.comparators.get(field);
    }

    @Override
    public Iterator<? extends T> iterator(int first, int count) {
        List<T> data = loadList();

        // parametros de ordenacion
        SortParam sortParam = getSort();

        // si es null no ordenamos
        if (sortParam != null) {
            String property = sortParam.getProperty();
            boolean ascending = sortParam.isAscending();

            // comparator
            Comparator<T> comparator = getComparator(property);

            // ordenacion
            Collections.sort(data, new DataSortComparator<T>(comparator, ascending));
        }

        return data.subList(first, first + count).iterator();
    }

    protected abstract List<T> loadList();

    @Override
    public int size() {
        return loadList().size();
    }
}

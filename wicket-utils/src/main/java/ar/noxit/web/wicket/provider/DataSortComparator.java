package ar.noxit.web.wicket.provider;

import java.util.Comparator;

public class DataSortComparator<T> implements Comparator<T> {

    private Comparator<T> comparator;
    private int factor;

    public DataSortComparator(Comparator<T> comparator, boolean isAscending) {
        if (comparator == null) {
            throw new IllegalArgumentException("comparator cannot be null");
        }

        this.comparator = comparator;
        this.factor = isAscending ? 1 : -1;
    }

    @Override
    public int compare(T o1, T o2) {
        return factor * comparator.compare(o1, o2);
    }
}

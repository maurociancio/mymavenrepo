package ar.noxit.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Collections {

    public static <T> List<T> toList(Iterator<T> iterator) {
        if (iterator == null) {
            throw new IllegalArgumentException("iterator cannot be null");
        }
        List<T> list = new ArrayList<T>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    private Collections() {
    }
}

package ar.noxit.utils;

import java.io.Serializable;

public interface Identifiable<K extends Serializable> extends Serializable {

    K getId();
}

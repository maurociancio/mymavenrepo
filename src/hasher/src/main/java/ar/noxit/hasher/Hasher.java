package ar.noxit.hasher;

/**
 * An interface to a hashing algorithm.
 * 
 * @author Mauro Ciancio
 * 
 */
public interface Hasher {

    /**
     * Hash a text
     * 
     * @param text
     *            to be hashed
     * @return hashed text
     */
    String hash(String text);
}

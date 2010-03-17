package ar.noxit.hasher;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A hasher implementation using MD5 algorithm
 * 
 * @author Mauro Ciancio
 * 
 */
public class MD5Hasher implements Hasher {

    private MessageDigest messageDigest = null;

    /**
     * Creates a new MD5Hasher
     */
    public MD5Hasher() {
        try {
            this.messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("algorithm not found", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String hash(String text) {
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }

        messageDigest.reset();
        messageDigest.update(text.getBytes());

        byte[] encrypted = messageDigest.digest();
        BigInteger bigInt = new BigInteger(1, encrypted);
        String hashedText = bigInt.toString(16);
        while (hashedText.length() < 32) {
            hashedText = "0" + hashedText;
        }
        return hashedText;
    }
}

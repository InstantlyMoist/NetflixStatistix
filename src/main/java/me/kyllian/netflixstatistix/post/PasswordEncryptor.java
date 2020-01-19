package me.kyllian.netflixstatistix.post;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptor {

    private static MessageDigest messageDigest;

    /**
     * Encrypts a password with MD5
     * @param password
     * @return encrypted password
     */

    public static String encrypt(String password) {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            byte[] passBytes = password.getBytes();
            messageDigest.reset();
            byte[] digested = messageDigest.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digested.length; i++) {
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}

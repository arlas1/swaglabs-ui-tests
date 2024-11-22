package swaglabs.utils.common;

import java.security.SecureRandom;
import java.util.Random;

public class RandomStringGenerator {
    private static final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:',.<>?/`~";
    private static final Random RANDOM = new SecureRandom();

    public static String generateAlphabetString(int length) {
        return generateRandomString(ALPHABETS, length);
    }

    public static String generateAlphanumericString(int length) {
        return generateRandomString(ALPHABETS + NUMBERS, length);
    }

    public static String generateComplexString(int length) {
        return generateRandomString(ALPHABETS + NUMBERS + SPECIAL_CHARACTERS, length);
    }

    private static String generateRandomString(String pool, int length) {
        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(pool.length());
            result.append(pool.charAt(index));
        }
        return result.toString();
    }
}

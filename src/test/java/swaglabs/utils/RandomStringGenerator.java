package swaglabs.utils;

import swaglabs.constants.InputConstants.InputLength;
import swaglabs.constants.InputConstants.InputType;
import java.security.SecureRandom;
import java.util.Random;

public class RandomStringGenerator {
    private static final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:',.<>?/`~";
    private static final Random RANDOM = new SecureRandom();

    public static String generateRandomInput(InputType inputType, InputLength inputLength) {
        int length = inputLength.getLength();
        String characterPool = switch (inputType) {
            case ALPHABET -> ALPHABETS;
            case ALPHANUMERIC -> ALPHABETS + NUMBERS;
            case COMPLEX -> ALPHABETS + NUMBERS + SPECIAL_CHARACTERS;
            default -> throw new IllegalArgumentException("Unsupported InputType: " + inputType);
        };

        return generateRandomString(characterPool, length);
    }

    private static String generateRandomString(String pool, int length) {
        StringBuilder result = new StringBuilder(length);
        int poolLength = pool.length();
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(poolLength);
            result.append(pool.charAt(index));
        }
        return result.toString();
    }
}

package swaglabs.utils;

import swaglabs.constants.InputDetails.InputLength;
import swaglabs.constants.InputDetails.InputType;
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

    public static String generateRandomZipPostalCode() {
        int length = RANDOM.nextInt(4) + 5;
        StringBuilder zipCode = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (RANDOM.nextBoolean()) {
                zipCode.append(RANDOM.nextInt(10));
            } else {
                char letter = (char) ('A' + RANDOM.nextInt(26));
                zipCode.append(letter);
            }
        }
        if (RANDOM.nextBoolean() && length > 5) {
            int position = RANDOM.nextInt(length - 4) + 2;
            zipCode.insert(position, RANDOM.nextBoolean() ? ' ' : '-');
        }
        return zipCode.toString();
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

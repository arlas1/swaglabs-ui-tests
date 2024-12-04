package swaglabs.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CustomAssert {
    private static final Logger logger = LoggerFactory.getLogger(CustomAssert.class);

    private CustomAssert() {

    }

    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            String errorMessage = "FAIL: " + message + " - Expected true but was false.";
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("PASS: {}", message);
    }

    public static void assertNotNull(Object object, String message) {
        if (object == null) {
            String errorMessage = "FAIL: " + message + " - Object is null.";
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("PASS: {}", message);
    }

    public static void assertFalse(boolean condition, String message) {
        if (condition) {
            String errorMessage = "FAIL: " + message + " - Expected false but was true.";
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("PASS: {}", message);
    }

    public static void assertEquals(String actual, String expected, String message) {
        if (!actual.equals(expected)) {
            String errorMessage = String.format("FAIL: %s - Expected '%s', but got '%s'.", message, expected, actual);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("PASS: {}", message);
    }

    public static void assertEquals(Boolean actual, Boolean expected, String message) {
        if (!actual.equals(expected)) {
            String errorMessage = String.format("FAIL: %s - Expected '%s', but got '%s'.", message, expected, actual);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("PASS: {}", message);
    }

    public static void assertEquals(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            String errorMessage = String.format("FAIL: %s - Expected '%s', but got '%s'.", message, expected, actual);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("PASS: {}", message);
    }

    public static void assertEquals(double actual, double expected, String message) {
        if (Math.abs(actual - expected) > 0.00001) {
            String errorMessage = String.format("FAIL: %s - Expected '%s', but got '%s'.", message, expected, actual);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("PASS: {}", message);
    }

    public static void assertEquals(int actual, int expected, String message) {
        if (actual != expected) {
            String errorMessage = String.format("FAIL: %s - Expected '%d', but got '%d'.", message, expected, actual);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("PASS: {}", message);
    }

    public static void assertEquals(List<String> actual, List<String> expected, String message) {
        if (actual == null || expected == null) {
            String errorMessage = String.format("FAIL: %s - One of the lists is null. Actual: %s, Expected: %s.", message, actual, expected);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }

        if (!actual.equals(expected)) {
            String errorMessage = String.format("FAIL: %s - Expected '%s', but got '%s'.", message, expected, actual);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }

        logger.info("PASS: {}", message);
    }


    public static void assertNotEquals(String actual, String expected, String message) {
        if (actual.equals(expected)) {
            String errorMessage = String.format("FAIL: %s - Did not expect '%s'.", message, expected);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("PASS: {}", message);
    }

    public static void assertNotEquals(Boolean actual, Boolean expected, String message) {
        if (actual.equals(expected)) {
            String errorMessage = String.format("FAIL: %s - Did not expect '%s'.", message, expected);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("PASS: {}", message);
    }

    public static void assertNotEquals(Object actual, Object expected, String message) {
        if (actual.equals(expected)) {
            String errorMessage = String.format("FAIL: %s - Did not expect '%s'.", message, expected);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("PASS: {}", message);
    }

    public static void assertNotEquals(double actual, double expected, String message) {
        if (Math.abs(actual - expected) <= 0.00001) {
            String errorMessage = String.format("FAIL: %s - Did not expect '%s'.", message, expected);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("PASS: {}", message);
    }

    public static void assertNotEquals(int actual, int expected, String message) {
        if (actual == expected) {
            String errorMessage = String.format("FAIL: %s - Did not expect '%d'.", message, expected);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("PASS: {}", message);
    }

    public static void assertContains(String completeString, String subString, String message) {
        if (!completeString.contains(subString)) {
            String errorMessage = String.format("FAIL: %s - '%s' does not contain '%s'.", message, completeString, subString);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("PASS: {}", message);
    }

    public static void assertNotContains(String completeString, String subString, String message) {
        if (completeString.contains(subString)) {
            String errorMessage = String.format("FAIL: %s - '%s' contains '%s'.", message, completeString, subString);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("PASS: {}", message);
    }
}

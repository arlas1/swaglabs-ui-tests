package swaglabs.utils.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomAssert {
    private static final Logger logger = LoggerFactory.getLogger(CustomAssert.class);

    private CustomAssert() {

    }

    public static void assertTrue(boolean condition) {
        if (!condition) {
            String errorMessage = "Assertion failed: Condition is not true.";
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("Assertion passed: Condition is true.");
    }

    public static void assertNotNull(Object object) {
        if (object == null) {
            String errorMessage = "Assertion failed: Object is null.";
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("Assertion passed: Object is not null.");
    }

    public static void assertFalse(boolean condition) {
        if (condition) {
            String errorMessage = "Assertion failed: Condition is not false.";
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("Assertion passed: Condition is false.");
    }

    public static void assertEquals(String actual, String expected) {
        if (!actual.equals(expected)) {
            String errorMessage = String.format("Assertion failed: Actual value '%s' does not match expected value '%s'.", actual, expected);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("Assertion passed: Actual value '{}' matches expected value '{}'.", actual, expected);
    }

    public static void assertEquals(Boolean actual, Boolean expected) {
        if (!actual.equals(expected)) {
            String errorMessage = String.format("Assertion failed: Actual value '%s' does not match expected value '%s'.", actual, expected);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("Assertion passed: Actual value '{}' matches expected value '{}'.", actual, expected);
    }

    public static void assertEquals(Object actual, Object expected) {
        if (!actual.equals(expected)) {
            String errorMessage = String.format("Assertion failed: Actual object '%s' does not match expected object '%s'.", actual, expected);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("Assertion passed: Actual object '{}' matches expected object '{}'.", actual, expected);
    }

    public static void assertEquals(double actual, double expected) {
        if (Math.abs(actual - expected) > 0.00001) {
            String errorMessage = String.format("Assertion failed: Actual value '%s' does not match expected value '%s'.", actual, expected);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("Assertion passed: Actual value '{}' matches expected value '{}'.", actual, expected);
    }

    public static void assertEquals(int actual, int expected) {
        if (actual != expected) {
            String errorMessage = String.format("Assertion failed: Actual value '%d' does not match expected value '%d'.", actual, expected);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("Assertion passed: Actual value '{}' matches expected value '{}'.", actual, expected);
    }

    public static void assertNotEquals(String actual, String expected) {
        if (actual.equals(expected)) {
            String errorMessage = String.format("Assertion failed: Actual value '%s' matches expected value '%s'.", actual, expected);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("Assertion passed: Actual value '{}' does not match expected value '{}'.", actual, expected);
    }

    public static void assertNotEquals(Boolean actual, Boolean expected) {
        if (actual.equals(expected)) {
            String errorMessage = String.format("Assertion failed: Actual value '%s' matches expected value '%s'.", actual, expected);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("Assertion passed: Actual value '{}' does not match expected value '{}'.", actual, expected);
    }

    public static void assertNotEquals(Object actual, Object expected) {
        if (actual.equals(expected)) {
            String errorMessage = String.format("Assertion failed: Actual object '%s' matches expected object '%s'.", actual, expected);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("Assertion passed: Actual object '{}' does not match expected object '{}'.", actual, expected);
    }

    public static void assertNotEquals(double actual, double expected) {
        if (Math.abs(actual - expected) <= 0.00001) {
            String errorMessage = String.format("Assertion failed: Actual value '%s' matches expected value '%s'.", actual, expected);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("Assertion passed: Actual value '{}' does not match expected value '{}'.", actual, expected);
    }

    public static void assertNotEquals(int actual, int expected) {
        if (actual == expected) {
            String errorMessage = String.format("Assertion failed: Actual value '%d' matches expected value '%d'.", actual, expected);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("Assertion passed: Actual value '{}' does not match expected value '{}'.", actual, expected);
    }

    public static void assertContains(String completeString, String subString) {
        if (!completeString.contains(subString)) {
            String errorMessage = String.format("Assertion failed: Substring '%s' not found in Complete String '%s'.", subString, completeString);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("Assertion passed: Complete string contains substring '{}'.", subString);
    }

    public static void assertNotContains(String completeString, String subString) {
        if (completeString.contains(subString)) {
            String errorMessage = String.format("Assertion failed: Substring '%s' found in Complete String '%s'.", subString, completeString);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
        logger.info("Assertion passed: Complete string does not contain substring '{}'.", subString);
    }
}

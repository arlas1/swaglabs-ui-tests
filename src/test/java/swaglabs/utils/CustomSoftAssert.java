package swaglabs.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;

public class CustomSoftAssert {
    private static final Logger logger = LoggerFactory.getLogger(CustomSoftAssert.class);
    private final List<Throwable> m_errors;

    public CustomSoftAssert() {
        m_errors = new LinkedList<>();
    }

    public void assertTrue(boolean condition, String message) {
        try {
            Assert.assertTrue(condition, message + " - Expected true but was false.");
            logger.info("PASS: {}", message);
        } catch (Throwable e) {
            String errorMessage = "FAIL: " + message + " - Expected true but was false.";
            logger.error(errorMessage);
            m_errors.add(new AssertionError(errorMessage));
        }
    }

    public void assertContainsIgnoreCase(String completeString, String subString, String message) {
        try {
            Assert.assertTrue(
                    completeString.toLowerCase().contains(subString.toLowerCase()),
                    message + " - '" + completeString + "' does not contain '" + subString + "' (case-insensitive)."
            );
            logger.info("PASS: {}", message);
        } catch (Throwable e) {
            String errorMessage = "FAIL: " + message + " - '" + completeString + "' does not contain '" + subString + "' (case-insensitive).";
            logger.error(errorMessage);
            m_errors.add(new AssertionError(errorMessage));
        }
    }

    public void assertEquals(String actual, String expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message + " - Expected '" + expected + "', but got '" + actual + "'.");
            logger.info("PASS: {}", message);
        } catch (Throwable e) {
            String errorMessage = "FAIL: " + message + " - Expected '" + expected + "', but got '" + actual + "'.";
            logger.error(errorMessage);
            m_errors.add(new AssertionError(errorMessage));
        }
    }

    public void assertEqualsIgnoreCase(String actual, String expected, String message) {
        try {
            Assert.assertEquals(
                    actual.toLowerCase(),
                    expected.toLowerCase(),
                    message + " - Expected '" + expected + "', but got '" + actual + "' (case-insensitive)."
            );
            logger.info("PASS: {}", message);
        } catch (Throwable e) {
            String errorMessage = "FAIL: " + message + " - Expected '" + expected + "', but got '" + actual + "' (case-insensitive).";
            logger.error(errorMessage);
            m_errors.add(new AssertionError(errorMessage));
        }
    }

    public void assertEquals(double actual, double expected, String message) {
        try {
            Assert.assertEquals(actual, expected, 0.00001, message + " - Expected '" + expected + "', but got '" + actual + "'.");
            logger.info("PASS: {}", message);
        } catch (Throwable e) {
            String errorMessage = "FAIL: " + message + " - Expected '" + expected + "', but got '" + actual + "'.";
            logger.error(errorMessage);
            m_errors.add(new AssertionError(errorMessage));
        }
    }

    public void assertEquals(int actual, int expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message + " - Expected '" + expected + "', but got '" + actual + "'.");
            logger.info("PASS: {}", message);
        } catch (Throwable e) {
            String errorMessage = "FAIL: " + message + " - Expected '" + expected + "', but got '" + actual + "'.";
            logger.error(errorMessage);
            m_errors.add(new AssertionError(errorMessage));
        }
    }

    public void assertContains(String completeString, String subString, String message) {
        try {
            Assert.assertTrue(
                    completeString.contains(subString),
                    message + " - '" + completeString + "' does not contain '" + subString + "'."
            );
            logger.info("PASS: {}", message);
        } catch (Throwable e) {
            String errorMessage = "FAIL: " + message + " - '" + completeString + "' does not contain '" + subString + "'.";
            logger.error(errorMessage);
            m_errors.add(new AssertionError(errorMessage));
        }
    }

    public void assertEquals(Boolean actual, Boolean expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message + " - Expected '" + expected + "', but got '" + actual + "'.");
            logger.info("PASS: {}", message);
        } catch (Throwable e) {
            String errorMessage = "FAIL: " + message + " - Expected '" + expected + "', but got '" + actual + "'.";
            logger.error(errorMessage);
            m_errors.add(new AssertionError(errorMessage));
        }
    }

    public void assertNotNull(String actual, String message) {
        try {
            Assert.assertNotNull(actual, message + " - String should not be null.");
            logger.info("PASS: {}", message);
        } catch (Throwable e) {
            String errorMessage = "FAIL: " + message + " - String was null.";
            logger.error(errorMessage);
            m_errors.add(new AssertionError(errorMessage));
        }
    }

    public void assertAll() {
        if (!m_errors.isEmpty()) {
            StringBuilder customMessage = new StringBuilder();
            customMessage.append("Total assertion failures: ").append(m_errors.size()).append(System.lineSeparator());

            int count = 1;
            for (Throwable throwable : m_errors) {
                customMessage.append(String.format("Failure %d: %s%n", count++, throwable.getMessage()));
            }

            logger.error("Soft assertions completed with {} failure(s).", m_errors.size());
            throw new AssertionError(customMessage.toString());
        }

        logger.info("All soft assertions passed.");
    }
}

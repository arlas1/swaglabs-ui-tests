package swaglabs.utils;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
            Assert.assertTrue(message + " - Expected true but was false.", condition);
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
                    message + " - '" + completeString + "' does not contain '" + subString + "' (case-insensitive).",
                    completeString.toLowerCase().contains(subString.toLowerCase())
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
            Assert.assertEquals(message + " - Expected '" + expected + "', but got '" + actual + "'.", expected, actual);
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
                    message + " - Expected '" + expected + "', but got '" + actual + "' (case-insensitive).",
                    expected.toLowerCase(),
                    actual.toLowerCase()
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
            Assert.assertEquals(message + " - Expected '" + expected + "', but got '" + actual + "'.", expected, actual, 0.00001);
            logger.info("PASS: {}", message);
        } catch (Throwable e) {
            String errorMessage = "FAIL: " + message + " - Expected '" + expected + "', but got '" + actual + "'.";
            logger.error(errorMessage);
            m_errors.add(new AssertionError(errorMessage));
        }
    }

    public void assertEquals(int actual, int expected, String message) {
        try {
            Assert.assertEquals(message + " - Expected '" + expected + "', but got '" + actual + "'.", expected, actual);
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
                    message + " - '" + completeString + "' does not contain '" + subString + "'.",
                    completeString.contains(subString)
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
            Assert.assertEquals(message + " - Expected '" + expected + "', but got '" + actual + "'.", expected, actual);
            logger.info("PASS: {}", message);
        } catch (Throwable e) {
            String errorMessage = "FAIL: " + message + " - Expected '" + expected + "', but got '" + actual + "'.";
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

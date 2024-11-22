package swaglabs.utils.test;

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

    public void assertTrue(boolean condition) {
        try {
            Assert.assertTrue("Condition is not true.", condition);
            logger.info("Assertion passed: Condition evaluated to TRUE.");
        } catch (Throwable e) {
            logger.error("Assertion failed: Condition evaluated to FALSE.");
            m_errors.add(e);
        }
    }

    public void assertContainsIgnoreCase(String completeString, String subString) {
        try {
            Assert.assertTrue(
                    String.format("Substring '%s' not found in complete string '%s' (case-insensitive).", subString, completeString),
                    completeString.toLowerCase().contains(subString.toLowerCase())
            );
            logger.info("Assertion passed: Complete string contains substring '{}' (case-insensitive).", subString);
        } catch (Throwable e) {
            logger.error("Assertion failed: Substring '{}' not found in complete string '{}' (case-insensitive).", subString, completeString);
            m_errors.add(e);
        }
    }

    public void assertEquals(String actual, String expected) {
        try {
            Assert.assertEquals("String values are not equal.", actual, expected);
            logger.info("Assertion passed: Actual value '{}' matches Expected value '{}'.", actual, expected);
        } catch (Throwable e) {
            logger.error("Assertion failed: Actual value '{}' does not match Expected value '{}'.", actual, expected);
            m_errors.add(e);
        }
    }

    public void assertEqualsIgnoreCase(String actual, String expected) {
        try {
            Assert.assertEquals("String values are not equal (case-insensitive).", actual.toLowerCase(), expected.toLowerCase());
            logger.info("Assertion passed: Actual value '{}' matches Expected value '{}' (case-insensitive).", actual, expected);
        } catch (Throwable e) {
            logger.error("Assertion failed: Actual value '{}' does not match Expected value '{}' (case-insensitive).", actual, expected);
            m_errors.add(e);
        }
    }

    public void assertEquals(double actual, double expected) {
        try {
            Assert.assertEquals("Double values are not equal.", actual, expected, 0.00001);
            logger.info("Assertion passed: Actual value '{}' matches Expected value '{}'.", actual, expected);
        } catch (Throwable e) {
            logger.error("Assertion failed: Actual value '{}' does not match Expected value '{}'.", actual, expected);
            m_errors.add(e);
        }
    }

    public void assertEquals(int actual, int expected) {
        try {
            Assert.assertEquals("Integer values are not equal.", actual, expected);
            logger.info("Assertion passed: Actual value '{}' matches Expected value '{}'.", actual, expected);
        } catch (Throwable e) {
            logger.error("Assertion failed: Actual value '{}' does not match Expected value '{}'.", actual, expected);
            m_errors.add(e);
        }
    }

    public void assertContains(String completeString, String subString) {
        try {
            Assert.assertTrue(
                    String.format("Substring '%s' not found in complete string '%s'.", subString, completeString),
                    completeString.contains(subString)
            );
            logger.info("Assertion passed: Complete string contains substring '{}'.", subString);
        } catch (Throwable e) {
            logger.error("Assertion failed: Substring '{}' not found in complete string '{}'.", subString, completeString);
            m_errors.add(e);
        }
    }

    public void assertEquals(Boolean actual, Boolean expected) {
        try {
            Assert.assertEquals("Boolean values are not equal.", actual, expected);
            logger.info("Assertion passed: Actual value '{}' matches Expected value '{}'.", actual, expected);
        } catch (Throwable e) {
            logger.error("Assertion failed: Actual value '{}' does not match Expected value '{}'.", actual, expected);
            m_errors.add(e);
        }
    }

    public void assertAll() {
        if (!m_errors.isEmpty()) {
            StringBuilder customMessage = new StringBuilder();
            customMessage.append("Total Assertion Failures: ").append(m_errors.size()).append(System.lineSeparator());

            int count = 1;
            for (Throwable throwable : m_errors) {
                customMessage.append(String.format("Failure %d: %s%n", count++, throwable.getLocalizedMessage()));
            }

            logger.error("Soft assertions completed with {} failure(s).", m_errors.size());
            throw new AssertionError(customMessage.toString());
        }

        logger.info("All soft assertions passed successfully.");
    }
}

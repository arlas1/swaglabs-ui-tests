package listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);
    private String currentTestClass = "";

    @Override
    public void onTestStart(ITestResult result) {
        String testClassName = result.getTestClass().getRealClass().getSimpleName();
        if (!currentTestClass.equals(testClassName)) {
            currentTestClass = testClassName;
            logger.info("\n\n==================== STARTING TEST CLASS: {} ====================\n", currentTestClass);
        }

        logger.info("\n==================== STARTING TEST: {} ====================", result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("\n==================== TEST PASSED: {} ====================\n", result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        Throwable throwable = result.getThrowable();
        String errorMessage = throwable != null ? throwable.getMessage() : "Unknown error";

        logger.error("\n==================== TEST FAILED: {} ====================\n", testName);
        logger.error("Reason: {}\n", errorMessage);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("\n==================== TEST SKIPPED: {} ====================\n", result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("\n\n==================== STARTING TEST SUITE: {} ====================\n", context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("\n\n==================== FINISHING TEST SUITE: {} ====================\n", context.getName());
    }
}


package ExtentReport;

import Logger.Logger;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class TestListener   implements ITestListener {
    private static final String TEST_PASSED = "Test passed";
    private static final String STARTED = "started!";
    private static final String PASSED = "passed!";
    private static final String FAILED = "failed!";
    public static final String SKIPPED = "Skipped";
    public static final String TEST_SKIPPED = "Test Skipped";
    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public synchronized void onStart(ITestContext context) {
        Logger.info("Extent Reports Test Suite " + STARTED);
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        Logger.info(("Extent Reports Test Suite is ending!"));
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        Logger.info((result.getMethod().getMethodName() + STARTED));
        ExtentTest extentTest = extent.createTest(result.getMethod().getDescription(), result.getMethod().getDescription());
        test.set(extentTest);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        Logger.info((result.getMethod().getDescription() + PASSED));
        test.get().pass(TEST_PASSED);
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        Logger.info((result.getMethod().getDescription() + FAILED));
        test.get().fail(result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logger.info((result.getMethod().getMethodName() + SKIPPED));
        test.get().skip(TEST_SKIPPED);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Logger.info("onTestFailedButWithinSuccessPercentage for" + result.getMethod().getMethodName());
    }
}
package Automation.org.Shubham.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

    private int defaultRetryCount = 0;
    private static final int maxRetryCount = 3;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (defaultRetryCount < maxRetryCount) {
            defaultRetryCount++;
            return true;
        }
        return false;
    }
}

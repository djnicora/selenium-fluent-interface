package niko.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import niko.BaseTestClass;




public class Listener extends BaseTestClass implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    	logger.info("I am in onStart method " + iTestContext.getName());
      
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    	logger.info("I am in onFinish method " + iTestContext.getName());
       
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
    	logger.info("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
       
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    	logger.info("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
       
        
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
    	logger.info("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");

      
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    	logger.info("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
      
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    	logger.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

}

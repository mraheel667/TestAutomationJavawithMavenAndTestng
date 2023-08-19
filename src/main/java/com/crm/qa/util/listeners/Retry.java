package com.crm.qa.util.listeners;

import com.crm.qa.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import static com.crm.qa.util.extentreports.ExtentTestManager.getTest;

public class Retry implements IRetryAnalyzer {

    private int count = 0;
    private static int maxTry = 1; //Run the failed test 2 times

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {                     //Check if test not succeed
            if (count < maxTry) {                           //Check if maxTry count is reached
                count++;                                    //Increase the maxTry count by 1
                iTestResult.setStatus(ITestResult.FAILURE); //Mark test as failed and take base64Screenshot
                extendReportsFailOperations(iTestResult);   //ExtentReports fail operations
                return true;                                //Tells TestNG to re-run the test
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);     //If test passes, TestNG marks it as passed
        }
        return false;
    }

    public void extendReportsFailOperations(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((TestBase) testClass).getDriver();
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
        getTest().log(LogStatus.FAIL, "Test Failed",
                getTest().addBase64ScreenShot(base64Screenshot));
    }
}

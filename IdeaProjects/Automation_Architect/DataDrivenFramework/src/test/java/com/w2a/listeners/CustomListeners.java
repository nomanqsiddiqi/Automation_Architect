package com.w2a.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener {
    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {

        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log("Capturing screenshot");
        Reporter.log("Login successfully executed");
        Reporter.log("<a target=\"blank\" href=\"C:\\Screenshot.jpg\">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href=\"C:\\Screenshot.jpg\"><img src=\"C:\\Screenshot.jpg\" height=200 width=200" +
                "" +
                "" +
                "></img></a>");
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}

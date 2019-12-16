package com.presta.common;

import com.sqs.core.common.Config;
import com.sqs.core.common.logging.Logger;
import com.sqs.core.common.logging.LoggerProvider;
import com.sqs.core.common.reporting.Reporter;
import com.sqs.core.common.reporting.ReporterProvider;
import com.sqs.web.utils.Screenshot;
import com.sqs.web.webdriver.Driver;
import com.sqs.web.webdriver.DriverProvider;
import com.sqs.web.webdriver.driverstrategies.Chrome;
import io.qameta.allure.Attachment;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import sun.jvm.hotspot.ui.classbrowser.ClassBrowserPanel;

import java.io.File;

public class TestListener implements ITestListener {
  private static final Logger logger = LoggerProvider.getLogger("TestListener");
  private static Reporter reporter = ReporterProvider.getReporter("extent");

  @Override
  public synchronized void onStart(ITestContext context) {
  }

  @Override
  public synchronized void onFinish(ITestContext context) {
  }

  @Override
  public synchronized void onTestStart(ITestResult result) {
    try {
      reporter.startTest(result.getMethod().getMethodName());
    } catch (InstantiationException e) {
      e.printStackTrace();
    }
    logger.info("In TestListener.onTestStart");

    //Setup the folders for recording the baseline and snapshots to
  }

  @Override
  public synchronized void onTestSuccess(ITestResult result) {
    logger.info("In TestListener.onTestSuccess");
    DriverProvider.end();
    reporter.pass("Test passed");
    reporter.endTest();
  }

  @Override
  public synchronized void onTestFailure(ITestResult result) {
    logger.info("In TestListener.onTestFailure");
    reporter.attachScreenshot(Screenshot.takeScreenshot(result.getMethod().getMethodName(), DriverProvider.getDriverImpl()).toString());
    getAllureScreenshot();
    //DriverProvider.end();
    reporter.fail("Test failed: " + result.getThrowable());
    reporter.endTest();
  }

  @Override
  public synchronized void onTestSkipped(ITestResult result) {
    logger.info("In TestListener.onTestSkipped");
    DriverProvider.end();
    reporter.skip("Skipping test: " + result.getThrowable());
    reporter.endTest();
  }

  @Override
  public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
  }

  @Attachment
  private byte[] getAllureScreenshot() {
    return Screenshot.getScreenshot(DriverProvider.getDriverImpl());
  }

  public Object[][] getPlatformsAndBrowsers() {
    Object[][] platformsAndBrowsers = new Object[][] {
        {Platform.WIN8, "firefox"},
        {Platform.WIN8, "chrome"},
        {Platform.MAC, "safari"}
    };
    return platformsAndBrowsers;
  }
}

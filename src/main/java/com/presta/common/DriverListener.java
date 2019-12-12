/*
 * Copyright (c) SQS Limited 2017.
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.presta.common;

import com.sqs.core.common.logging.Logger;
import com.sqs.core.common.logging.LoggerProvider;
import com.sqs.web.webdriver.DriverProvider;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * WebDriverListener class to allow setting of browser and platform on a thread. Without the
 * listener here the browser gets set at the wrong part of the TestNG lifecycle and therefore cannot
 * run. This listener ensures it is set at the correct point in the lifecycle to be associated with
 * the correct thread.
 */
public class DriverListener implements IInvokedMethodListener {

  Logger logger = LoggerProvider.getLogger("DriverListener");

  /**
   * {@inheritDoc}.
   */
  @Override
  public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
    if (method.isTestMethod()) {
      logger.info("Setting browser");
      String browserName = method.getTestMethod().getXmlTest().getAllParameters().get("browser");
      DriverProvider.setBrowser(browserName);
      logger.info("Starting browser");
      DriverProvider.initialize();
    }
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    if (method.isTestMethod()) {
      logger.info("Stopping browser");
      DriverProvider.end();
    }
  }
}

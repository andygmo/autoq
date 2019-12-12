package com.presta.pageobjects;

import com.presta.pageobjects.basepages.PrestaBasePage;
import com.sqs.core.common.Config;
import com.sqs.web.elements.Hyperlink;
import com.sqs.web.webdriver.DriverProvider;
import org.openqa.selenium.By;

/**
 * The Presta home page.
 */
public class PrestaHome extends PrestaBasePage<PrestaHome> {

  private final Hyperlink prestaLogo = new Hyperlink(By.xpath("//*[@id='_desktop_logo']/a/img"));

  /**
   * Instantiates a new Presta home.
   */
  public PrestaHome() {
    DriverProvider.getDriver().get(Config.getGlobalProperty("url"));

  }

}

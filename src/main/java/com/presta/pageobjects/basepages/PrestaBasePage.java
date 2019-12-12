package com.presta.pageobjects.basepages;

import com.presta.components.PrestaFilters;
import com.presta.components.PrestaFooter;
import com.presta.components.PrestaHeader;
import com.presta.components.PrestaWomen;
import com.presta.utility.Screenshot;
import com.sqs.core.common.Config;
import com.sqs.web.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * Will be used as a base page to page objects allowing extension of head and footer elements to
 * page objects.
 */
public abstract class PrestaBasePage<TOriginPage> extends PageObjectBase<TOriginPage> {

  public final Label errorMessage = new Label(By.xpath("//div[@class='help-block']//li"));
  public PrestaHeader<TOriginPage> PrestaHeader = new PrestaHeader<>(this);
  public PrestaFooter<TOriginPage> PrestaFooter = new PrestaFooter<>(this);
  public PrestaWomen<TOriginPage> PrestaWomen = new PrestaWomen<>(this);
  public PrestaFilters<TOriginPage> PrestaFilters = new PrestaFilters<>(this);


  /**
   * Get the current page title
   *
   * @param value the page name value
   * @return the page title label
   */
  @Step("The correct page title is displayed")
  public Label getPageTitleElement(String value) {
    return new Label(By.xpath("//*[@class='block-category card card-block hidden-sm-down']//h1[contains(text(),'" + value + "')]"));
  }


}

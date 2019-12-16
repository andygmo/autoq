package com.presta.pageobjects.basepages;


import com.presta.components.PrestaFilters;
import com.presta.components.PrestaFooter;
import com.presta.components.PrestaHeader;
import com.presta.components.PrestaWomen;
import com.sqs.web.elements.Label;
import com.sqs.web.elements.TextArea;
import com.sqs.web.elements.TextInput;
import com.sqs.web.webdriver.DriverProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
  public TextArea waved = new TextArea(By.name("s"));
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


  public void getAccessibilityScore(){
    WebDriver driver = DriverProvider.getDriver();
    Actions a = new Actions(driver);
    WebElement wave = driver.findElement(By.name("s"));

    a.sendKeys(wave,Keys.chord (Keys.COMMAND, "u")).perform();
  }
}

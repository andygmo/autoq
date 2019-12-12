package com.presta.pageobjects;

import com.presta.components.Breadcrumb;
import com.presta.customElements.PrestaDropdown;
import com.presta.enums.Colour;
import com.presta.enums.Dropdowns;
import com.presta.enums.Size;
import com.presta.pageobjects.basepages.PrestaBasePage;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.Hyperlink;
import com.sqs.web.elements.TextInput;
import com.sqs.web.webdriver.DriverProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by BreslinS on 24/01/2018.
 */
public class PrestaProductPage extends PrestaBasePage<PrestaProductPage> {

  public final com.presta.components.Breadcrumb Breadcrumb = new Breadcrumb<>(this);
  public final TextInput enterQuantityRequired = new TextInput(By.xpath("//*[@id=\"quantity_wanted\"]"));
  private final PrestaDropdown sizeDropdown = new PrestaDropdown(Dropdowns.SIZE);
  private final Button addToCart = new Button(By.xpath("//*[@class='btn btn-primary add-to-cart']"));
  private final Hyperlink proceedToCheckout = new Hyperlink(By.xpath("//*[contains (text(), 'proceed to checkout')]"));
  private final Button continueShopping = new Button(By.xpath("//button[contains(text(),'Continue shopping')]"));

  /**
   * Select a Size dropdown value
   *
   * @param sizeOption the sizeOption string value
   * @return the Presta Product Page page object
   */
  @Step("The 'Size' dropdown option is selected")
  public PrestaProductPage selectSizeOption(Size sizeOption) {
    sizeDropdown.selectOptionBySize(sizeOption);
    return this;
  }


  @Step("Select colour from list")
  public PrestaProductPage selectColorOption(Colour colour) {
    WebElement colorSelected = DriverProvider.getDriver().findElement(By.xpath("//input[@value='" + colour.menuOption + "']"));
    colorSelected.click();
    return navigatingTo(PrestaProductPage.class);
  }


  /**
   * Add multiple products to the shopp ing cart
   *
   * @return the Presta Product Page page object
   */
  @Step("Increase number of products to add to cart ")
  public PrestaProductPage selectQuantityRequired(String value) {
    enterQuantityRequired.clear();
    enterQuantityRequired.clearText();
    enterQuantityRequired.clear();
    enterQuantityRequired.setText(value);
    return navigatingTo(PrestaProductPage.class);
  }


  /**
   * Add product to the shopping cart
   *
   * @return the Presta Product Page page object
   */
  @Step("The selected product is added to cart")
  public PrestaProductPage addProductToCart() {
    addToCart.click();
    return this;
  }


  /**
   * Proceed to checkout
   *
   * @return the Presta Shopping Cart Page page object
   */
  @Step("The user proceeds to checkout")
  public PrestaShoppingCart userProceedToCheckout() {
    proceedToCheckout.click();
    return navigatingTo(PrestaShoppingCart.class);
  }


  /**
   * Proceed to continue shopping
   *
   * @return the Presta Shopping Cart Page page object
   */
  @Step("The user continues shopping")
  public PrestaProductPage userContinueShopping() {
    continueShopping.click();
    return navigatingTo(PrestaProductPage.class);
  }
}
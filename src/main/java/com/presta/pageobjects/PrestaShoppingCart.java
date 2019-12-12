package com.presta.pageobjects;

import com.presta.enums.Product;
import com.presta.pageobjects.basepages.PrestaBasePage;
import com.sqs.web.elements.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * Created by BreslinS on 24/01/2018.
 */
public class PrestaShoppingCart extends PrestaBasePage<PrestaShoppingCart> {

  public final Label shippingCost = new Label(By.xpath("//*[@id='cart-subtotal-shipping']//*[@class='value']"));
  public final Label zeroItemsDisplayed = new Label(By.xpath("//*[@id='cart-subtotal-products']/span[1]"));
  public final Label noItemsInCartMessage = new Label(By.xpath("//span[@class='no-items']"));
  public final Label colorDisplayed = new Label(By.xpath("//span[.='Color:']/following-sibling::span "));
  private final Hyperlink checkoutLink = new Hyperlink(By.xpath("//a[@class='btn btn-primary']"));

  /**
   * Click on the Checkout button
   */
  @Step("Click Checkout link")
  public PrestaSaleCompletionPage checkoutProducts() {
    checkoutLink.click();
    return navigatingTo(PrestaSaleCompletionPage.class);
  }

  @Step("Change the quantity of product using text Input  ")
  public PrestaShoppingCart changeProductQuantity(Product productName, String newQuantity) {
    TextInput quantity = new TextInput(By.xpath("//a[.='" + productName.menuOption + "']//following::input[1]"));
    quantity.clearText();
    quantity.setText(newQuantity);
    PrestaHeader.clickCartButton();
    return this;
  }

  @Step("Check product price ")
  public String getProductPrice(Product productName) {
    return new Label(By.xpath("//a[.='" + productName.menuOption + "']//following::span[1]")).getText();
  }

  @Step("Check product size ")
  public String getProductSize(Product productName) {
    return new Label(By.xpath("//a[.='" + productName.menuOption + "']//following::span[3]")).getText();
  }

  @Step("Check product colour ")
  public String getProductColour(Product productName) {
    return new Label(By.xpath("//a[.='" + productName.menuOption + "']//following::span[5]")).getText();
  }

  @Step("Check the quantity is correct ")
  public String getProductQuantity(Product productName) {
    return new TextArea(By.xpath("//a[.='" + productName.menuOption + "']//following::input")).getText();
  }

  @Step("Check total price of same product ")
  public String getProductTotalPrice(Product productName) {
    return new Label(By.xpath("//a[.='" + productName.menuOption + "']//following::span[9]")).getText();
  }

  @Step("Increase Number of certain product in cart")
  public PrestaShoppingCart increaseProductQuantity(Product productName) {
    new Button(By.xpath("//a[.='" + productName.menuOption + "']//following::i[1]")).click();
    PrestaHeader.clickCartButton();
    return this;
  }

  @Step("Decrease Number of certain product in cart")
  public PrestaShoppingCart decreaseProductQuantity(Product productName) {
    new Button(By.xpath("//a[.='" + productName.menuOption + "']//following::i[2]")).click();
    PrestaHeader.clickCartButton();
    return this;
  }

  @Step("Items removed from cart displayed")
  public PrestaShoppingCart removeProductFromCart(Product productName) {
    new Button(By.xpath("//a[.='" + productName.menuOption + "']//following::a[1]")).click();
    return navigatingTo(PrestaShoppingCart.class);
  }

  @Step("Get the number of items in cart")
  public Label noItemsInYourCart() {
    return new Label(By.xpath("//*[contains(@class, 'no-items')]"));
  }
}

package com.presta.pageobjects;

import com.presta.pageobjects.basepages.PrestaBasePage;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.CheckBox;
import com.sqs.web.elements.Hyperlink;
import com.sqs.web.elements.TextInput;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * Created by BreslinS on 25/01/2018.
 */
public class PrestaSaleCompletionPage extends PrestaBasePage<PrestaSaleCompletionPage> {

  private final TextInput emailInput = new TextInput(By.xpath("//*[@id='login-form']//*[@name='email']"));
  private final TextInput passwordInput = new TextInput(By.xpath("//*[@id='login-form']//*[@name='password']"));
  private final Button continueButton = new Button(By.xpath("//*[@id='login-form']//*[@name='continue']"));
  private final Hyperlink signIn = new Hyperlink(By.xpath("//a[contains(text(),'Sign in')]"));
  private final Button continueAddresses = new Button(By.xpath("//*[@name='confirm-addresses']"));
  private final Button continueShipping = new Button(By.xpath("//*[@id='js-delivery']//button[contains(text(),'Continue')]"));
  private final Button payByCheck = new Button(By.xpath("//label[@for='payment-option-1']"));
  private final CheckBox termsOfService = new CheckBox(By.xpath("//label[@for='conditions_to_approve[terms-and-conditions]']"));
  private final Button orderWithObligation = new Button(By.xpath("//div[@id='payment-confirmation']//button"));

  /**
   * Sign into an existing user account and complete purchase
   *
   * @param email    the user account email
   * @param password the user account password
   * @return the PrestaSaleCompletionPage page object
   */
  @Step("Existing user signs in and completes purchase")
  public PrestaOrderConfirmedPage existingUserSignInAndCompletePurchase(String email, String password) {
    signIn.click();
    existingUserSignIn(email, password);
    continueAddresses.click();
    continueShipping.click();
    payByCheck.click();
    termsOfService.click();
    orderWithObligation.click();
    return navigatingTo(PrestaOrderConfirmedPage.class);

  }

  /**
   * Enter existing user account details
   *
   * @param email    the user account email
   * @param password the user account password
   * @return the PrestaSaleCompletionPage page object
   */
  @Step("Existing user signs in")
  public PrestaSaleCompletionPage existingUserSignIn(String email, String password) {
    // Enter user sign in details
    emailInput.setText(email);
    passwordInput.setText(password);
    continueButton.click();
    return this;
  }

}

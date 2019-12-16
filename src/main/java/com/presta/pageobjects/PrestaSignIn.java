package com.presta.pageobjects;

import com.presta.pageobjects.basepages.PrestaBasePage;
import com.sqs.core.common.Config;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.Hyperlink;
import com.sqs.web.elements.Label;
import com.sqs.web.elements.TextInput;
import com.sqs.web.utils.ResponsiveUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * The Presta sign in page.
 */
public class PrestaSignIn extends PrestaBasePage<PrestaSignIn> {


  /**
   * The Error message.
   */
  public final Label errorMessage = new Label(By.xpath("//li[.='Authentication failed.']"));
  /**
   * The Email box.
   */
  public final TextInput emailBox =
      new TextInput(By.xpath("//*[@id='login-form']//*[@name='email']"));
  /**
   * The Password box.
   */
  public final TextInput passwordBox = new TextInput(By.name("password"));
  private final Hyperlink createAccountLink = new Hyperlink(By.xpath("//a[normalize-space()='No account? Create one here']"));
  private final Button signInButton = new Button(By.xpath("//*[@id='login-form']/footer/button"));


  public PrestaSignIn(){
    if (Boolean.parseBoolean(Config.getGlobalProperty("setBaseline")) == true) {
      ResponsiveUtils ru = new ResponsiveUtils();
      String device = Config.getGlobalProperty("device");
      ru.takeScreenShot(Config.getGlobalProperty("baseLineDir"), "SignInbase_" + device, true, true);
    }
  }
  /**
   * Input sign in details.
   *
   * @param email    the email
   * @param password the password
   * @return the presta sign in page
   */
  @Step("Inputting username and password")
  public PrestaSignIn inputSignInDetails(String email, String password) {
    emailBox.clearText();
    passwordBox.clearText();
    emailBox.setText(email);
    passwordBox.setText(password);
    return this;
  }

  /**
   * Click sign in button.
   *
   * @return the presta sign in page
   */
  @Step("Clicking sign in button")
  public PrestaSignIn clickSignInButton() {
    signInButton.click();
    return this;
  }

  /**
   * Navigate to the create new account page
   *
   * @return the create new account page
   */
  @Step("Navigating to the create new account page")
  public PrestaCreateNewAccountPage navigateToCreateNewAccount() {
    createAccountLink.click();
    return navigatingTo(PrestaCreateNewAccountPage.class);
  }

  /**
   * Sign in to presta.
   *
   * @param email    the email
   * @param password the password
   * @return the presta sign in page
   */
  @Step("Signing in with username and password")
  public PrestaSignIn signInto(String email, String password) {
    inputSignInDetails(email, password);
    clickSignInButton();
    return this;
  }


}

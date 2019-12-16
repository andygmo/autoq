package com.presta.pageobjects;

import com.presta.pageobjects.basepages.PrestaBasePage;
import com.sqs.core.common.Config;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.TextInput;
import com.sqs.web.utils.ResponsiveUtils;
import io.qameta.allure.Step;
import jdk.nashorn.internal.objects.annotations.Property;
import org.openqa.selenium.By;

public class PrestaCreateNewAccountPage extends PrestaBasePage<PrestaCreateNewAccountPage> {

  public final TextInput firstName = new TextInput(By.xpath("//input[@name='firstname']"));
  public final TextInput lastName = new TextInput(By.xpath("//input[@name='lastname']"));
  public final TextInput email = new TextInput(By.xpath("//form[@id='customer-form']//input[@name='email']"));
  public final TextInput password = new TextInput(By.xpath("//input[@name='password']"));
  public final TextInput dob = new TextInput(By.xpath("//input[@name='birthday']"));
  private final Button saveButton = new Button(By.xpath("//Button[normalize-space()='Save']"));

  public PrestaCreateNewAccountPage(){
    String device = Config.getGlobalProperty("device");
    if (Boolean.parseBoolean(Config.getGlobalProperty("setBaseline"))){
      ResponsiveUtils ru = new ResponsiveUtils();
      ru.takeScreenShot(Config.getGlobalProperty("baseLineDir"), "CreateNewAccountPage_base_" + device, true, true);
    }
  }


  /**
   * Create New Account with invalid details
   *
   * @param firstName
   * @param lastName
   * @param email
   * @param password
   * @param dob
   * @return the PrestaCreateNewAccountPage
   */
  @Step("Create new account with invalid details")
  public PrestaCreateNewAccountPage createAccountInvalid(String firstName, String lastName, String email, String password, String dob) {
    this.firstName.setText(firstName);
    this.lastName.setText(lastName);
    this.email.setText(email);
    this.password.setText(password);
    this.dob.setText(dob);
    saveButton.click();
    return this;
  }


}

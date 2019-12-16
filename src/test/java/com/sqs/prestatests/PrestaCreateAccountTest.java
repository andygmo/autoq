package com.sqs.prestatests;

import com.presta.enums.ErrorMessages;
import com.presta.pageobjects.PrestaCreateNewAccountPage;
import com.presta.pageobjects.PrestaHome;
import com.sqs.prestatests.base.PrestaBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;

public class PrestaCreateAccountTest extends PrestaBaseTest {


  /**
   * Create Account Page Validation Attribute Message Tests
   */

  @Feature("Negative testing on the Create Customer Account form.")

  /**
   * Leave the FirstName field black in the create customer account form. Using getAttribute required field should be true
   */
  @TmsLink("3633")
  @Test(description = "Leave the FirstName field black in the create customer account form. Using getAttribute required field should be true")
  @Description("Leave the FirstName field black in the create customer account form. Using getAttribute required field should be true")
  public void createAccountNegativeFirstNameTest() {
    waitFor(PrestaHome.class)
        .PrestaHeader.navigateToPrestaSignIn()
        .navigateToCreateNewAccount()
        .createAccountInvalid("", "mike", "abc@sqs.com", "abc123", "05/31/1970")
        .assertThatElement("FirstName field checking getAttribute 'required' field should return true", new PrestaCreateNewAccountPage().firstName.getAttribute("required"), is("true"));
  }

  /**
   * Leave the LastName field black in the create customer account form. Using getAttribute required field should be true
   */
  @TmsLink("3633")
  @Test(description = "Leave the FirstName field black in the create customer account form. Using getAttribute required field should be true")
  @Description("Leave the FirstName field black in the create customer account form. Using getAttribute required field should be true")
  public void createAccountNegativeLastNameTest() {
    waitFor(PrestaHome.class)
        .PrestaHeader.navigateToPrestaSignIn()
        .navigateToCreateNewAccount()
        .createAccountInvalid("abc", "", "abc@sqs.com", "abc123", "05/31/1970")
        .assertThatElement("LastName field checking getAttribute 'required' field should return true", new PrestaCreateNewAccountPage().lastName.getAttribute("required"), is("true"));
  }

  /**
   * Multiple tests on the email field on create customer account form. First value entered is the email, followed by the error message expected.
   */
  @TmsLink("3573")
  @Test(dataProvider = "emailValidation", description = "Multiple tests on the email field on create customer account form. Using getAttribute error message displayed should matched the value entered into the data provider")
  @Description(" Multiple tests on the email field on create customer account form. Using getAttribute error message displayed should matched the value entered into the data provider")
  public void createAccountNegativeEmailTest(String email, String validationErrorMessage) {
    waitFor(PrestaHome.class)
        .PrestaHeader.navigateToPrestaSignIn()
        .navigateToCreateNewAccount()
        .createAccountInvalid("test", "user", email, "password", "05/31/1970")
        .assertThatElement("Email field checking getAttribute 'errorMessages' matches the email error entered.", new PrestaCreateNewAccountPage().email.getAttribute("validationMessage"), is(validationErrorMessage));
  }

  @DataProvider(name = "emailValidation")
  public Object[][] emailValidation() {
    return new Object[][] {
        {"ab@", "Please enter a part following '@'. 'ab@' is incomplete."},
        {"ab", "Please include an '@' in the email address. 'ab' is missing an '@'."},
        {".,.@.", ErrorMessages.COMMAEMAILERROR.menuOption},
        {"\"\"@abc.com", ErrorMessages.EMAILQUOTATIONMARK.menuOption},
        {"ii@.", "'.' is used at a wrong position in '.'."}
    };
  }

  /**
   * Leave the email field black in the create customer account form. Using getAttribute required field should be true
   */
  @TmsLink("3573")
  @Test(description = "Leave the email field black in the create customer account form. Using getAttribute required field should be true")
  @Description(" Leave the email field black in the create customer account form. Using getAttribute required field should be true")
  public void createAccountNegativeEmailBlankTest() {
    waitFor(PrestaHome.class)
        .PrestaHeader.navigateToPrestaSignIn()
        .navigateToCreateNewAccount()
        .createAccountInvalid("test", "user", "", "password", "05/31/1970")
        .assertThatElement("Email field checking getAttribute 'required' field should return true", new PrestaCreateNewAccountPage().email.getAttribute("required"), is("true"));
  }

  /**
   * Leave the password field black in the create customer account form. Using getAttribute required field should be true
   */
  @TmsLink("3633")
  @Test(description = "Leave the password field black in the create customer account form. Using getAttribute required field should be true")
  @Description("Leave the password field black in the create customer account form. Using getAttribute required field should be true")
  public void createAccountNegativePasswordTest() {
    waitFor(PrestaHome.class)
        .PrestaHeader.navigateToPrestaSignIn()
        .navigateToCreateNewAccount()
        .createAccountInvalid("abc", "abc", "abc@sqs.com", "a", "05/31/1970")
        .assertThatElement("Password field checking getAttribute 'required' field should return true", new PrestaCreateNewAccountPage().password.getAttribute("required"), is("true"));
  }

  /**
   * Leave the DOB field black in the create customer account form. Using getAttribute error message, no error message should be displayed.
   */
  @TmsLink("3633")
  @Test(description = "Leave the DOB field black in the create customer account form. Using getAttribute should match ErrorMessages.NOERROR.")
  @Description("Leave the DOB field black in the create customer account form. Using getAttribute should match ErrorMessages.NOERROR, No error message should be returned as field is not required.")
  public void createAccountNegativeDOBTest() {
    waitFor(PrestaHome.class)
        .PrestaHeader.navigateToPrestaSignIn()
        .navigateToCreateNewAccount()
        .createAccountInvalid("abc", "abc", "abcd@sqs.com", "abc123", "")
        .assertThatElement("DOB field no error message appears as it is not a required field. Should match ErrorMessages.NOERROR", new PrestaCreateNewAccountPage().dob.getAttribute("validationMessage"), is(ErrorMessages.NOERROR.menuOption));
  }

  /**
   * Tests check if message is returned on the screen after the submit button has been clicked.
   * Using an existing email in the create customer account form. Server side Error message should appear saying the email already exists.
   */
  @TmsLink("3860")
  @Test(description = "Using an existing email in the create customer account form. Server side Error message should appear saying the email already exists.")
  @Description("Using an existing email in the create customer account form. Server side Error message should appear saying the email already exists.")
  public void emailErrorTest() {
    String email = "abc@hotmail.co.uk";

    waitFor(PrestaHome.class)
        .PrestaHeader.navigateToPrestaSignIn()
        .navigateToCreateNewAccount()
        .createAccountInvalid("abc", "abc", email, "abc123", "1994-06-25")
        .assertThatElement("Email error displayed should verify that abc@hotmail.co.uk already has an account registered.", new PrestaCreateNewAccountPage().errorMessage.getText(), is("The email is already used, please choose another one or sign in"));
  }

  /**
   * Entering the value '4' into the DOB field in the create customer account form. Server side Error message should appear with ErrorMessages.DATEFORMAT
   */

  @TmsLink("3860")
  @Test(description = "Entering the value '4' into the DOB field in the create customer account form. Server side Error message should appear with ErrorMessages.DATEFORMAT")
  @Description("Entering the value '4' into the DOB field in the create customer account form. Server side Error message should appear with ErrorMessages.DATEFORMAT")
  public void dobErrorTest() {
    waitFor(PrestaHome.class)
        .PrestaHeader.navigateToPrestaSignIn()
        .navigateToCreateNewAccount()
        .createAccountInvalid("abc", "abc", "abc2@sqs.com", "abc123", "4")
        .assertThatElement("DOB error displayed matches ErrorMessages.DATAFORMAT", new PrestaCreateNewAccountPage().errorMessage.getText(), is(ErrorMessages.DATEFORMAT.menuOption));
  }

  /**
   * Entering the value '@' into the FirstName field in the create customer account form. Server side Error message should appear with ErrorMessages.INVALIDNAME
   */

  @TmsLink("3860")
  @Test(description = "Entering the value '@' into the FirstName field in the create customer account form. Server side Error message should appear with ErrorMessages.INVALIDNAMET")
  @Description("Entering the value '@' into the FirstName field in the create customer account form. Server side Error message should appear with ErrorMessages.INVALIDNAME")
  public void firstNameErrorTest() {
    String firstName = "@";

    waitFor(PrestaHome.class)
        .PrestaHeader.navigateToPrestaSignIn()
        .navigateToCreateNewAccount()
        .createAccountInvalid(firstName, "abc", "qwerty@sqs.com", "abc123", "25/06/1994")
        .assertThatElement("Email error displayed matches ErrorMessages.INVALIDNAME", new PrestaCreateNewAccountPage().errorMessage.getText(), is(ErrorMessages.INVALIDNAME.menuOption));
  }

  /**
   * Entering the value ' "" ' into the LastName field in the create customer account form. Server side Error message should appear with ErrorMessages.INVALIDNAME
   */

  @TmsLink("3860")
  @Test(description = "Entering the value \"\" into the LastName field in the create customer account form. Server side Error message should appear with ErrorMessages.INVALIDNAME")
  @Description("Entering the value \"\" into the LastName field in the create customer account form. Server side Error message should appear with ErrorMessages.INVALIDNAME")
  public void lastNameErrorTest() {
    String lastName = "\"\"";

    waitFor(PrestaHome.class)
        .PrestaHeader.navigateToPrestaSignIn()
        .navigateToCreateNewAccount()
        .createAccountInvalid(lastName, "abc", "qwerty@sqs.com", "abc123", "25/06/1994")
        .assertThatElement("Email error displayed matches ErrorMessages.INVALIDNAME", new PrestaCreateNewAccountPage().errorMessage.getText(), is(ErrorMessages.INVALIDNAME.menuOption));
  }

}
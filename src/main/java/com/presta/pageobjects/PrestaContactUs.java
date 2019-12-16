package com.presta.pageobjects;

import com.presta.pageobjects.basepages.PrestaBasePage;
import com.sqs.core.common.Config;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.Select;
import com.sqs.web.elements.TextArea;
import com.sqs.web.elements.TextInput;
import com.sqs.web.utils.ResponsiveUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * The Presta contact us page.
 */
public class PrestaContactUs extends PrestaBasePage<PrestaContactUs> {

  private final Select subjectDropDown = new Select(By.xpath("//*[@name='id_contact']"));
  private final TextInput emailAddress = new TextInput(By.xpath("//*[@name='from']"));
  private final TextArea message = new TextArea(By.xpath("//*[@name='message']"));
  private final Button send = new Button(By.xpath("//*[@name='submitMessage']"));

  public PrestaContactUs(){
    String device = Config.getGlobalProperty("device");
    if (Boolean.parseBoolean(Config.getGlobalProperty("setBaseline"))){
      ResponsiveUtils ru = new ResponsiveUtils();
      ru.takeScreenShot(Config.getGlobalProperty("baseLineDir"), "ContactUsbase_" + device, true, true);
    }
  }
  /**
   * Fill in contact us form.
   *
   * @param subject       the subject
   * @param email         the email
   * @param messageToSend the message to send
   * @return the presta contact us page
   */
  @Step("filling in the contact form with subject")
  public PrestaContactUs fillInContactForm(String subject, String email, String messageToSend) {
    subjectDropDown.selectByText(subject);
    emailAddress.setText(email);
    message.setText(messageToSend);
    return this;
  }

  /**
   * Send contact us form.
   *
   * @return the presta contact us page
   */
  @Step("Click the contact button")
  public PrestaContactUs sendContactForm() {
    send.click();
    return this;
  }

  /**
   * Fill in and send contact us form.
   *
   * @param subject       the subject
   * @param email         the email
   * @param messageToSend the message to send
   * @return the presta contact us page
   */
  @Step("Sending form with subject")
  public PrestaContactUs fillInAndSendContactForm(
      String subject, String email, String messageToSend) {
    fillInContactForm(subject, email, messageToSend);
    return sendContactForm();
  }
}

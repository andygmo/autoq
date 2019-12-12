package com.presta.components;

import com.presta.pageobjects.PrestaContactUs;
import com.presta.pageobjects.PrestaSignIn;
import com.presta.pageobjects.basepages.PageObjectBase;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.Hyperlink;
import com.sqs.web.elements.Label;
import com.sqs.web.elements.TextArea;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


/**
 * The Presta header.
 */
public class PrestaHeader<TOriginPage> extends PageObjectBase<TOriginPage> {

  public final Label yourAccountLabel = new Label(By.xpath("//h1[normalize-space()='Your account']"));
  private final Button signIn = new Button(By.xpath("//*[@id='_desktop_user_info']/div/a/span"));
  private final Hyperlink contactUs = new Hyperlink(By.xpath("//*[@id='contact-link']/a"));
  private final TextArea searchTextBox = new TextArea(By.name("s"));
  private final Button searchButtonSubmit = new Button(By.xpath("//button[@type='submit']"));
  private final Button cartButton = new Button(By.xpath("//span[.='Cart']"));

  PageObjectBase<TOriginPage> page;

  public PrestaHeader(PageObjectBase<TOriginPage> originPage) {
    this.page = originPage;
    OriginPage = originPage;
  }

  /**
   * Click the Cart button
   *
   * @return the original page
   */
  @Step("Click the cart button")
  public TOriginPage clickCartButton() {
    cartButton.click();
    return (TOriginPage) this;
  }

  /**
   * Navigate to presta sign in presta sign in.
   *
   * @return the presta sign in
   */
  @Step("Navigation to the sign in presta page")
  public PrestaSignIn navigateToPrestaSignIn() {
    signIn.click();
    return navigatingTo(PrestaSignIn.class);
  }

  /**
   * Navigate to presta contact us presta contact us.
   *
   * @return the presta contact us
   */
  @Step("Navigation to the contact us presta page")
  public PrestaContactUs navigateToPrestaContactUs() {
    contactUs.click();
    return navigatingTo(PrestaContactUs.class);
  }

  public TOriginPage test() {
    contactUs.click();
    return (TOriginPage) page;
  }

  /**
   * Presta header fill email presta header.
   *
   * @param search the search
   * @return the presta header
   */
  @Step("Filling in search criteria:")
  public PrestaHeader prestaHeaderFillEmail(String search) {
    searchTextBox.clearText();
    searchTextBox.setText(search);
    return this;
  }

  /**
   * Presta header click send presta header.
   *
   * @return the presta header
   */
  @Step("Clicking of search button")
  public PrestaHeader prestaHeaderClickSend() {
    searchButtonSubmit.click();
    return this;
  }

  /**
   * Presta header send email presta header.
   *
   * @param search the search
   * @return the presta header
   */
  @Step("Sending of search criteria:")
  public PrestaHeader prestaHeaderSendEmail(String search) {
    prestaHeaderFillEmail(search);
    prestaHeaderClickSend();
    return this;
  }

}

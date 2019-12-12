package com.presta.pageobjects;

import com.presta.pageobjects.basepages.PrestaBasePage;
import com.sqs.web.elements.Label;
import org.openqa.selenium.By;

/**
 * Created by BreslinS on 25/01/2018.
 */
public class PrestaOrderConfirmedPage extends PrestaBasePage<PrestaOrderConfirmedPage> {

  public final Label orderConfirmed = new Label(By.xpath("//*[@class='h1 card-title' and contains(normalize-space(),'Your order is confirmed')]"));

}

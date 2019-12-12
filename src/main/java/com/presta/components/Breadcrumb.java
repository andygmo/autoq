package com.presta.components;

import com.presta.pageobjects.PrestaHome;
import com.presta.pageobjects.PrestaStandardCategoryPage;
import com.presta.pageobjects.basepages.PageObjectBase;
import com.sqs.core.common.CommonActions;
import com.sqs.web.elements.common.ClickableElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Breadcrumb<TOriginPage> extends PageObjectBase<TOriginPage> {

  PageObjectBase<TOriginPage> page;

  public Breadcrumb(PageObjectBase<TOriginPage> originPage) {
    this.page = originPage;
    OriginPage = originPage;
  }

  /**
   * Navigating up one level via the breadcrumb
   *
   * @return the PrestaStandardCategoryPage page object
   */
  @Step("Navigating up one level via the breadcrumb")
  public PrestaStandardCategoryPage navigateUpOneLevel() {
    CommonActions.pauseTest(1);
    new ClickableElement(By.xpath("//li[@itemprop='itemListElement'][last()]/preceding-sibling::li[1]")).click();
    return navigatingTo(PrestaStandardCategoryPage.class);
  }

  /**
   * Navigating to the parent level via the breadcrumb
   *
   * @return the PrestaHome Page page object
   */
  @Step("Navigating to the parent level via the breadcrumb")
  public PrestaHome navigateUpToParentLevel() {
    new ClickableElement(By.xpath("//li[@itemprop='itemListElement'][1]")).click();
    return navigatingTo(PrestaHome.class);
  }

}

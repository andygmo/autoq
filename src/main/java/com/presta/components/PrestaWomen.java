package com.presta.components;

import com.presta.enums.WomenCategory;
import com.presta.pageobjects.PrestaStandardCategoryPage;
import com.presta.pageobjects.basepages.PageObjectBase;
import com.sqs.web.elements.common.ClickableElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


/**
 * Created by BreslinS on 19/01/2018.
 */
public class PrestaWomen<TOrigin> extends PageObjectBase<TOrigin> {

  PageObjectBase<TOrigin> page;

  public PrestaWomen(PageObjectBase<TOrigin> originPage) {
    this.page = originPage;
    OriginPage = originPage;
  }

  /**
   * Navigates user from the Women link to main Categories
   *
   * @param mainCateogry the women category link
   * @return the standard presta page
   */
  @Step("Navigate to the Women hyperlink main category options")
  public PrestaStandardCategoryPage navigateToPrestaMainCategory(WomenCategory mainCateogry) {
    new ClickableElement(By.id("category-3")).mouseHover();
    new ClickableElement(By.xpath("//*[@class='top-menu']//a[contains(normalize-space(), '" + mainCateogry.menuOption() + "')]")).click();
    return navigatingTo(PrestaStandardCategoryPage.class);
  }

  /**
   * Navigates user from the Women link to sub Categories
   *
   * @param womenCategory the women category link
   * @return the standard presta page
   */
  @Step("Navigate to the Women hyperlink sub category options")
  public PrestaStandardCategoryPage navigateToPrestaSubCategory(WomenCategory womenCategory) {
    new ClickableElement(By.id("category-3")).mouseHover();
    new ClickableElement(By.xpath("//a[@class='dropdown-item' and contains(text(), '" + womenCategory.menuOption() + "')]")).click();
    return navigatingTo(PrestaStandardCategoryPage.class);
  }

  public PrestaStandardCategoryPage clickWomenHyperlink() {
    new ClickableElement(By.id("category-3")).click();
    return navigatingTo(PrestaStandardCategoryPage.class);
  }

}

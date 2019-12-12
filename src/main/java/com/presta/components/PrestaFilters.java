package com.presta.components;

import com.presta.enums.FilterBy;
import com.presta.pageobjects.basepages.PageObjectBase;
import com.sqs.web.elements.CheckBox;
import com.sqs.web.elements.Label;
import com.sqs.web.elements.common.ClickableElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

/**
 * Created by BreslinS on 26/01/2018.
 */
public class PrestaFilters<TOrigin> extends PageObjectBase<TOrigin> {

  private final Label activeFilters = new Label(By.xpath("//section[@id='js-active-search-filters']"));

  PageObjectBase<TOrigin> page;

  public PrestaFilters(PageObjectBase<TOrigin> originPage) {
    this.page = originPage;
    OriginPage = originPage;
  }

  /**
   * The active filter data provider
   *
   * @return the new data provider object
   */
  @DataProvider(name = "activeFilters")
  public static Object[][] filterOptions() {
    return new Object[][] {

        new Object[] {FilterBy.MEDIUM.menuOption(),
            FilterBy.BLACK.menuOption(),
            FilterBy.COTTON.menuOption()},

    };
  }

  /**
   * Get the current page title
   *
   * @param value the page name value
   * @return the page title label
   */
  @Step("Select Checkbox {0}")
  public TOrigin selectCheckbox(String value) {
    new CheckBox(By.xpath("//a[contains(normalize-space(),'" + value + " (')]")).setCheckBox();
    return (TOrigin) page;
  }

  /**
   * Select the filter by options
   *
   * @param filterSize  the size filter
   * @param filterColor the color filter
   * @param composition the composition filter
   * @return the PrestaStandardCategoryPage page object
   */
  @Step("Select a filter option")
  public PrestaFilters selectFilterByCriteria(FilterBy filterSize, FilterBy filterColor, FilterBy composition) {
    // Click on size filter option
    new ClickableElement(By.xpath("//section[@class='facet']//a[contains(text(),'" + filterSize.menuOption() + "')]")).click();
    // Click on color filter option
    new ClickableElement(By.xpath("//section[@class='facet']//a[contains(text(),'" + filterColor.menuOption() + "')]")).click();
    // Click on composition filter option
    new ClickableElement(By.xpath("//section[@class='facet']//a[contains(text(),'" + composition.menuOption() + "')]")).click();
    return this;
  }

  /**
   * Select the filter by options using a data provider
   *
   * @param filterSize  the size filter
   * @param filterColor the color filter
   * @param composition the composition filter
   * @return the PrestaStandardCategoryPage page object
   */
  @Step("Select a filter option")
  public PrestaFilters selectFilterCriteriaByDataProvider(String filterSize, String filterColor, String composition) {
    // Click on size filter option
    new ClickableElement(By.xpath("//section[@class='facet']//a[contains(text(),'" + filterSize + "')]")).click();
    // Click on color filter option
    new ClickableElement(By.xpath("//section[@class='facet']//a[contains(text(),'" + filterColor + "')]")).click();
    // Click on composition filter option
    new ClickableElement(By.xpath("//section[@class='facet']//a[contains(text(),'" + composition + "')]")).click();
    return this;
  }


}

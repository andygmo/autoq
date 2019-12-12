package com.presta.pageobjects;

import com.presta.components.Breadcrumb;
import com.presta.customElements.PrestaDropdown;
import com.presta.enums.Dropdowns;
import com.presta.enums.FilterBy;
import com.presta.enums.Product;
import com.presta.enums.SortBy;
import com.presta.pageobjects.basepages.PrestaBasePage;
import com.sqs.core.common.CommonActions;
import com.sqs.web.elements.Button;
import com.sqs.web.elements.Hyperlink;
import com.sqs.web.elements.Label;
import com.sqs.web.elements.common.ClickableElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

/**
 * Created by BreslinS on 19/01/2018.
 */
public class PrestaStandardCategoryPage extends PrestaBasePage<PrestaStandardCategoryPage> {

  public final PrestaDropdown sortByDropdown = new PrestaDropdown(Dropdowns.SORTBY);
  public final Hyperlink clickproduct = new Hyperlink(By.xpath("//*[@class='h3 product-title']//a[contains(text(),'Printed Summer Dress')]"));
  private final Label activeFilters = new Label(By.xpath("//section[@id='js-active-search-filters']"));
  public Breadcrumb<PrestaStandardCategoryPage> Breadcrumb = new Breadcrumb<>(this);

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
   * Select a Sort By dropdown value
   *
   * @param sortByOption the sortByOption string value
   * @return the Presta Standard Category Page page object
   */
  @Step("The 'Sort by' dropdown option is selected")
  public PrestaStandardCategoryPage selectSortByOption(SortBy sortByOption) {
    sortByDropdown.selectOptionByName(sortByOption);
    CommonActions.pauseTest(1);
    return this;
  }

  /**
   * Get the number of products on page
   *
   * @return the number of products on the page
   */
  @Step("Get the number of products on page")
  public int getNoOfProductsOnPage() {
    return new ClickableElement(By.xpath("//div[@class='thumbnail-container']")).getListOfElements().size();
  }

  /**
   * Get the number of products on page
   *
   * @return the number of products on the page
   */
  @Step("Get the number of products on page")
  public boolean isFilterButtonDisplayed(String filterLabel) {
    return getFilterButton(filterLabel).isDisplayed();
  }

  private Button getFilterButton(String filterLabel) {
    return new Button(By.xpath("//li[contains(normalize-space(),'" + filterLabel + "')]"));
  }

  /**
   * Select a product on the page
   *
   * @param productName the product name
   */

  @Step("Click on required product")
  public PrestaProductPage selectProductByName(Product productName) {
    new ClickableElement(By.xpath("//*[@class='products row']//a[contains(text(), '" + productName.menuOption + "')]")).click();
    return navigatingTo(PrestaProductPage.class);
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
  public PrestaStandardCategoryPage selectFilterByCriteria(FilterBy filterSize, FilterBy filterColor, FilterBy composition) {
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
  public PrestaStandardCategoryPage selectFilterCriteriaByDataProvider(String filterSize, String filterColor, String composition) {
    // Click on size filter option
    new ClickableElement(By.xpath("//section[@class='facet']//a[contains(text(),'" + filterSize + "')]")).click();
    // Click on color filter option
    new ClickableElement(By.xpath("//section[@class='facet']//a[contains(text(),'" + filterColor + "')]")).click();
    // Click on composition filter option
    new ClickableElement(By.xpath("//section[@class='facet']//a[contains(text(),'" + composition + "')]")).click();
    return this;
  }

}

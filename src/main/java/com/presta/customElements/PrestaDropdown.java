package com.presta.customElements;

import com.presta.enums.Dropdowns;
import com.presta.enums.Size;
import com.presta.enums.SortBy;
import com.sqs.web.elements.common.ClickableElement;
import org.openqa.selenium.By;

public class PrestaDropdown {

  ClickableElement customDropdown;
  String baseDropdownXPath;
  ClickableElement sizeDropdown;
  String sizeDropdownXPath;

  public PrestaDropdown(Dropdowns dropdown) {
    baseDropdownXPath = "//span[.='" + dropdown.menuOption() + "']//following::a[@class='select-title']";
    customDropdown = new ClickableElement(By.xpath(baseDropdownXPath));

    sizeDropdownXPath = "//span[.='" + dropdown.menuOption() + "']//following::select[@id='group_1']";
    sizeDropdown = new ClickableElement(By.xpath(sizeDropdownXPath));
  }

  /**
   * Gets the page dropdown value
   *
   * @return the value
   */
  public String getDropdownValue() {
    return customDropdown.getText().replace("\n\uE5C5", "");
  }

  /**
   * Selects Sort by dropdown option
   *
   * @param sortByOption the dropdown option
   */
  public void selectOptionByName(SortBy sortByOption) {
    //Click the dropdown to show list of options
    customDropdown.click();
    //Click the option
    new ClickableElement(By.xpath(baseDropdownXPath + "//following::a[contains(text(),'" + sortByOption.menuOption() + "')]")).click();
  }

  /**
   * Selects Size dropdown option
   *
   * @param sizeOption the dropdown option
   */
  public void selectOptionBySize(Size sizeOption) {
    //Click the dropdown to show list of options
    sizeDropdown.click();
    //Click the option
    new ClickableElement(By.xpath(sizeDropdownXPath + "//option[@title='" + sizeOption.menuOption() + "']")).click();
  }
}

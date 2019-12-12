package com.presta.enums;

/**
 * Created by BreslinS on 19/01/2018.
 */
public enum Dropdowns {
  SORTBY("Sort by:"),
  SIZE("Size");

  public String menuOption;

  Dropdowns(String menuOption) {
    this.menuOption = menuOption;
  }

  public String menuOption() {
    return menuOption;
  }
}

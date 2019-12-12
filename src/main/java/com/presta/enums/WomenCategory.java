package com.presta.enums;

/**
 * Created by BreslinS on 19/01/2018.
 */
public enum WomenCategory {
  WOMEN("Women"),
  TOPS("Tops"),
  T_SHIRTS("T-shirts"),
  BLOUSES("Blouses"),
  DRESSES("Dresses"),
  CASUAL_DRESSES("Casual Dresses"),
  EVENING_DRESSES("Evening Dresses"),
  SUMMER_DRESSES("Summer Dresses");

  public String menuOption;

  WomenCategory(String menuOption) {
    this.menuOption = menuOption;
  }

  public String menuOption() {
    return menuOption;
  }
}

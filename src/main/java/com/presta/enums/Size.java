package com.presta.enums;

/**
 * Created by BreslinS on 24/01/2018.
 */
public enum Size {
  SMALL("S"),
  MEDIUM("M"),
  LARGE("L");

  public String menuOption;

  Size(String menuOption) {
    this.menuOption = menuOption;
  }


  public String menuOption() {
    return menuOption;
  }
}

package com.presta.enums;

/**
 * Created by BreslinS on 19/01/2018.
 */
public enum SortBy {
  RELEVANCE("Relevance"),
  NAMEATOZ("Name, A to Z");

  public String menuOption;

  SortBy(String menuOption) {
    this.menuOption = menuOption;
  }

  public String menuOption() {
    return menuOption;
  }
}

package com.presta.enums;

public enum Colour {
  BEIGE("7"),
  WHITE("8"),
  BLACK("11"),
  ORANGE("13"),
  BLUE("14"),
  GREEN("15"),
  YELLOW("16"),
  PINK("24");


  public String menuOption;

  Colour(String menuOption) {
    this.menuOption = menuOption;
  }

  public String menuOption() {
    return menuOption;
  }
}

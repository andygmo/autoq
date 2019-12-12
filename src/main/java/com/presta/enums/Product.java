package com.presta.enums;

public enum Product {

  PrintedSummerDress("Printed Summer Dress"),
  PrintedDress("Printed Dress"),
  FadedShortSleeveTshirt("Faded Short Sleeves T-Shirt"),
  Blouse("Blouse"),
  PrintedChiffonDress("Printed Chiffon Dress");


  public String menuOption;


  Product(String menuOption) {
    this.menuOption = menuOption;
  }

  public String menuOption() {
    return menuOption;
  }
}




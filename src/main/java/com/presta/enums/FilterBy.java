package com.presta.enums;

/**
 * Created by BreslinS on 25/01/2018.
 */
public enum FilterBy {
  // Filter Size
  SMALL("S"),
  MEDIUM("M"),
  LARGE("L"),

  // Filter Color
  BEIGE("Beige"),
  WHITE("White"),
  BLACK("Black"),
  ORANGE("Orange"),
  BLUE("Blue"),
  GREEN("Green"),
  YELLOW("Yellow"),
  PINK("Pink"),

  // Filter Compositions
  COTTON("Cotton"),
  POLYESTER("Polyester"),
  VISCOSE("Viscose"),

  // Filter Styles
  CASUAL("Casual"),
  DRESSY("Dressy"),
  GIRLY("Girly"),

  // Filter Properties
  COLORFUL_DRESS("Colorful Dress"),
  MAXI_DRESS("Maxi Dress"),
  MIDI_DRESS("Midi Dress"),
  SHORT_DRESS("Short Dress"),
  SHORT_SLEEVE("Short Sleeve"),

  // Filter Price
  $16_$17("$16.00 - $17.00"),
  $25_$27("$25.00 - $27.00"),
  $28_$32("$28.00 - $32.00"),
  $50_$53("$50.00 - $53.00");


  public String menuOption;

  FilterBy(String menuOption) {
    this.menuOption = menuOption;
  }

  public String menuOption() {
    return menuOption;
  }
}

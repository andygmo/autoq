package com.presta.enums;

public enum ErrorMessages {
  BLANKFIELD("Please fill in this field."),
  DATEFORMAT("Format should be 1970-05-31."),
  FORMATREQUESTED("Please match the format requested."),
  COMMAEMAILERROR("A part followed by '@' should not contain the symbol ','."),
  EMAILQUOTATIONMARK("A part followed by '@' should not contain the symbol '\"'."),
  INVALIDNAME("Invalid name"),
  NOERROR("");


  public String menuOption;

  ErrorMessages(String menuOption) {
    this.menuOption = menuOption;
  }

  public String menuOption() {
    return menuOption;
  }
}
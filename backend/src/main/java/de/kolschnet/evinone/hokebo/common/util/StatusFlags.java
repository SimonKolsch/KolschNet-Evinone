package de.kolschnet.evinone.hokebo.common.util;


import lombok.Getter;

public enum StatusFlags {

  OPEN("O"),
  DONE("D"),
  ;

  @Getter
  private final String shortStatus;

  StatusFlags(String status) {
    this.shortStatus = status;
  }

  public String getShortStatus() {
    return shortStatus;
  }

}

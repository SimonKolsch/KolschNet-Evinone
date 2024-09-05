package de.kolschnet.evinone.hokebo.common.exceptions;

import java.io.Serial;

/**
 * All exceptions thrown within this application should inherit from this
 */
public class KolschNetException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 1L;

  public KolschNetException(String message) {
    super(message);
  }

  public KolschNetException(String message, Throwable throwable) {
    super(message, throwable);
  }

  public String getCode() {
    return this.getClass().getCanonicalName();
  }
}

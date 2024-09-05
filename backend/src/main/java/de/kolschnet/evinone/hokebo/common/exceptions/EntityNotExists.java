package de.kolschnet.evinone.hokebo.common.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityNotExists extends HttpException {

  public EntityNotExists(String message) {
    super(message);
  }

  public EntityNotExists(String message, Info additionalInformation) {
    super(message, additionalInformation);
  }
}

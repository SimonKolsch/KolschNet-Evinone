package de.kolschnet.hokebo.common.exceptions;

import java.io.Serial;
import java.util.Map;
import java.util.TreeMap;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Each exception thrown to communication by a REST-API have to inherit from this
 * <p>
 * All Child-Exception will be converted into an Error-Response
 */
@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HttpException extends KolschNetException {

  @Serial
  private static final long serialVersionUID = 1L;

  private final String message;
  private final Map<String, Object> infoMap;

  public HttpException(String message) {
    this(message, new Info());
  }

  public HttpException(String message, Info additionalInformation) {
    super(message);

    this.message = message;
    this.infoMap = additionalInformation.toMap();
  }

  public HttpException(String message, Throwable throwable, Info additionalInformation) {
    super(message, throwable);

    this.message = message;
    infoMap = additionalInformation.toMap();
  }

  public static Info info(String key, Object value) {
    return new Info().and(key, value);
  }

  @Override
  public String getMessage() {
    return message.concat(" ").concat(infoMap.toString());
  }

  public static class Info {

    private final Map<String, Object> map;

    public Info(Map<String, Object> map) {
      this.map = map;
    }

    public Info() {
      map = new TreeMap<>();
    }

    public Info and(String key, Object value) {
      map.put(key, value);
      return this;
    }

    public Info andOptionally(String key, Object value) {
      if (value != null) {
        map.put(key, value);
      }
      return this;
    }

    private Map<String, Object> toMap() {
      return map;
    }
  }

}
package de.kolschnet.evinone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//excluded need for no Login-Page
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class EvinoneApplication {

  public static void main(String[] args) {
    SpringApplication.run(EvinoneApplication.class, args);
  }

}

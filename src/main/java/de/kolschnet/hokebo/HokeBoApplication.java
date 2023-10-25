package de.kolschnet.hokebo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//excluded need for no Login-Page
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class HokeBoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HokeBoApplication.class, args);
	}

}

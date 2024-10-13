package io.dumerz.authenticated;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AuthenticatedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticatedApplication.class, args);
	}

}

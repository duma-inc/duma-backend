package io.github.mattheusffalbuquerque.duma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DumaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DumaApplication.class, args);
	}

}

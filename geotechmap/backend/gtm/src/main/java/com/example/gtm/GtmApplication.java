package com.example.gtm;

// import java.util.List;

import com.example.gtm.Entities.SpringSecurityAuditorAware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

@EnableJpaAuditing(auditorAwareRef="auditorAware")
public class GtmApplication {


	@Bean
	public AuditorAware<String> auditorAware() {
		return new SpringSecurityAuditorAware();
	}

	public static void main(String[] args) {
		SpringApplication.run(GtmApplication.class, args);
	}

	// @GetMapping
	// public List<String> hello(){
	// 	return List.of("Hello", "World");
	// }

}

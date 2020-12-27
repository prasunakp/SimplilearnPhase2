package com.w.simplilearn.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableJpaRepositories("com.w.simplilearn.repository")
@EntityScan("com.w.training.entity")
public class DemoStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoStartApplication.class, args);
	}

}

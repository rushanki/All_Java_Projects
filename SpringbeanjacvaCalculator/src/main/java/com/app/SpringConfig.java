package com.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

	@Bean
	public Calculator cal() {
		Calculator c = new Calculator();
		return c;

	}

}

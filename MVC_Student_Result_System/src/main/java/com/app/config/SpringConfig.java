package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.app") // handle mapper
@EnableWebMvc
public class SpringConfig {
	@Bean
	public InternalResourceViewResolver irv() {
		InternalResourceViewResolver i = new InternalResourceViewResolver();

		i.setPrefix("/views/");
		i.setSuffix(".jsp");
		return i;

	}
}

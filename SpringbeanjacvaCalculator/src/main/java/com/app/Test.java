package com.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {

		ApplicationContext ap = new AnnotationConfigApplicationContext(SpringConfig.class);

		Calculator c = ap.getBean("cal", Calculator.class);
		c.add(10, 20);
		c.sub(20, 10);
		c.mul(10, 20);
		c.div(100, 50);

	}
}

package com.app.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class MyWebAppInitilizer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext ap = new AnnotationConfigWebApplicationContext();

		ap.register(SpringConfig.class);

		DispatcherServlet ds = new DispatcherServlet(ap);

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("ds", ds);

		dispatcher.addMapping("/");

	}

}

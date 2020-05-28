package com.musicsite.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("**/{path:[^\\.]*}").setViewName("index");
	}

}

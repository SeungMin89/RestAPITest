package com.simplify.sample;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ApiApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ApiApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port",  LibUtil.getProperties("server.api.port")));
		app.run(args);
		// SpringApplication.run(ApiApplication.class, args);
	
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ApiApplication.class);
	}
	
	
	
	
	
}

package com.pgr.sb.web.SBFirstWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SbFirstWebAppApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SbFirstWebAppApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SbFirstWebAppApplication.class);
	}

}

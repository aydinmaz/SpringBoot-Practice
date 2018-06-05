package it.finsoft.helloApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
@EnableAutoConfiguration(exclude=ErrorMvcAutoConfiguration.class)
public class HelloAppApplication extends SpringBootServletInitializer  {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HelloAppApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(HelloAppApplication.class, args);
	}
}

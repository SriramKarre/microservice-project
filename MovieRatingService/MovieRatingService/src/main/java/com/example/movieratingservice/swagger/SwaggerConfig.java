package com.example.movieratingservice.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI movieInfoOpenAPI() {
		return new OpenAPI().info(new Info().title("Movie Rating Service API")
				.description("API documentation for the Movie Rating Service").version("1.0.0"));
	}
}

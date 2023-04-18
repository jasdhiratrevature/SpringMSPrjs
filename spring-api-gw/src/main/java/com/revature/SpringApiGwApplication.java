package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringApiGwApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiGwApplication.class, args);
	}
	@Bean
	public RouteLocator serviceRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/api/health-record/*").uri("http://health-svc:8081/api/health-record"))
				.route(p -> p.path("/api/allergies/*").uri("http://allergy-svc:8082/api/allergies"))
				.build();
	}
}

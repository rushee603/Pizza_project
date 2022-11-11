package com.niit.APIGateway;


import com.niit.APIGateway.fillter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
@SpringBootApplication
@EnableEurekaClient

public class ApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {

		return builder.routes()
				.route(p -> p.path("/customer/**").uri("lb://auth-service"))
				.route(p -> p.path("/pizza/**").uri("lb://pizza-service"))
				.build();
	}

	@Bean
	public FilterRegistrationBean jwtFilter() {

		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.addUrlPatterns("/customer/*");
		return filterRegistrationBean;
	}
}

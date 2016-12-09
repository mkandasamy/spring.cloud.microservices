package com.kandasm.opm.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
@EnableZuulProxy
@EnableWebSecurity
public class STARTER {

	public static void main(String[] args) {
		SpringApplication.run(STARTER.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				
			}
		};
	}
}
package com.kandasm.opm.web;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PropertiesLoaderUtils;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class STARTER {

	public static void main(String[] args) {
		SpringApplication.run(STARTER.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(){
		return new CommandLineRunner() {
			@Autowired
			private Environment environment;
			
			@Override
			public void run(String... args) throws Exception {
				Properties properties = PropertiesLoaderUtils.loadAllProperties("log4j.properties");
				String file = environment.getProperty("logging.custom.file");
				if(file != null){
					properties.setProperty("log4j.appender.debugLog.File", file);
					PropertyConfigurator.configure(properties);
					Logger.getLogger(this.getClass()).info("Log4j is setup: " + file);
				}
			}
		};
	}
}
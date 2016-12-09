package com.kandasm.opm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.environment.JGitEnvironmentRepository;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.kandasm.opm.web.support.config.config.CodeCommitCredentialProvider;

@EnableConfigServer
@SpringBootApplication
@EnableEurekaClient
public class STARTER {
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(STARTER.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(){
		return new CommandLineRunner() {
			@Override
			public void run(String... arg0) throws Exception {
				try {
					JGitEnvironmentRepository jGitEnvironmentRepository =
							applicationContext.getBean(JGitEnvironmentRepository.class);
					
					String codeCommitRepoUri = environment.getProperty("AWS_CODECOMMIT_REPO_URI");
					String accessKey = environment.getProperty("AWS_CODECOMMIT_ACCESS_KEY");
					String secretKey = environment.getProperty("AWS_CODECOMMIT_SECRET_KEY");
					String password = CodeCommitCredentialProvider.provide(codeCommitRepoUri, accessKey, secretKey);
					jGitEnvironmentRepository.setUsername(accessKey);
					jGitEnvironmentRepository.setPassword(password);
				} catch (Exception e) {
					//e.printStackTrace();
				}
			}
		};
	}
}

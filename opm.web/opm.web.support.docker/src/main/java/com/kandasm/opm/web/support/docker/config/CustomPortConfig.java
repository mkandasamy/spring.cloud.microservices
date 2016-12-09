package com.kandasm.opm.web.support.docker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

//@Configuration
public class CustomPortConfig {
	
	@Autowired
    private ConfigurableEnvironment configurableEnvironment;
	
	@Autowired
	private CustomPortPropertySource customPortPropertySource;
	
	
	@Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            container.setPort(customPortPropertySource.getPort());
        });
    }
	
 	@Bean
    @Lazy(false)
    public CustomPortPropertySource portPropertySource() {
        MutablePropertySources sources = configurableEnvironment.getPropertySources();
        sources.addFirst(customPortPropertySource);
        return customPortPropertySource;
    }

}

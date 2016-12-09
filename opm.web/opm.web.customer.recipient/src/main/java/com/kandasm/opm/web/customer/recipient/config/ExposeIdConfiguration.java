package com.kandasm.opm.web.customer.recipient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.kandasm.opm.web.customer.recipient.db.model.Recipient;

@Configuration
public class ExposeIdConfiguration extends RepositoryRestMvcConfiguration {
 
    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Recipient.class);
    }
}
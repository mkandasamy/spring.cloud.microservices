package com.kandasm.opm.web.inventory.item.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.kandasm.opm.web.inventory.item.db.model.Item;

@Configuration
public class ExposeIdConfiguration extends RepositoryRestMvcConfiguration {
 
    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Item.class);
    }
}
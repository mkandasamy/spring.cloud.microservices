package com.kandasm.opm.web.order.receipt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.kandasm.opm.web.order.receipt.db.model.Destination;
import com.kandasm.opm.web.order.receipt.db.model.Item;
import com.kandasm.opm.web.order.receipt.db.model.Order;
import com.kandasm.opm.web.order.receipt.db.model.OrderLine;
import com.kandasm.opm.web.order.receipt.db.model.Recipient;

@Configuration
public class ExposeIdConfiguration extends RepositoryRestMvcConfiguration {
 
    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Recipient.class, OrderLine.class, Order.class, Item.class, Destination.class);
    }
}
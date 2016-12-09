package com.kandasm.opm.web.order.generator.rest.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kandasm.opm.web.order.generator.rest.model.Item;

@FeignClient("OPM-WEB-INVENTORY-ITEM")
@RequestMapping(value = "/items")
public interface ItemClient {
	
    @RequestMapping(method = RequestMethod.POST, value = "/")
    Long save(Item t);
 
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}") 
    void update(@PathVariable("id") Long id, Item t);   
 
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    Item get(@PathVariable("id") Long id);
 
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")   
    void delete(@PathVariable("id") Long id);
	
}

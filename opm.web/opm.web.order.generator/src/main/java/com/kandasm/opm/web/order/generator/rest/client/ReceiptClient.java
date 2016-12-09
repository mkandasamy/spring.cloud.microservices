package com.kandasm.opm.web.order.generator.rest.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kandasm.opm.web.order.generator.rest.model.Order;

@FeignClient("OPM-WEB-ORDER-RECEIPT")
@RequestMapping(value = "/receipts")
public interface ReceiptClient {
	
    @RequestMapping(method = RequestMethod.POST, value = "/")
    Order save(@RequestBody Order order);
 
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}") 
    void update(@PathVariable("id") Long id, @RequestBody Order order);   
 
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    Order get(@PathVariable("id") Long id);
 
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")   
    void delete(@PathVariable("id") Long id);
	
}

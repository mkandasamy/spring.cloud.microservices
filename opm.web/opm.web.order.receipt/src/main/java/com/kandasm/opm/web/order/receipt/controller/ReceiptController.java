package com.kandasm.opm.web.order.receipt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kandasm.opm.web.order.receipt.db.model.Order;
import com.kandasm.opm.web.order.receipt.db.repo.ReceiptRepository;
import com.kandasm.opm.web.order.receipt.db.repo.ReceiptRepositoryIface;

@RestController
@Configuration
public class ReceiptController {
	
	@Autowired
	private ReceiptRepository repository;
	
	@RequestMapping("/test/auth")
    public String test() {
        return "test auth success";
    }
	
	@RequestMapping("/test")
    public String testOrder(@RequestBody Order order ) {
		((ReceiptRepositoryIface)repository).save(order);
        return "test success";
    }
	
}
    

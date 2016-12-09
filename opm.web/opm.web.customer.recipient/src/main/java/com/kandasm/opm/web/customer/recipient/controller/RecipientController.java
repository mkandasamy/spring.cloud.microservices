package com.kandasm.opm.web.customer.recipient.controller;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
public class RecipientController {
	
	@RequestMapping("/test")
    public String test() {
        return "test success";
    }
}
    

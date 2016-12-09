package com.kandasm.opm.web.order.receipt;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.kandasm.opm.web.order.receipt.rest.model.Destination;
import com.kandasm.opm.web.order.receipt.rest.model.Item;
import com.kandasm.opm.web.order.receipt.rest.model.Order;
import com.kandasm.opm.web.order.receipt.rest.model.OrderLine;
import com.kandasm.opm.web.order.receipt.rest.model.Recipient;

public class Tester {

	@Ignore @Test
	public void first() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		Item item = restTemplate.getForObject("http://tccmkandasamy.hibbertnet.com:63755/items/1", Item.class);
		Recipient recipient = restTemplate.getForObject("http://tccmkandasamy.hibbertnet.com:63837/recipients/1", Recipient.class);
		
		Order order = new Order();
		order.setCreatedOn(new Date());
		order.setStatus("xENTERED");
		order.setCarrier("USPS");
		
		OrderLine orderLine = new OrderLine();
		orderLine.setItem(item);
		orderLine.setQuantity(25L);
		order.getOrderLines().add(orderLine);
		
		Destination destination = new Destination();
		destination.setRecipient(recipient);
		destination.setDeliveryMethod("xSIGNATURE");
		destination.setDestinationType("HOME-OFFICE");
		order.getDestinations().add(destination);
		order.setCreatedOn(new Date());
		
		HttpEntity<Order> entity = new HttpEntity<>(order);
		
		ResponseEntity<String> resp = restTemplate.exchange(
				"http://tccmkandasamy.hibbertnet.com:49301/receipts", 
				HttpMethod.POST,
				entity,
			    String.class);
		
		System.out.println(resp.getBody());
	}

}

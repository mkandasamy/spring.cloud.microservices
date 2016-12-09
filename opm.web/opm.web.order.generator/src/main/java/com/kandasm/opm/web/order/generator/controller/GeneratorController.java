package com.kandasm.opm.web.order.generator.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kandasm.opm.web.order.generator.rest.client.ReceiptClient;
import com.kandasm.opm.web.order.generator.rest.model.Destination;
import com.kandasm.opm.web.order.generator.rest.model.Generate;
import com.kandasm.opm.web.order.generator.rest.model.Item;
import com.kandasm.opm.web.order.generator.rest.model.Order;
import com.kandasm.opm.web.order.generator.rest.model.OrderLine;
import com.kandasm.opm.web.order.generator.rest.model.Recipient;
import com.kandasm.opm.web.order.generator.service.ItemProviderService;
import com.kandasm.opm.web.order.generator.service.RecipientProviderService;

@RestController
@Configuration
public class GeneratorController {
	
	@Autowired
	private ReceiptClient receiptClient;
	
	@Autowired
	private ItemProviderService itemProviderService;
	
	@Autowired
	private RecipientProviderService recipientProviderService;
	
	@RequestMapping("/test/auth")
    public String test() {
        return "test auth success";
    }
	
	@RequestMapping("/test")
    public Order testOrder(@RequestBody Generate generate) {
		
		Order order = new Order();
		order.setCreatedOn(new Date());
		order.setStatus(status());
		order.setCarrier(carrier());
		order
			.getOrderLines()
			.addAll(
				orderLines(
					itemProviderService
						.provideList(
								range(1, generate.getItems().intValue())
						), 
					generate.getOrderLines().intValue(),
					itemProviderService.defaultItem()
				)
			);
		
		order
			.getDestinations()
			.addAll(
				destinations(
					recipientProviderService
						.provideList(
							range(1, generate.getRecipients().intValue())
						),
					generate.getDestinations().intValue(),
					recipientProviderService.defaultRecipient()
				)
			);
		
        return receiptClient.save(order);
    }
	
	private List<OrderLine> orderLines(List<Item> items, int count, Item defaultItem){
		return range(0, count)
			.parallelStream()
			.map(i -> {
				OrderLine orderLine = new OrderLine();
				orderLine.setItem(pickRandom(items, defaultItem));
				orderLine.setQuantity(quantity());
				return orderLine;
			}).collect(Collectors.toList());
	}
	
	private List<Destination> destinations(List<Recipient> recipients, int count, Recipient defaultRecipient){
		return range(0, count)
			.parallelStream()
			.map(i -> {
				Destination destination = new Destination();
				destination.setRecipient(pickRandom(recipients, defaultRecipient));
				destination.setDeliveryMethod(deliveryMethod());
				destination.setDestinationType(destinationType());
				return destination;
			}).collect(Collectors.toList());
	}
	
	private String status(){
		return "ENTERED";
	}
	
	private String carrier(){
		return pickRandom(carriers());
	}

	private static Long quantity(){
		return new Long(random(1, 25));
	}
	
	private String deliveryMethod(){
		return pickRandom(deliveryMethods());
	}
	
	private String destinationType(){
		return pickRandom(destinationTypes());
	}
	
	private static List<String> deliveryMethods(){
		List<String> list = new ArrayList<>();
		list.add("DOOR");
		list.add("GATE");
		list.add("SIGN");
		list.add("TAG");
		return list;
	}
	
	private static List<String> destinationTypes(){
		List<String> list = new ArrayList<>();
		list.add("HOME");
		list.add("OFFICE");
		list.add("HOME-OFFICE");
		list.add("WAREHOUSE");
		return list;
	}
	
	private static List<String> carriers(){
		List<String> list = new ArrayList<>();
		list.add("DHL");
		list.add("FEDEX");
		list.add("UPS");
		list.add("USPS");
		return list;
	}
	
	private <T extends Object> T pickRandom(List<T> list, T defaultItem){
		if(list.isEmpty())
			return defaultItem;
		return pickRandom(list);
	}
	
	private <T extends Object> T pickRandom(List<T> list){
		return list.get(random(0, list.size()));
	}
	
	private static int random(int min, int max){
		return min + (int)(Math.random() * ((max - min)));
	}
	
	private List<Long> range(int min, int max){
		return IntStream
				.range(min, max)
				.mapToObj(Long::new)
				.collect(Collectors.toList());
	}
}
    

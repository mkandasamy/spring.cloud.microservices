package com.kandasm.opm.web.order.receipt.db.repo;

import org.springframework.beans.factory.annotation.Autowired;

import com.kandasm.opm.web.order.receipt.db.model.Destination;
import com.kandasm.opm.web.order.receipt.db.model.Order;
import com.kandasm.opm.web.order.receipt.db.model.OrderLine;

public class ReceiptRepositoryImpl implements ReceiptRepositoryIface {

    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order) {
    	
    	for(OrderLine orderLine: order.getOrderLines())
			orderLine.setOrder(order);
		
		for(Destination destination: order.getDestinations())
			destination.setOrder(order);
		
    	orderRepository.save(order);
    	
    	return order;
    }
}
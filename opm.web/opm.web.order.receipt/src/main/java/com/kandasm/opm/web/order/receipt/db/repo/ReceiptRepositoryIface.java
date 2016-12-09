package com.kandasm.opm.web.order.receipt.db.repo;

import com.kandasm.opm.web.order.receipt.db.model.Order;

public interface ReceiptRepositoryIface {
	
    public Order save(Order order);
    
}
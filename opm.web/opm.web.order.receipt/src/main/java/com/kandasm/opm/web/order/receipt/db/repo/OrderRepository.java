package com.kandasm.opm.web.order.receipt.db.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kandasm.opm.web.order.receipt.db.model.Order;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders", exported = false)
public interface OrderRepository extends CrudRepository<Order, Long> {
	
}

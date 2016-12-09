package com.kandasm.opm.web.order.receipt.db.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kandasm.opm.web.order.receipt.db.model.Order;

@RepositoryRestResource(collectionResourceRel = "receipts", path = "receipts")
public interface ReceiptRepository extends PagingAndSortingRepository<Order, Long>, ReceiptRepositoryIface {

}
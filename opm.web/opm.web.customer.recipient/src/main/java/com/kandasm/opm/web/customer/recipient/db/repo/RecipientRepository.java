package com.kandasm.opm.web.customer.recipient.db.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kandasm.opm.web.customer.recipient.db.model.Recipient;

@RepositoryRestResource(collectionResourceRel = "recipients", path = "recipients")
public interface RecipientRepository extends PagingAndSortingRepository<Recipient, Long> {
	
}

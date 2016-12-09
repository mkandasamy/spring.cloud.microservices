package com.kandasm.opm.web.inventory.item.db.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.kandasm.opm.web.inventory.item.db.model.Item;

@RepositoryRestResource(collectionResourceRel = "items", path = "items")
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {
	
}

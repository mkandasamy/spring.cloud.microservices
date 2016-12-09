package com.kandasm.opm.web.order.generator.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kandasm.opm.web.order.generator.rest.client.ItemClient;
import com.kandasm.opm.web.order.generator.rest.model.Item;
import com.kandasm.opm.web.util.hystrix.DefaultProvider;
import com.kandasm.opm.web.util.hystrix.Provider;
import com.kandasm.opm.web.util.hystrix.ProviderService;

@Service
public class ItemProviderService extends ProviderService<Long, Item> {
	
	@Autowired
	private ItemClient itemClient;
	
	@Override
	public Provider<Long, Item> provider(){
		return (id) -> itemClient.get(id);
	}
	
	@Override
	public DefaultProvider<Item> defaultProvider() {
		return () -> defaultItem();
	}
	
	public Item defaultItem() {
		Item defaultItem = new Item();
		defaultItem.setItemId(0L);
		defaultItem.setActive("0");
		defaultItem.setAvailable(0L);
		defaultItem.setCode("NIL");
		defaultItem.setDescription("N/A");
		defaultItem.setExpiry(new Date());
		defaultItem.setName("NULL");
		defaultItem.setPrice(0.0);
		return defaultItem;
	}
}

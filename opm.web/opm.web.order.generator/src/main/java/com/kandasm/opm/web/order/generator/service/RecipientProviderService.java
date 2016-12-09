package com.kandasm.opm.web.order.generator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kandasm.opm.web.util.hystrix.DefaultProvider;
import com.kandasm.opm.web.util.hystrix.Provider;
import com.kandasm.opm.web.util.hystrix.ProviderService;
import com.kandasm.opm.web.order.generator.rest.client.RecipientClient;
import com.kandasm.opm.web.order.generator.rest.model.Recipient;

@Service
public class RecipientProviderService extends ProviderService<Long, Recipient> {
	
	@Autowired
	private RecipientClient recipientClient;
	
	@Override
	public Provider<Long, Recipient> provider(){
		return (id) -> recipientClient.get(id);
	}
	
	@Override
	public DefaultProvider<Recipient> defaultProvider() {
		return () -> defaultRecipient();
	}
	
	public Recipient defaultRecipient() {
		Recipient defaultRecipient = new Recipient();
		defaultRecipient.setAddress1("NULL");
		defaultRecipient.setAddress2("NULL");
		defaultRecipient.setCity("NULL");
		defaultRecipient.setFirstName("NULL");
		defaultRecipient.setLastName("NULL");
		defaultRecipient.setState("NULL");
		defaultRecipient.setZip("NULL");
		defaultRecipient.setRecipientId(0L);
		return defaultRecipient;
	}
}

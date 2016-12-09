package com.kandasm.opm.web.order.receipt.rest.model;

import java.io.Serializable;


/**
 * The persistent class for the mkopm_destination database table.
 * 
 */
public class Destination implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long destinationId;

	private String deliveryMethod;

	private String destinationType;

	private Order order;

	private Recipient recipient;

	public Destination() {
	}

	public Long getDestinationId() {
		return this.destinationId;
	}

	public void setDestinationId(Long destinationId) {
		this.destinationId = destinationId;
	}

	public String getDeliveryMethod() {
		return this.deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public String getDestinationType() {
		return this.destinationType;
	}

	public void setDestinationType(String destinationType) {
		this.destinationType = destinationType;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Recipient getRecipient() {
		return this.recipient;
	}

	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}

}
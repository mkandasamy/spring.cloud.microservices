package com.kandasm.opm.web.order.generator.rest.model;

public class Generate {
	
	private Long items;
	private Long recipients;
	private Long orderLines;
	private Long destinations;
	
	public Long getItems() {
		return items;
	}
	public void setItems(Long items) {
		this.items = items;
	}
	public Long getRecipients() {
		return recipients;
	}
	public void setRecipients(Long recipients) {
		this.recipients = recipients;
	}
	public Long getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(Long orderLines) {
		this.orderLines = orderLines;
	}
	public Long getDestinations() {
		return destinations;
	}
	public void setDestinations(Long destinations) {
		this.destinations = destinations;
	}
}

package com.kandasm.opm.web.order.receipt.rest.model;

import java.io.Serializable;

/**
 * The persistent class for the mkopm_order_line database table.
 * 
 */
public class OrderLine implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long orderLineId;

	private Long quantity;

	private Item item;

	private Order order;

	public OrderLine() {
	}

	public Long getOrderLineId() {
		return this.orderLineId;
	}

	public void setOrderLineId(Long orderLineId) {
		this.orderLineId = orderLineId;
	}

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
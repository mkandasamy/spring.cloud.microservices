package com.kandasm.opm.web.order.receipt.db.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.rest.core.annotation.RestResource;


/**
 * The persistent class for the mkopm_order_line database table.
 * 
 */
@Entity
@Table(name="mkopm_order_line")
@NamedQuery(name="OrderLine.findAll", query="SELECT o FROM OrderLine o")
public class OrderLine implements Serializable {
	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name = "generator", sequenceName = "mkopm_order_line_seq")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "order_line_id", unique = true, nullable = false, precision = 22, scale = 0)
	private Long orderLineId;

	private Long quantity;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;

	//bi-directional many-to-one association to Order
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="order_id")
	@RestResource(rel="orderLine-order")
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
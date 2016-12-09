package com.kandasm.opm.web.order.receipt.db.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mkopm_order database table.
 * 
 */
@Entity
@Table(name="mkopm_order")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name = "generator", sequenceName = "mkopm_order_seq")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "order_id", unique = true, nullable = false, precision = 22, scale = 0)
	private Long orderId;

	private String carrier;

	@Temporal(TemporalType.DATE)
	@Column(name="created_on")
	private Date createdOn;

	private String status;

	//bi-directional many-to-one association to Destination
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL)
	private List<Destination> destinations = new ArrayList<>();

	//bi-directional many-to-one association to OrderLine
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL)
	private List<OrderLine> orderLines = new ArrayList<>();

	public Order() {
	}

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getCarrier() {
		return this.carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Destination> getDestinations() {
		return this.destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations =destinations;
	}

	public Destination addDestination(Destination destination) {
		getDestinations().add(destination);
		destination.setOrder(this);

		return destination;
	}

	public Destination removeDestination(Destination destination) {
		getDestinations().remove(destination);
		destination.setOrder(null);

		return destination;
	}

	public List<OrderLine> getOrderLines() {
		return this.orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public OrderLine addOrderLine(OrderLine orderLine) {
		getOrderLines().add(orderLine);
		orderLine.setOrder(this);

		return orderLine;
	}

	public OrderLine removeOrderLine(OrderLine orderLine) {
		getOrderLines().remove(orderLine);
		orderLine.setOrder(null);

		return orderLine;
	}

}
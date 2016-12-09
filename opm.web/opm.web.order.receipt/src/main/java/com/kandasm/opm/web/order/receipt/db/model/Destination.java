package com.kandasm.opm.web.order.receipt.db.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.rest.core.annotation.RestResource;


/**
 * The persistent class for the mkopm_destination database table.
 * 
 */
@Entity
@Table(name="mkopm_destination")
@NamedQuery(name="Destination.findAll", query="SELECT d FROM Destination d")
public class Destination implements Serializable {
	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name = "generator", sequenceName = "mkopm_item_seq")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "destination_id", unique = true, nullable = false, precision = 22, scale = 0)
	private Long destinationId;

	@Column(name="delivery_method")
	private String deliveryMethod;

	@Column(name="destination_type")
	private String destinationType;

	//bi-directional many-to-one association to Order
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="order_id")
	@RestResource(rel="destination-order")
	private Order order;

	//bi-directional many-to-one association to Recipient
	@ManyToOne
	@JoinColumn(name="recipient_id")
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
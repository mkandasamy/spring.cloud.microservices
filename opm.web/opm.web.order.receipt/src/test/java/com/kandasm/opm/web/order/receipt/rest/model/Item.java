package com.kandasm.opm.web.order.receipt.rest.model;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the mkopm_item database table.
 * 
 */
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long itemId;

	private String active;

	private Long available;

	private String code;

	private String description;

	private Date expiry;

	private String name;

	private Double price;

	public Item() {
	}

	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Long getAvailable() {
		return this.available;
	}

	public void setAvailable(Long available) {
		this.available = available;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpiry() {
		return this.expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
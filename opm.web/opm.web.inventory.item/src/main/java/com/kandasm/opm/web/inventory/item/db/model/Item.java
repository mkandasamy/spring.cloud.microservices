package com.kandasm.opm.web.inventory.item.db.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MKOPM_ITEM")
public class Item {

	@Id
	@Column(name = "ITEM_ID")
	private Long itemId;
	
	@Column(name = "CODE")
	private String code;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "PRICE")
	private Double price;
	
	@Column(name = "EXPIRY")
	private Date expiry;
	
	@Column(name = "ACTIVE")
	private Boolean active;
	
	@Column(name = "AVAILABLE")
	private Long available;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Long getAvailable() {
		return available;
	}

	public void setAvailable(Long available) {
		this.available = available;
	}
}

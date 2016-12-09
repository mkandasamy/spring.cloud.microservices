package com.kandasm.opm.web.order.receipt.rest.model;

import java.io.Serializable;

/**
 * The persistent class for the mkopm_recipient database table.
 * 
 */
public class Recipient implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long recipientId;

	private String address1;

	private String address2;

	private String city;

	private String firstName;

	private String lastName;

	private String state;

	private String zip;

	public Recipient() {
	}

	public Long getRecipientId() {
		return this.recipientId;
	}

	public void setRecipientId(Long recipientId) {
		this.recipientId = recipientId;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
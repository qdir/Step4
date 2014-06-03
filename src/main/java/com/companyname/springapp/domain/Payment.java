package com.companyname.springapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

//@IdClass(Payment.class)
@Entity
@Table(name = "payments")
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "expiringdate")
	private String expiringdate;
	// @Column(name = "identifier")
	private String identifier;

	// @Column(name = "fee")
	private Double fee;
	// @Column(name = "paid")
	private boolean paid;

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double price) {
		this.fee = price;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Date: " + expiringdate + ";");
		buffer.append(" Fee: " + fee);
		if (paid) {
			buffer.append(" Paid: ");
		} else {
			buffer.append(" Not paid");
		}

		return buffer.toString();
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getExpiringdate() {
		return expiringdate;
	}

	public void setExpiringdate(String expiringdate) {
		this.expiringdate = expiringdate;
	}

	// @Override
	// public boolean equals(Object obj) {
	// boolean equal = false;
	// Payment payment = (Payment) obj;
	//
	// if (this.identifier == payment.identifier
	// && this.expiringdate == payment.expiringdate) {
	// equal = true;
	// }
	// return equal;
	//
	// }
	//
	// @Override
	// public int hashCode() {
	// return super.hashCode();
	// }
}
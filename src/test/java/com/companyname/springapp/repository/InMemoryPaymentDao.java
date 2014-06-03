package com.companyname.springapp.repository;

import java.util.List;

import com.companyname.springapp.domain.Payment;

public class InMemoryPaymentDao implements PaymentDao {

	private List<Payment> productList;

	public InMemoryPaymentDao(List<Payment> paymentList) {
		this.productList = productList;
	}

	public List<Payment> getPaymentsList() {
		return productList;
	}

	public void savePayment(Payment payment) {
	}
}
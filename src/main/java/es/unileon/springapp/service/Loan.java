package es.unileon.springapp.service;

import java.util.List;

import es.unileon.springapp.domain.Payment;

public class Loan implements FinancialProduct {

	private static final long serialVersionUID = 1L;

	private List<Payment> payments;

	public List<Payment> getPayments() {
		return payments;
	}

	public void increasePrice(int percentage) {
		if (payments != null) {
			for (Payment payment : payments) {
				double newPrice = payment.getFee().doubleValue()
						* (100 + percentage) / 100;
				payment.setFee(newPrice);
			}
		}
	}

	public void setProducts(List<Payment> products) {
		this.payments = products;
	}
}
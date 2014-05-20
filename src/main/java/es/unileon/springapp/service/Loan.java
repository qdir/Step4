package es.unileon.springapp.service;

import java.util.List;

import es.unileon.springapp.domain.Payment;

public class Loan implements FinancialProduct {

	private static final long serialVersionUID = 1L;

	private List<Payment> payments;
	private int delayComissionPercentage;

	public void delayPayment(String date) {
		boolean stopPlease = false;
		int index = 0;
		Payment payment = null;

		if (payments != null) {
			while (!stopPlease && index < payments.size() - 1) {
				payment = payments.get(index);

				if (payment.getDate().compareTo(date) == 0 && !payment.isPaid()) {
					double newFeeValue = payment.getFee().doubleValue()
							* (100 + delayComissionPercentage) / 100;
					payment.setFee(newFeeValue);
					stopPlease = true;
				} else {
					index++;
				}

			}
		}

	}

	public int getDelayComissionPercentage() {
		return delayComissionPercentage;
	}

	public void setDelayComissionPercentage(int delayComissionPercentage) {
		this.delayComissionPercentage = delayComissionPercentage;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> products) {
		this.payments = products;
	}
}
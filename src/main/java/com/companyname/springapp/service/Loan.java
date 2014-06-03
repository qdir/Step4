package com.companyname.springapp.service;

import java.util.List;

//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;



import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;

import org.springframework.stereotype.Component;

import com.companyname.springapp.domain.Payment;
import com.companyname.springapp.repository.PaymentDao;

@Component
//@Entity
//@Table(name="loan")
public class Loan implements FinancialProduct {

	@Autowired
	private PaymentDao paymentDao;

	
	
	private static final long serialVersionUID = 1L;

//	@Id @Column(name="identifier")
	private String identifier;
	private List<Payment> payments;
//	@Column(name="delaycomission")
	private int delayComissionPercentage;
	
//	@ManyToOne(cascade = CascadeType.ALL)
	

	public void delayPayment(String date) {
		payments = paymentDao.getPaymentsList();
		boolean stopPlease = false;
		int index = 0;
		Payment payment = null;

		if (payments != null) {
			while (!stopPlease && index < payments.size() - 1) {
				payment = payments.get(index);
				
				if (payment.getExpiringdate().compareTo(date) == 0
						&& !payment.isPaid()) {
					double newFeeValue = payment.getFee().doubleValue()
							* (100 + 13) / 100;
					payment.setFee(newFeeValue);
					System.out.println("Metodo delay");
					paymentDao.savePayment(payment);
					stopPlease = true;
				} else {
					index++;
				}

			}
		}

	}

	public void setPaymentDao(PaymentDao paymenDao) {
		this.paymentDao = paymenDao;
	}

	public int getDelayComissionPercentage() {
		return delayComissionPercentage;
	}

	public void setDelayComissionPercentage(int delayComissionPercentage) {
		this.delayComissionPercentage = delayComissionPercentage;
	}

	public List<Payment> getPayments() {
		return paymentDao.getPaymentsList();
	}

	public void setPayments(List<Payment> products) {
		this.payments = products;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

}
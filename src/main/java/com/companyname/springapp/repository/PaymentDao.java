package com.companyname.springapp.repository;

import java.util.List;

import com.companyname.springapp.domain.Payment;

public interface PaymentDao {

    public List<Payment> getPaymentsList();

    public void savePayment(Payment payment);

}
package com.companyname.springapp.service;


import java.io.Serializable;
import java.util.List;

import com.companyname.springapp.domain.Payment;



public interface FinancialProduct extends Serializable {

    public void delayPayment(String date);
    
    public List<Payment> getPayments();

}
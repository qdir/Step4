package es.unileon.springapp.service;


import java.io.Serializable;
import java.util.List;

import es.unileon.springapp.domain.Payment;

public interface FinancialProduct extends Serializable {

    public void increasePrice(int percentage);
    
    public List<Payment> getPayments();

}
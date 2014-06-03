package com.companyname.springapp.web;

import static org.junit.Assert.*;


import org.junit.Test;

import com.companyname.springapp.service.*;

public class PaymentDelayFormControllerTests {

	@Test
	public void testSetAndGetLoan() throws Exception {
		PaymentDelayFormController paymentDelayController = new PaymentDelayFormController();
		assertNull(paymentDelayController.getLoan());
		paymentDelayController.setLoan(new Loan());
		assertNotNull(paymentDelayController.getLoan());

	}
}
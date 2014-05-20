package es.unileon.springapp.web;

import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.springapp.service.Loan;

public class PaymentDelayFormControllerTests {

	@Test
	public void testSetAndGetLoan() throws Exception {
		PaymentDelayFormController paymentDelayController = new PaymentDelayFormController();
		assertNull(paymentDelayController.getLoan());
		paymentDelayController.setLoan(new Loan());
		assertNotNull(paymentDelayController.getLoan());
		
		

	}
}
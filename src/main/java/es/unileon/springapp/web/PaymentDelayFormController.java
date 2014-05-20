package es.unileon.springapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.unileon.springapp.service.DelayPayments;
import es.unileon.springapp.service.FinancialProduct;

@Controller
@RequestMapping(value = "/delayPayments.htm")
public class PaymentDelayFormController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private FinancialProduct loan;


	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@Valid DelayPayments dateToDelay,
			BindingResult result) {
		if (result.hasErrors()) {
			return "delayPayments";
		}

		String date = dateToDelay.getDate();
		logger.info("Delaying payment of" + date + ".");

		loan.delayPayment(date);

		return "redirect:/hello.htm";
	}

	@RequestMapping(method = RequestMethod.GET)
	protected DelayPayments formBackingObject(HttpServletRequest request)
			throws ServletException {
		DelayPayments paymentDelay = new DelayPayments();
		//priceIncrease.setPercentage(15);
		return paymentDelay;
	}
	
	public FinancialProduct getLoan() {
		return loan;
	}

	public void setLoan(FinancialProduct loan) {
		this.loan = loan;
	}


//	public void setProductManager(FinancialProduct productManager) {
//		this.loan = productManager;
//	}
//
//	public FinancialProduct getProductManager() {
//		return loan;
//	}

}
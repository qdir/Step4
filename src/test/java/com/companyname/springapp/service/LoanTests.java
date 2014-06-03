package com.companyname.springapp.service;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.companyname.springapp.domain.Payment;

public class LoanTests {

	private Loan loan;

	private List<Payment> payments;

	private static int PRODUCT_COUNT = 2;

	private static Double FIRST_PAYMENT = new Double(300);
	private static String FIRST_DATE = "22/05/1992";

	private static Double SECOND_PAYMENT = new Double(33);
	private static String SECOND_DATE = "22/06/1992";

	private static int POSITIVE_PRICE_INCREASE = 10;

	@Before
	public void setUp() throws Exception {
		loan = new Loan();
		payments = new ArrayList<Payment>();

		// stub up a list of products
		Payment product = new Payment();
		product.setExpiringdate("22/05/1992");
		product.setFee(FIRST_PAYMENT);
		payments.add(product);

		product = new Payment();
		product.setExpiringdate("22/06/1992");
		product.setFee(SECOND_PAYMENT);
		payments.add(product);
		loan.setDelayComissionPercentage(POSITIVE_PRICE_INCREASE);

		loan.setPayments(payments);

	}

	@Test
	public void testGetProductsWithNoProducts() {
		loan = new Loan();
		assertNull(loan.getPayments());
	}

	@Test
	public void testGetPayments() {
		List<Payment> products = loan.getPayments();
		assertNotNull(products);
		assertEquals(PRODUCT_COUNT, loan.getPayments().size());

		Payment product = products.get(0);
		assertEquals(FIRST_DATE, product.getExpiringdate());
		assertEquals(FIRST_PAYMENT, product.getFee());

		product = products.get(1);
		assertEquals(SECOND_DATE, product.getExpiringdate());
		assertEquals(SECOND_PAYMENT, product.getFee());
	}

	@Test
	public void testIncreasePriceWithNullListOfProducts() {
		try {
			loan = new Loan();
			loan.delayPayment("22/05/1992");
		} catch (NullPointerException ex) {
			fail("Products list is null.");
		}
	}

	@Test
	public void testIncreasePriceWithEmptyListOfProducts() {
		try {
			loan = new Loan();
			loan.setPayments(new ArrayList<Payment>());
			loan.delayPayment("22/05/1992");
		} catch (Exception ex) {
			fail("Products list is empty.");
		}
	}

	@Test
	public void testDelayPaymentPropperly() {
		loan.delayPayment("22/05/1992");

		List<Payment> products = loan.getPayments();
		Payment product = products.get(0);
		assertEquals(330, product.getFee(), 0);

		product = products.get(1);
		assertEquals(33, product.getFee(), 0);
	}
}
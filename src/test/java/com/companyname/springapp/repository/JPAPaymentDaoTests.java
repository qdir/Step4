package com.companyname.springapp.repository;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.companyname.springapp.domain.Payment;

public class JPAPaymentDaoTests {

	private ApplicationContext context;
	private PaymentDao productDao;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(
				"classpath:test-context.xml");
		productDao = (PaymentDao) context.getBean("productDao");
	}

	@Test
	public void testGetProductList() {
		List<Payment> products = productDao.getPaymentsList();
		assertEquals(products.size(), 3, 0);
	}

	@Test
	public void testSaveProduct() {
		List<Payment> products = productDao.getPaymentsList();

		Payment p = products.get(0);
		Double price = p.getFee();
		p.setFee(200.12);
		productDao.savePayment(p);

		List<Payment> updatedProducts = productDao.getPaymentsList();
		Payment p2 = updatedProducts.get(0);
		assertEquals(p2.getFee(), 200.12, 0);

		p2.setFee(price);
		productDao.savePayment(p2);
	}
}
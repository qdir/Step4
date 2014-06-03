package com.companyname.springapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.companyname.springapp.domain.Payment;

@Repository(value = "productDao")
public class JPAPaymentDao implements PaymentDao {

	private EntityManager em = null;

	/*
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Payment> getPaymentsList() {
		return em.createQuery("select p from Payment p order by p.expiringdate")
		// select * from payment order by expiringdate;
		// "select p from payment p order by p.identifier"
				.getResultList();
	}

	@Transactional(readOnly = false)
	public void savePayment(Payment payment) {
		
		em.merge(payment);
	}

}
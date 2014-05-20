package es.unileon.springapp.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaymentTests {

    private Payment payment;

    @Before
    public void setUp() throws Exception {
        payment = new Payment();
    }

    @Test
    public void testSetAndGetDate() {
        String date = "22/05/1992";
        assertNull(payment.getDate());
        payment.setDate(date);
        assertEquals(date, payment.getDate());
    }

    @Test
    public void testSetAndGetPrice() {
        double money = 333.33;
        assertEquals(0, 0, 0);    
        payment.setFee(money);
        assertEquals(money, payment.getFee(), 0);
    }

}
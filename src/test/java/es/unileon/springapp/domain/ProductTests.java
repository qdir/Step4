package es.unileon.springapp.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductTests {

    private Payment product;

    @Before
    public void setUp() throws Exception {
        product = new Payment();
    }

    @Test
    public void testSetAndGetDescription() {
        String testDescription = "aDescription";
        assertNull(product.getDate());
        product.setDate(testDescription);
        assertEquals(testDescription, product.getDate());
    }

    @Test
    public void testSetAndGetPrice() {
        double testPrice = 100.00;
        assertEquals(0, 0, 0);    
        product.setFee(testPrice);
        assertEquals(testPrice, product.getFee(), 0);
    }

}
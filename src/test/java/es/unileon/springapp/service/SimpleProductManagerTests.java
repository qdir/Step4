package es.unileon.springapp.service;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.springapp.domain.Payment;

public class SimpleProductManagerTests {

    private Loan productManager;
    
    private List<Payment> products;
    
    private static int PRODUCT_COUNT = 2;
    
    private static Double CHAIR_PRICE = new Double(20.50);
    private static String CHAIR_DESCRIPTION = "Chair";
    
    private static String TABLE_DESCRIPTION = "Table";
    private static Double TABLE_PRICE = new Double(150.10); 
    
    private static int POSITIVE_PRICE_INCREASE = 10; 
    
    @Before
    public void setUp() throws Exception {
        productManager = new Loan();
        products = new ArrayList<Payment>();
        
        // stub up a list of products
        Payment product = new Payment();
        product.setDate("Chair");
        product.setFee(CHAIR_PRICE);
        products.add(product);
        
        product = new Payment();
        product.setDate("Table");
        product.setFee(TABLE_PRICE);
        products.add(product);
        
        productManager.setProducts(products);

    }

    @Test
    public void testGetProductsWithNoProducts() {
        productManager = new Loan();
        assertNull(productManager.getPayments());
    }

    @Test
    public void testGetProducts() {
        List<Payment> products = productManager.getPayments();
        assertNotNull(products);        
        assertEquals(PRODUCT_COUNT, productManager.getPayments().size());
    
        Payment product = products.get(0);
        assertEquals(CHAIR_DESCRIPTION, product.getDate());
        assertEquals(CHAIR_PRICE, product.getFee());
        
        product = products.get(1);
        assertEquals(TABLE_DESCRIPTION, product.getDate());
        assertEquals(TABLE_PRICE, product.getFee());      
    }
    
    @Test
    public void testIncreasePriceWithNullListOfProducts() {
        try {
            productManager = new Loan();
            productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        }
        catch(NullPointerException ex) {
            fail("Products list is null.");
        }
    }

    @Test
    public void testIncreasePriceWithEmptyListOfProducts() {
        try {
            productManager = new Loan();
            productManager.setProducts(new ArrayList<Payment>());
            productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        }
        catch(Exception ex) {
            fail("Products list is empty.");
        }           
    }
    
    @Test
    public void testIncreasePriceWithPositivePercentage() {
        productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        double expectedChairPriceWithIncrease = 22.55;
        double expectedTablePriceWithIncrease = 165.11;
        
        List<Payment> products = productManager.getPayments();      
        Payment product = products.get(0);
        assertEquals(expectedChairPriceWithIncrease, product.getFee(), 0);
        
        product = products.get(1);      
        assertEquals(expectedTablePriceWithIncrease, product.getFee(), 0);  
}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctioneerclient;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NesciO
 */
public class SaltyPasswordTest {
    
    SaltyPassword sp;
    
    public SaltyPasswordTest() { 
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {       
        sp = new SaltyPassword();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSecurePassword method, of class SaltyPassword.
     */
    @Test
    public void testGetSecurePassword() {
        String password = "hoi";
        byte[] salt = sp.getSalt();
        assertTrue(sp.getSecurePassword(password, salt).equals(sp.getSecurePassword(password, salt)));
        assertFalse(sp.getSecurePassword(password, salt).equals(sp.getSecurePassword(password, sp.getSalt())));
        assertFalse(sp.getSecurePassword("doei", salt).equals(sp.getSecurePassword(password, salt)));
    }

    /**
     * Test of getSalt method, of class SaltyPassword.
     */
    @Test
    public void testGetSalt() {
        assertTrue(sp.getSalt() instanceof byte[] );
    }
    
}

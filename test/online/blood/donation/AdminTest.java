/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.blood.donation;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Billy
 */
public class AdminTest {

    private Admin a1;
    private String testUsername;
    private String testPassword;
    private String testName;
    private String testIC;
    private String testPhoneNo;
    private boolean testIsActive;

    public AdminTest() {
    }

    @Before
    public void setUp() {
        testUsername = "billy";
        testPassword = "billy123";
        testName = "siew meng";
        testIC = "010211100385";
        testPhoneNo = "0165928333";
        testIsActive = true;
        
        a1 = new Admin(testUsername, testPassword, testName, testIC, testPhoneNo, testIsActive);
    }

    /**
     * Test of getUsername method, of class Admin.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername matches with expected value");
        assertEquals(testUsername, a1.getUsername());
    }

    /**
     * Test of getPassword method, of class Admin.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword matches with expected value");
        assertEquals(testPassword, a1.getPassword());
    }

    

    /**
     * Test of getName method, of class Admin.
     */
    @Test
    public void testGetName() {
        System.out.println("getName matches with expected value");
        assertEquals(testName, a1.getName());
    }

 

    /**
     * Test of getIdentityCard method, of class Admin.
     */
    @Test
    public void testGetIdentityCard() {
        System.out.println("getIdentityCard matches with expected value");
        assertEquals(testIC, a1.getIdentityCard());
    }


    /**
     * Test of getPhoneNumber method, of class Admin.
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber matches with expected value");
        assertEquals(testPhoneNo, a1.getPhoneNumber());
    }

    /**
     * Test of isIsActive method, of class Admin.
     */
    @Test
    public void testIsIsActive() {
        System.out.println("isIsActive matches with expected value");
        assertEquals(testIsActive, a1.isIsActive());
    }

  

}

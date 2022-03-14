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
public class UserTest {

    private String testUsername;
    private String testPassword;
    private String testName;
    private String testIC;
    private String testPhoneNo;
    private String testBloodType;
    private User u1;

    public UserTest() {
    }

    @Before
    public void setUp() {
        testUsername = "boon";
        testPassword = "boon123";
        testName = "boon seong";
        testIC = "010095689125";
        testPhoneNo = "0156749666";
        testBloodType = "O";

        u1 = new User(testUsername, testPassword, testName, testIC, testPhoneNo, testBloodType);
    }


    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername matches with expected value");
        assertEquals(testUsername, u1.getUsername());
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword matches with expected value");
        assertEquals(testPassword, u1.getPassword());
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName matches with expected value");
        assertEquals(testName, u1.getName());
    }


    /**
     * Test of getIdentityCard method, of class User.
     */
    @Test
    public void testGetIdentityCard() {
        System.out.println("getIdentityCard matches with expected value");
        assertEquals(testIC, u1.getIdentityCard());
    }


    /**
     * Test of getPhoneNumber method, of class User.
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber matches with expected value");
        assertEquals(testPhoneNo, u1.getPhoneNumber());
    }

    /**
     * Test of getBloodType method, of class User.
     */
    @Test
    public void testGetBloodType() {
        System.out.println("getBloodType matches with expected value");
        assertEquals(testBloodType, u1.getBloodType());
    }


}

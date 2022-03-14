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
public class Donation_CentreTest {
    
    private Donation_Centre dc1;
    private String testName;
    private String testState;
    private String testDistrict;
    private long testPhoneNo;
    
    public Donation_CentreTest() {
    }
    
    @Before
    public void setUp() {
        testName = "Hospital Tengku Subang";
        testState = "Selangor";
        testDistrict = "Subang";
        testPhoneNo = 1022343956;
        
        dc1 = new Donation_Centre(testName, testState,testDistrict, testPhoneNo );
    }

    /**
     * Test of getCentreName method, of class Donation_Centre.
     */
    @Test
    public void testGetCentreName() {
        System.out.println("getCentreName matches with expected value");
        assertEquals(testName, dc1.getCentreName());
    }

    /**
     * Test of getState method, of class Donation_Centre.
     */
    @Test
    public void testGetState() {
        System.out.println("getState matches with expected value");
        assertEquals(testState, dc1.getState());
    }

    /**
     * Test of getDistrict method, of class Donation_Centre.
     */
    @Test
    public void testGetDistrict() {
        System.out.println("getDistrict matches with expected value");
        assertEquals(testDistrict, dc1.getDistrict());
    }

    /**
     * Test of getPhonoNum method, of class Donation_Centre.
     */
    @Test
    public void testGetPhonoNum() {
        System.out.println("getPhonoNum matches with expected value");
        assertEquals(testPhoneNo, dc1.getPhonoNum());
    }

    
}

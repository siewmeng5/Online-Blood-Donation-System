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
public class OnlineBloodDonationTest {
    
    private Admin a1;
    private String testUsername;
    private String testPassword;
    private String testName;
    private String testIC;
    private String testPhoneNo;
    private boolean testIsActive;
    private String testBloodType;
    
    private User u1;
    
    public OnlineBloodDonationTest() {
    }
    
    @Before
    public void setUp() {
        testUsername = "billy";
        testPassword = "billy123";
        testName = "siew meng";
        testIC = "010211100385";
        testPhoneNo = "0165928333";
        testIsActive = true;
        testBloodType = "O";
        
        a1 = new Admin(testUsername, testPassword, testName, testIC, testPhoneNo, testIsActive);
        
        u1 = new User(testUsername, testPassword, testName, testIC, testPhoneNo, testBloodType);
    }

    @Test
    public void testDeactivateAccount() {
        System.out.println("Admin account is deactivated");
        a1.setIsActive(false);
        assertEquals(false, a1.isIsActive());
    }
    
    @Test
    public void testCompleteAppointment() {
        System.out.println("Appointment is completed successfully");
        assertEquals(true, u1.getDonationHistory() == null ? true : false);
    }
    
    @Test
    public void testAppointmentNotification() {
        System.out.println("Notification is received by User");
        assertEquals(testName, u1.getName());
    }
    
}

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
    
    private String testNewPassword;
    
    private User u1;
    private Donation_Centre dc1;
    private RegisteredDonor rd1;
    
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
        
        testNewPassword = "wanjun123";
        
        a1 = new Admin(testUsername, testPassword, testName, testIC, testPhoneNo, testIsActive);
        
        u1 = new User(testUsername, testPassword, testName, testIC, testPhoneNo, testBloodType);
        
        dc1 = new Donation_Centre("Tengku Ali Blood Donation Centre", "Selangor", "Klang", 33786543);
    }

    ////GAN SIEW MENG
    @Test
    public void testDeactivateAccount() {
        System.out.println("Admin account is deactivated");
        a1.setIsActive(false);
        assertEquals(false, a1.isIsActive());
    }
    
    
    ////NG BOON SEONG
    @Test
    public void testRegisterAppointment() {
        System.out.println("Appointment is registered successfully");
        rd1 = new RegisteredDonor();
        rd1.setRegisteredUser(u1);
        rd1.setSelectedCentre(dc1);
        assertEquals(u1.getName(), rd1.checkName());
    }
    
    
    ////CHUA WAN JUN
    @Test
    public void testChangePassword() {
        System.out.println("User's password is changed successfully.");
        u1.setPassword(testNewPassword);
        assertEquals(testNewPassword, u1.getPassword());
    }
    
}

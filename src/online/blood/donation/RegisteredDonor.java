/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.blood.donation;

/**
 *
 * @author Boon
 */
public class RegisteredDonor {

    private User registeredDonor;
    private Donation_Centre selectedCentre;
    
    public RegisteredDonor() {
    }

    public RegisteredDonor(User registeredUser, Donation_Centre selectedCentre) {
        this.registeredDonor = registeredUser;
        this.selectedCentre = selectedCentre;
    }

    public User getRegisteredUser() {
        return registeredDonor;
    }

    public void setRegisteredUser(User registeredUser) {
        this.registeredDonor = registeredUser;
    }

    public Donation_Centre getSelectedCentre() {
        return selectedCentre;
    }

    public void setSelectedCentre(Donation_Centre selectedCentre) {
        this.selectedCentre = selectedCentre;
    }

    @Override
    public String toString() {
        return "\nDonor Name:" + registeredDonor.getName() + "\n" + "IC Number:" + registeredDonor.getIdentityCard() + "\n" + selectedCentre + "\n";
    }
    
    public String cancelToString(){
        return registeredDonor.getName() + "\n" + selectedCentre.getCentreName();
    }
}

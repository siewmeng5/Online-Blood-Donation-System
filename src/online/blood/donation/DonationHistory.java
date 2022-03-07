/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.blood.donation;

import java.time.LocalDate;

/**
 *
 * @author Boon
 */
public class DonationHistory {

    private Donation_Centre selectedCentre;
    private LocalDate donationDate;

    public DonationHistory() {
    }

    public DonationHistory(Donation_Centre selectedCentre, LocalDate donationDate) {
        this.selectedCentre = selectedCentre;
        this.donationDate = donationDate;
    }

    public Donation_Centre getSelectedCentre() {
        return selectedCentre;
    }

    public void setSelectedCentre(Donation_Centre selectedCentre) {
        this.selectedCentre = selectedCentre;
    }

    public LocalDate getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    @Override
    public String toString() {
        return "DonationHistory{" + "selectedCentre=" + selectedCentre + ", donationDate=" + donationDate + '}';
    }

}

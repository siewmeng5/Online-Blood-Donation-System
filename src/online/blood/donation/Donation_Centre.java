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
public class Donation_Centre {

    private String centreName;
    private String state;
    private String district;
    private long phonoNum;

    public Donation_Centre() {
    }

    public Donation_Centre(String centreName, String state, String district, long phonoNum) {
        this.centreName = centreName;
        this.state = state;
        this.district = district;
        this.phonoNum = phonoNum;
    }

    public String getCentreName() {
        return centreName;
    }

    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public long getPhonoNum() {
        return phonoNum;
    }

    public void setPhonoNum(long phonoNum) {
        this.phonoNum = phonoNum;
    }

    @Override
    public String toString() {
        return "Centre Name:" + centreName + "\n" + "State:" + state + "\n" + "District:" + district + "\n" + "Phone Number:" + phonoNum;
    }

}

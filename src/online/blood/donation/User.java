/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.blood.donation;

/**
 *
 * @author Billy
 */
public class User {

    private String username;
    private String password;
    private String name;
    private String identityCard;
    private String phoneNumber;
    private String bloodType;

    public User(String username, String password, String name, String identityCard, String phoneNumber, String bloodType) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.identityCard = identityCard;
        this.phoneNumber = phoneNumber;
        this.bloodType = bloodType;
    }

    public void setUserName(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    @Override
    public String toString() {
        return String.format("%-22s %-25s %-26s %-25s", name, identityCard, phoneNumber, bloodType);
    }

}

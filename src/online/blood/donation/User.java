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
    private long identityCard;
    private long phoneNumber;
    private char bloodType;

    public User(String username, String password, String name, long identityCard, long phoneNumber, char bloodType) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.identityCard = identityCard;
        this.phoneNumber = phoneNumber;
        this.bloodType = bloodType;
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

    public long getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(long identityCard) {
        this.identityCard = identityCard;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public char getBloodType() {
        return bloodType;
    }

    public void setBloodType(char bloodType) {
        this.bloodType = bloodType;
    }
    
    
    
}

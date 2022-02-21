
package online.blood.donation;

/**
 *
 * @author Billy
 */
public class Admin {
    private String username;
    private String password;
    private String name;
    private String identityCard;
    private String phoneNumber;

    public Admin(String username, String password, String name, String identityCard, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.identityCard = identityCard;
        this.phoneNumber = phoneNumber;
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
}

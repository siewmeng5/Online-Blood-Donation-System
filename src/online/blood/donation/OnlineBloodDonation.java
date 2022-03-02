package online.blood.donation;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnlineBloodDonation {

    static Scanner scan = new Scanner(System.in);

    static ArrayList<User> userAccounts = new ArrayList<User>();
    static ArrayList<Admin> adminAccounts = new ArrayList<Admin>();

    static ArrayList<RegisteredDonor> registeredUsers = new ArrayList<RegisteredDonor>();
    static ArrayList<Donation_Centre> donationCentres = new ArrayList<Donation_Centre>();

    static User currentUser;
    static Admin currentAdmin;

    /////////////GENERAL////////////////////////////////////////////////
    public static void main(String[] args) {

        initialiseValues();

        int userChoice = 1;

        while (userChoice != 0) {
            clearConsole();

            System.out.println("=============================");
            System.out.println("||  ONLINE BLOOD DONATION  ||");
            System.out.println("||     SAFELIFE SOCIETY    ||");
            System.out.println("=============================");

            System.out.println("1. Create account (Donor)");
            System.out.println("2. Login (Donor)");
            System.out.println("3. Login (Admin)");
            System.out.println("0. Exit system\n");
            System.out.print("Enter choice\n>");
            userChoice = scan.nextInt();

            switch (userChoice) {
                case 0:
                    System.out.println("Thank you for using this system!");
                    break;
                case 1:
                    createAccount();
                    break;
                case 2:
                    boolean proceed = loginUser();

                    int userChoice2 = 1;
                    if (proceed) {
                        while (userChoice2 > 0) {
                            clearConsole();
                            displayUserMenu();

                            userChoice2 = scan.nextInt();
                            scan.nextLine();

                            switch (userChoice2) {
                                case 0:
                                    System.out.println("Thank you for using this system!");
                                    System.exit(0);
                                case 1:
                                    //Boon
                                    registerAppointment();
                                    break;
                                case 2:
                                    //Wan Jun
                                    cancelAppointment();
                                    break;
                                case 3:
                                    //Wan Jun
                                    profile();
                                    break;
                                case 4:
                                    //Wan Jun
                                    editProfile();
                                    break;
                                case 5:
                                    //Wan Jun
                                    changePsw();
                                    break;
                                case 6:
                                    System.out.println("Logging out..");
                                    userChoice2 = 0;
                                    currentUser = null;
                                    systemPause();
                                    break;
                            }
                        }
                    }

                    break;
                case 3:
                    boolean proceedForAdmin = loginAdmin();

                    int userChoice3 = 1;
                    if (proceedForAdmin) {
                        while (userChoice3 > 0) {
                            clearConsole();
                            displayAdminMenu();

                            userChoice3 = scan.nextInt();
                            scan.nextLine();

                            switch (userChoice3) {
                                case 1:
                                    changePasswordAdmin();
                                    break;
                                case 2:
                                    //Boon
                                    viewAllUsers();
                                    break;
                                case 99:
                                    System.out.println("Logging out..");
                                    userChoice3 = 0;
                                    currentAdmin = null;
                                    systemPause();
                                    break;
                                default:
                                    System.out.println("Wrong input entered, please try again!");
                                    systemPause();
                                    break;
                            }
                        }
                    }

                    break;
                default:
                    System.out.println("Error input, please try again.");
                    systemPause();
            }
        }

    }

    private static void initialiseValues() {
        Donation_Centre centre1 = new Donation_Centre("Tengku Ali Blood Donation Centre", "Selangor", "Klang", 33786543);
        Donation_Centre centre2 = new Donation_Centre("Tengku Abu Blood Donation Centre", "Selangor", "Gombak", 33786243);
        Donation_Centre centre3 = new Donation_Centre("Subang Blood Donation Centre", "Selangor", "Petaling", 33566543);
        Donation_Centre centre4 = new Donation_Centre("1Malaysia Blood Donation Centre", "Selangor", "Petaling", 33786543);
        Donation_Centre centre5 = new Donation_Centre("Sultan Mohd Blood Donation Centre", "Selangor", "Kuala Selangor", 33098543);
        donationCentres.add(centre1);
        donationCentres.add(centre2);
        donationCentres.add(centre3);
        donationCentres.add(centre4);
        donationCentres.add(centre5);

        User user1 = new User("billy", "billy", "gan siew meng", "011129100611", "0122229112", "O");
        User user2 = new User("boon", "boon", "ng boon seong", "010635909089", "0166454590", "A");
        User user3 = new User("wanjun", "wanjun", "wan jun", "011031280764", "0112132456", "AB");
        userAccounts.add(user1);
        userAccounts.add(user2);
        userAccounts.add(user3);

        RegisteredDonor registeredAppointment1 = new RegisteredDonor(user1, centre3);
        registeredUsers.add(registeredAppointment1);

        Admin admin1 = new Admin("billy", "billy", "gan siew meng", "011129100611", "0122229112");
        adminAccounts.add(admin1);
    }

    private static void displayUserMenu() {
        System.out.println("=============================");
        System.out.println("||  ONLINE BLOOD DONATION  ||");
        System.out.println("||     SAFELIFE SOCIETY    ||");
        System.out.println("||     (DONOR MAIN MENU)   ||");
        System.out.println("=============================");

        System.out.println("1. Register Appointment");
        System.out.println("2. Cancel Appointment");
        System.out.println("3. View Profile");
        System.out.println("4. Editing Profile");
        System.out.println("5. Change Password");
        System.out.println("6. Logout");
        System.out.println("0. Exit system\n");
        System.out.print("Enter your choice\n>");
    }

    private static void displayAdminMenu() {
        System.out.println("=============================");
        System.out.println("||  ONLINE BLOOD DONATION  ||");
        System.out.println("||     SAFELIFE SOCIETY    ||");
        System.out.println("||     (ADMIN MAIN MENU)   ||");
        System.out.println("=============================");

        System.out.println("1. Change Password");
        System.out.println("2. View All User Accounts");
        System.out.println("99. Logout");
        System.out.print("Enter your choice\n>");
    }

    private static void systemPause() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(OnlineBloodDonation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

    }
    /////////////END OF GENERAL/////////////////////////////////////////

    /////////////SIEW MENG//////////////////////////////////////////////
    private static void createAccount() {
        clearConsole();
        scan.nextLine();

        String username;
        String password;
        String name;
        String identityCard;
        String phoneNumber;
        String bloodType;

        System.out.print("Enter new username\n>");
        username = scan.nextLine();

        for (int i = 0; i < userAccounts.size(); i++) {
            if (userAccounts.get(i).getUsername().equals(username)) {
                System.out.print("Sorry. Username taken. Please choose another username\n>");
                username = scan.nextLine();
                i = -1;
            }
        }

        System.out.print("Enter new password\n>");
        password = scan.nextLine();

        System.out.print("Enter your fullname as per IC\n>");
        name = scan.nextLine();

        System.out.print("Enter your IC number (without '-')\n>");
        identityCard = scan.nextLine();

        System.out.print("Enter your phone number (without '-')\n>");
        phoneNumber = scan.nextLine();

        System.out.print("Enter your blood type (A/B/AB/O)\n>");
        bloodType = scan.nextLine();

        User temp = new User(username, password, name, identityCard, phoneNumber, bloodType);
        userAccounts.add(temp);

        System.out.println("Account created successfully...");

        systemPause();

    }

    private static boolean loginUser() {
        clearConsole();
        scan.nextLine();

        String username;
        String password;

        boolean proceed = false;

        int foundIndex = -1;

        System.out.print("Enter your username\n>");
        username = scan.nextLine();

        for (int i = 0; i < userAccounts.size(); i++) {
            if (userAccounts.get(i).getUsername().equals(username)) {
                proceed = true;
                foundIndex = i;
                break;
            }
        }

        if (proceed) {
            System.out.print("Enter your password\n>");
            password = scan.nextLine();

            for (int i = 3; i > 0; i--) {
                if (userAccounts.get(foundIndex).getPassword().equals(password)) {
                    currentUser = userAccounts.get(foundIndex);
                    System.out.println("Welcome back, " + currentUser.getName() + " !");
                    systemPause();
                    return true;
                } else {
                    System.out.print("Wrong password. Please try again (" + i + " tries left)\n>");
                    password = scan.nextLine();
                }
            }

        } else {
            System.out.println("Username not found!");
        }

        System.out.println("Login Failed...");

        systemPause();

        return false;
    }

    private static boolean loginAdmin() {
        clearConsole();
        scan.nextLine();

        String username;
        String password;

        boolean proceed = false;

        int foundIndex = -1;

        System.out.print("Enter your username\n>");
        username = scan.nextLine();

        for (int i = 0; i < adminAccounts.size(); i++) {
            if (adminAccounts.get(i).getUsername().equals(username)) {
                proceed = true;
                foundIndex = i;
                break;
            }
        }

        if (proceed) {
            System.out.print("Enter your password\n>");
            password = scan.nextLine();

            for (int i = 3; i > 0; i--) {
                if (adminAccounts.get(foundIndex).getPassword().equals(password)) {
                    currentAdmin = adminAccounts.get(foundIndex);
                    System.out.println("Welcome back, " + currentAdmin.getName() + " !");
                    systemPause();
                    return true;
                } else {
                    System.out.print("Wrong password. Please try again (" + i + " tries left)\n>");
                    password = scan.nextLine();
                }
            }

        } else {
            System.out.println("Username not found!");
        }

        System.out.println("Login Failed...");

        systemPause();

        return false;
    }

    private static void changePasswordAdmin() {
        clearConsole();

        char confirm;
        String psw;
        System.out.println("Proceed to change password? (Y/N)");
        confirm = scan.next().charAt(0);

        if (Character.toUpperCase(confirm) == 'Y') {
            System.out.println("Your current password:\n" + currentAdmin.getPassword());
            scan.nextLine();
            System.out.println("Enter password to change :");
            psw = scan.nextLine();

            char confirmToChange;

            System.out.println("Confirm to change password to " + psw + "? (Y/N)");
            confirmToChange = scan.next().charAt(0);

            if (Character.toUpperCase(confirmToChange) == 'Y') {
                currentAdmin.setPassword(psw);
                System.out.println("Your password has been changed successfully!");
                systemPause();
            } else {
                System.out.println("Password changing has been cancelled.");
                systemPause();
            }

        } else {
            System.out.println("Your password remains the same!");
            systemPause();
            scan.nextLine();
        }
    }
    /////////////END OF SIEW MENG///////////////////////////////////////

    /////////////BOON SEONG/////////////////////////////////////////////
    private static void registerAppointment() {
        clearConsole();

        ArrayList<Donation_Centre> tempCentres = new ArrayList<Donation_Centre>();

        String userState;
        //String userDistrict;
        int indexNum;
        Donation_Centre temp = new Donation_Centre();

        System.out.print("Enter the state you live in\n>");
        userState = scan.nextLine();

//        System.out.print("Enter the district you living\n>");
//        userDistrict = scan.nextLine();
        for (int i = 0; i < donationCentres.size(); i++) {
            if (donationCentres.get(i).getState().equalsIgnoreCase(userState)) {
                temp = donationCentres.get(i);
                tempCentres.add(temp);
            }
        }
        if (!tempCentres.isEmpty()) {
            int index = 1;
            for (int i = 0; i < tempCentres.size(); i++) {
                System.out.print("\nNo. " + index + "\n");
                System.out.println(tempCentres.get(i).toString());
                index++;
            }
            System.out.print("\nEnter the index number of the availabe centre to register for an appointment\n>");
            indexNum = scan.nextInt();

            RegisteredDonor newRegistered = new RegisteredDonor(currentUser, tempCentres.get(indexNum - 1));
            registeredUsers.add(newRegistered);
            System.out.println("\nRegistration successful. An apointment will be sent to you soon!");

            scan.nextLine();
            systemPause();

        } else {
            System.out.println("No Blood Donation Centre is found at the state you live in.");
            systemPause();
        }

    }

    private static void viewAllUsers() {
        clearConsole();

        System.out.println("====================================================================================");
        System.out.println("NAME \t\t\tIC NUMBER\t\tPHONE NUMBER\t\tBLOOD TYPE");
        System.out.println("====================================================================================");
        for (int i = 0; i < userAccounts.size(); i++) {
            System.out.println(userAccounts.get(i).toString());
        }
        scan.nextLine();
    }
    /////////////END OF BOON SEONG//////////////////////////////////////

    /////////////WAN JUN////////////////////////////////////////////////
    private static void profile() {
        System.out.println("Your Personal Information");
        System.out.println("=========================");
        System.out.println("Name as NRIC: " + currentUser.getName());
        System.out.println("NRIC: " + currentUser.getIdentityCard());
        System.out.println("Phone Number: " + currentUser.getPhoneNumber());
        System.out.println("Blood Type: " + currentUser.getBloodType());
        System.out.println("\n");
        scan.nextLine();
    }

    private static void editProfile() {
        clearConsole();

        int selection = 0;

        profile();

        System.out.println("1. Name");
        System.out.println("2. NRIC");
        System.out.println("3. Phone Number");
        System.out.println("4. Blood Type");
        System.out.println("5. Exit");

        System.out.println("Enter you selection to edit > ");
        selection = scan.nextInt();
        
        switch (selection) {
            case 1:
                String name;
                scan.nextLine();
                System.out.println("To Edit...");
                System.out.println("Current Name : " + currentUser.getName());
                System.out.println("Enter new name as NRIC:");
                name = scan.nextLine();
                currentUser.setName(name);
                System.out.println("Name edited successfully!");
                break;
            case 2:
                String icNum;
                scan.nextLine();
                System.out.println("To Edit...");
                System.out.println("Current NRIC : " + currentUser.getIdentityCard());
                do{
                System.out.println("Enter new NRIC:");
                icNum = scan.nextLine();
                if(icNum.length()!=12){
                    System.out.println("Invalid NRIC number. Please enter again.");
                }else{
                    currentUser.setIdentityCard(icNum);
                    System.out.println("NRIC edited successfully!");
                }
                }while(icNum.length()!= 12);
                break;
            case 3:
                String phone;
                scan.nextLine();
                System.out.println("To Edit...");
                System.out.println("Current Phone Number : " + currentUser.getPhoneNumber());
                do{
                System.out.println("Enter new Phone Number:");
                phone = scan.nextLine();
                if(phone.length()<10 || phone.length()>12){
                    System.out.println("Pelase enter phone number between 10 to 11 digit without dash.");                   
                }else{
                     currentUser.setPhoneNumber(phone);
                     System.out.println("Phone number edited successfully!");
                }
                }while(phone.length()<10 || phone.length()>12);
            
                break;
            case 4:
                String blood;
                String b1="A";
                String b2="B";
                String b3="O";
                String b4="AB";
                scan.nextLine();
                System.out.println("To Edit...");
                System.out.println("Current Blood Type: " + currentUser.getBloodType());
                do{
                System.out.println("Enter new Blood Type:");
                blood = scan.nextLine();
                if(blood.equals(b1)||blood.equals(b2)||blood.equals(b3)||blood.equals(b4)){
                    currentUser.setBloodType(blood);
                    System.out.println("Blood type edited successfully!");
                    break;
                }else{
                    System.out.println("Please enter a valid blood type!");
                }}while(blood!=b1||blood!=b2||blood!=b3||blood!=b4);
//                                             
                break;
            case 5:
                break;

        }
    }

    private static void changePsw() {

        int confirm;
        String psw1, psw2;
        System.out.println("Do you sure to change your password?(1=Y/2=N)");
        confirm = scan.nextInt();
        if (confirm == 1) {
            System.out.println("Your current password:\n" + currentUser.getPassword());
            scan.nextLine();
            do {
                System.out.println("Enter password to change :");
                psw1 = scan.nextLine();
                System.out.println("Confirm password :");
                psw2 = scan.nextLine();
                if (psw1.equals(psw2)) {
                    currentUser.setPassword(psw1);
                    System.out.println("Your password has been changd successfully!");
                    systemPause();
                    break;
                } else {
                    System.out.println("Please enter new password again.");
                }
            } while (psw1 != psw2);

        } else {
            System.out.println("Your password still remains the same!");
            systemPause();
            scan.nextLine();
        }
    }

    private static void cancelAppointment() {
        int cancel;
        int x = 0;
        //scan.nextLine();

        if (registeredUsers.size() != 0) {
            for (int i = 0; i < registeredUsers.size(); i++) {
                RegisteredDonor users = registeredUsers.get(i);
                if (users.checkName() == currentUser.getName()) {
                    System.out.println("Your appointment ID is 100" + (i) + ". \n" + users.cancelToString());
                    System.out.println("============================================");
                    x++;
                }
            }
            if (x > 0) {
                System.out.println("Enter appointment ID to cancel(0 to exit):");
                cancel = scan.nextInt();
                if (cancel > 0 && cancel <= registeredUsers.size() + 1000) {
                    registeredUsers.remove(cancel - 1000);
                    System.out.println("Appointment canceled...");
                    systemPause();
                } else {
                    System.out.println("No appointment has been canceled...");
                    systemPause();
                }
            } else {
                System.out.println("No appointment registered yet...");
                systemPause();
            }

        } else {
            System.out.println("No appointment registered yet...");
            systemPause();
        }
    }
    /////////////END OF WAN JUN/////////////////////////////////////////

}

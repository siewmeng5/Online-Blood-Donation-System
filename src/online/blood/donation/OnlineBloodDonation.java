package online.blood.donation;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnlineBloodDonation {

    static Scanner scan = new Scanner(System.in);

    static ArrayList<User> userAccounts = new ArrayList<User>();
    static ArrayList<RegisteredDonor> registeredUsers = new ArrayList<RegisteredDonor>();
    static ArrayList<Donation_Centre> donationCentres = new ArrayList<Donation_Centre>();

    static User currentUser;

    public static void main(String[] args) {
//        profile();
//        System.out.print("x");

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

        int userChoice = 1;
        int userChoice2 = 1;
        while (userChoice != 0) {
            clearConsole();

            System.out.println("=============================");
            System.out.println("||  ONLINE BLOOD DONATION  ||");
            System.out.println("||     SAFELIFE SOCIETY    ||");
            System.out.println("=============================");

            System.out.println("1. Create account");
            System.out.println("2. Login (User)");
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

                    if (proceed) {
                        while (userChoice2 > 0 && userChoice2 != 3) {
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
                                    profile();
                                    break;
                                case 3:
                                    //Wan Jun
                                    editProfile();
                                    break;
                                case 4:
                                    System.out.println("Logging out..");
                                    systemPause();
                                    break;
                            }
                        }

                        //@Wan Jun and @Boon, after user login successfully. You can call your functions here
                    }

//                    if (userChoice2 == 2){
//                        displayUserMenu();
//                        userChoice = 1;
//                        userChoice = scan.nextInt();
//                        scan.nextLine();
//                    }
                    break;

                default:
                    System.out.println("Error input, please try again.");
                    systemPause();
            }
        }

    }

    private static void displayUserMenu() {
        System.out.println("=============================");
        System.out.println("||  ONLINE BLOOD DONATION  ||");
        System.out.println("||     SAFELIFE SOCIETY    ||");
        System.out.println("||     (DONOR MAIN MENU)   ||");
        System.out.println("=============================");

        System.out.println("1. Register Appointment");
        System.out.println("2. View Profile");
        System.out.println("3. Editing Profile");
        System.out.println("4. Logout");
        System.out.println("0. Exit system\n");
        System.out.print("Enter choice\n>");
    }

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
            if (!(userAccounts.get(i).getUsername().equals(username)) && (i + 1) == userAccounts.size()) {
                System.out.print("Username not found!");
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
                    System.out.print("Wrong password. Please try again (" + i + " times left)\n>");
                    password = scan.nextLine();
                }
            }

        }

        System.out.println("Login Failed...");
        systemPause();

        return false;
    }

    private static void registerAppointment() {
        clearConsole();

        ArrayList<Donation_Centre> tempCentres = new ArrayList<Donation_Centre>();

        String userState;
        String userDistrict;
        int indexNum;
        Donation_Centre temp = new Donation_Centre();

        System.out.print("Enter the state you live in\n>");
        userState = scan.nextLine();

//        System.out.print("Enter the district you living\n>");
//        userDistrict = scan.nextLine();
        for (int i = 0; i < donationCentres.size(); i++) {
            if (donationCentres.get(i).getState().equals(userState)) {
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
            System.out.print("\nRegistered Successfully\n>");
            System.out.print(registeredUsers.toString());
            systemPause();

        } else {
            System.out.println("No Blood Donation Centre is found at the state you live in.");
        }

    }

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
                System.out.println("Enter new NRIC:");
                icNum = scan.nextLine();
                currentUser.setIdentityCard(icNum);
                System.out.println("NRIC edited successfully!");
                break;
            case 3:
                String phone;
                scan.nextLine();
                System.out.println("To Edit...");
                System.out.println("Current Phone Number : " + currentUser.getPhoneNumber());
                System.out.println("Enter new Phone Number:");
                phone = scan.nextLine();
                currentUser.setPhoneNumber(phone);
                System.out.println("Phone number edited successfully!");
                break;
            case 4:
                String blood;
                scan.nextLine();
                System.out.println("To Edit...");
                System.out.println("Current Blood Type: " + currentUser.getBloodType());
                System.out.println("Enter new Blood Type:");
                blood = scan.nextLine();
                currentUser.setBloodType(blood);
                System.out.println("Blood type edited successfully!");
                break;
            case 5:
                break;

        }
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

}

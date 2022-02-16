package online.blood.donation;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnlineBloodDonation {

    static Scanner scan = new Scanner(System.in);

    static ArrayList<User> userAccounts = new ArrayList<User>();
    
    static User currentUser;

    public static void main(String[] args) {

        int userChoice = 1;

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

                    if(proceed){
                        
                    //@Wan Jun and @Boon, after user login successfully. You can call your functions here
                    }
                    break;

                default:
                    System.out.println("Error input, please try again.");
                    systemPause();
            }
        }

    }
    
    private static void createAccount() {
        clearConsole();
        scan.nextLine();

        String username;
        String password;
        String name;
        long identityCard;
        long phoneNumber;
        char bloodType;

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
        identityCard = scan.nextLong();

        System.out.print("Enter your phone number (without '-')\n>");
        phoneNumber = scan.nextLong();

        System.out.print("Enter your blood type (A/B/AB/O)\n>");
        bloodType = scan.next().charAt(0);

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
                    System.out.println("Welcome back, " + currentUser.getName()+" !");
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

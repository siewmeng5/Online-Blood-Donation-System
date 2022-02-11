package online.blood.donation;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnlineBloodDonation {

    static Scanner scan = new Scanner(System.in);

    static ArrayList<User> userAccounts = new ArrayList<User>();

    public static void main(String[] args) {

        int userChoice = 1;

        while (userChoice != 0) {
            clearConsole();

            System.out.println("=============================");
            System.out.println("||  ONLINE BLOOD DONATION  ||");
            System.out.println("||     SAFELIFE SOCIETY    ||");
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
                    //createAccount();
                    break;
                case 2:
                    //boolean proceed = loginUser();
                    
                    //if(proceed){
                        //@Wan Jun @Boon, after user login successfully. You can call your functions here
                    //}

                    break;

                default:
                    System.out.println("Error input, please try again.");
                    systemPause();
            }
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
    }


}

package me.kyllian.netflixstatistix;

import com.sun.tools.jdeprscan.scan.Scan;
import me.kyllian.netflixstatistix.database.DatabaseHandler;
import me.kyllian.netflixstatistix.database.PasswordEncryptor;

import java.io.Reader;
import java.util.ResourceBundle;
import java.util.Scanner;

public class NetflixStatistix {

    public static void main(String[] args) {
        // Open registration/login prompt
        //
        // Once logged in, construct User object using the Registration data
        // if the user has been logged in, fetch data from the database.
        //
        // Open profiles screen
        // A profile will contain the watching data
        // There will be classes for series and films so we can create/remove series easily.

        /*try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("dbconfig");
            System.out.println(resourceBundle.getString("db.driver"));
        } catch (Exception exception) {
            exception.printStackTrace();
        }*/

        Scanner reader = new Scanner(System.in);
        //TODO: Make a GUI around this, check local data first to see if password is saved
        System.out.println("Please register!");
        System.out.print("Enter first name: ");
        String firstName = reader.nextLine();
        System.out.print("Enter last name: ");
        String lastName = reader.nextLine();
        System.out.print("Enter email: ");
        String email = reader.nextLine();
        System.out.print("Enter password: ");
        String password = PasswordEncryptor.encrypt(reader.nextLine());
        System.out.print("Enter repeat password: ");
        String repeatPassword = PasswordEncryptor.encrypt(reader.nextLine());
        System.out.print("Enter street name: ");
        String streetName = reader.nextLine();
        System.out.print("Enter number + addition: ");
        String number = reader.nextLine();
        System.out.print("Enter postal code: ");
        String postalCode = reader.nextLine();
        System.out.print("Enter day of birth: ");
        String day = reader.nextLine();
        System.out.print("Enter month of birth: ");
        String month = reader.nextLine();
        System.out.print("Enter year of birth: ");
        String year = reader.nextLine();


        new DatabaseHandler();
    }
}

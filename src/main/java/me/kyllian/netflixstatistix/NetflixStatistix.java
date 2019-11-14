package me.kyllian.netflixstatistix;

import javafx.application.Application;
import javafx.stage.Stage;
import me.kyllian.netflixstatistix.exceptions.InputInvalidException;
import me.kyllian.netflixstatistix.user.User;
import me.kyllian.netflixstatistix.user.UserBuilder;

import java.util.Scanner;

public class NetflixStatistix extends Application {

    public static void main(String[] args) {
        //launch(NetflixStatistix.class);
        boolean register = false;

        Scanner reader = new Scanner(System.in);
        if (register) {
            System.out.println("Please register!");
            System.out.print("Enter first name: ");
            String firstName = reader.nextLine();
            System.out.print("Enter last name: ");
            String lastName = reader.nextLine();
            System.out.print("Enter email: ");
            String email = reader.nextLine();
            System.out.print("Enter password: ");
            String password = reader.nextLine();
            System.out.print("Enter repeat password: ");
            String repeatPassword = reader.nextLine();
            System.out.print("Enter street name: ");
            String streetName = reader.nextLine();
            System.out.print("Enter number + addition: ");
            String number = reader.nextLine();
            System.out.print("Enter postal code: ");
            String postalCode = reader.nextLine();
            System.out.print("Enter residence : ");
            String residence = reader.nextLine();
            System.out.print("Enter day of birth: ");
            int day = Integer.parseInt(reader.nextLine());
            System.out.print("Enter month of birth: ");
            int month = Integer.parseInt(reader.nextLine());
            System.out.print("Enter year of birth: ");
            int year = Integer.parseInt(reader.nextLine());

            try {
                User user = new UserBuilder()
                        .withFirstName(firstName)
                        .withLastName(lastName)
                        .withEmail(email)
                        .withDate(day, month, year)
                        .withAdress(streetName, number, postalCode, residence)
                        .withPassword(password)
                        .checkRepeatPassword(repeatPassword)
                        .build();

                System.out.println("Input validated!");
            } catch (InputInvalidException IIE) {
                System.out.println(IIE.getFoundTypes());
            }
        } else {
            System.out.println("Please login!");
            System.out.print("email: ");
            String email = reader.nextLine();
            System.out.print("password: ");
            String password = reader.nextLine();
            try {
                User user = new UserBuilder()
                        .withEmail(email)
                        .withPassword(password)
                        .login();
            } catch (InputInvalidException IIE) {
                System.out.println(IIE.getFoundTypes());
            }
        }
        // Open registration/login prompt
        //
        // Once logged in, construct User object using the Registration data
        // if the user has been logged in, fetch data from the database.
        //
        // Open profiles screen
        // A profile will contain the watching data
        // There will be classes for series and films so we can create/remove series easily.

    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}

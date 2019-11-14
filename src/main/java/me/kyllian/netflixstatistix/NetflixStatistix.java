package me.kyllian.netflixstatistix;

import me.kyllian.netflixstatistix.exceptions.InputInvalidException;
import me.kyllian.netflixstatistix.user.User;
import me.kyllian.netflixstatistix.user.UserBuilder;

import java.util.Scanner;

public class NetflixStatistix {

    public static void main(String[] args) {
        boolean register = true;

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

                //TODO: change build method to send post request
                System.out.println("Input validated!");
                // TODO: Connect to database and upload user
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
        /*String response = new PostBuilder()
                .withIdentifier("login")
                .withAttribute("email", "kyllian007@gmail.com")
                .withAttribute("password", "password123!")
                .postAndGetResponse();
        System.out.println(response);
        JSONObject object = new JSONObject(response.replace("[", "").replace("]", ""));
        System.out.println(object.get("user_id"));*/
        // Open registration/login prompt
        //
        // Once logged in, construct User object using the Registration data
        // if the user has been logged in, fetch data from the database.
        //
        // Open profiles screen
        // A profile will contain the watching data
        // There will be classes for series and films so we can create/remove series easily.

        //TODO: Make a if (error) return console.error(error.message);
        //        console.log(results.affectedRows);GUI around this, check local data first to see if password is saved


        // Uer object create succesfdully
    }
}

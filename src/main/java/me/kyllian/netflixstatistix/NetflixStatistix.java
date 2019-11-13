package me.kyllian.netflixstatistix;

import me.kyllian.netflixstatistix.database.DatabaseConnection;
import me.kyllian.netflixstatistix.database.DatabaseHandler;
import me.kyllian.netflixstatistix.database.PasswordEncryptor;
import me.kyllian.netflixstatistix.exceptions.*;
import me.kyllian.netflixstatistix.user.User;
import me.kyllian.netflixstatistix.user.UserBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NetflixStatistix {

    public static void main(String[] args) {

        try {
            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost("http://localhost:8080");
            List<NameValuePair> params = new ArrayList<NameValuePair>(11);
            params.add(new BasicNameValuePair("identifier", "user"));
            params.add(new BasicNameValuePair("firstname", "Kyllian"));
            params.add(new BasicNameValuePair("lastname", "Warmerdam"));
            params.add(new BasicNameValuePair("password", "password123!"));
            params.add(new BasicNameValuePair("email", "kyllian007@gmail.com"));
            params.add(new BasicNameValuePair("street", "Reiendonk"));
            params.add(new BasicNameValuePair("number", "36"));
            params.add(new BasicNameValuePair("postalcode", "4824CD"));
            params.add(new BasicNameValuePair("residence", "Breda"));
            params.add(new BasicNameValuePair("birthdate", "28-05-2002"));
            params.add(new BasicNameValuePair("watchingprofiles", "null"));
            httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                    System.out.println(EntityUtils.toString(entity));
                    // do something useful
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        // Open registration/login prompt
        //
        // Once logged in, construct User object using the Registration data
        // if the user has been logged in, fetch data from the database.
        //
        // Open profiles screen
        // A profile will contain the watching data
        // There will be classes for series and films so we can create/remove series easily.

        //Scanner reader = new Scanner(System.in);
        //TODO: Make a GUI around this, check local data first to see if password is saved
        /*System.out.println("Please login!");
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
        }*/

        /*System.out.println("Please register!");
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
            new DatabaseConnection().connect().uploadUser(user).disconnect();
            System.out.println("Input validated!");
            // TODO: Connect to database and upload user
        } catch (InputInvalidException IIE) {
            System.out.println(IIE.getFoundTypes());
        } catch (SQLException SE) {
            SE.printStackTrace();
            System.out.println("Uploading failed");
        }*/
        // Uer object create succesfdully
    }
}

package me.kyllian.netflixstatistix;

import me.kyllian.netflixstatistix.database.DatabaseHandler;

import java.util.ResourceBundle;

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


        new DatabaseHandler();
    }
}

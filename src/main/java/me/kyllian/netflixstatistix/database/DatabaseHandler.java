package me.kyllian.netflixstatistix.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DatabaseHandler {

    public DatabaseHandler() {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("dbconfig");
            Class.forName(resourceBundle.getString("db.driver"));
            Connection con = DriverManager.getConnection(resourceBundle.getString("db.url"), resourceBundle.getString("db.username"), resourceBundle.getString("db.password"));
            Statement stmt = con.createStatement();
            //stmt.executeUpdate("CREATE TABLE TEST (NAME VARCHAR(10) NOT NULL )");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

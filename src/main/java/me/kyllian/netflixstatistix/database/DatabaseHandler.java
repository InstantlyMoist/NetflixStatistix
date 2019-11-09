package me.kyllian.netflixstatistix.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseHandler {

    public DatabaseHandler() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("", "", "");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE TEST (NAME VARCHAR(10) NOT NULL )");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        //TODO: Handle database connection
    }


}

package me.kyllian.netflixstatistix.database;

        import java.sql.*;
        import java.util.ResourceBundle;

public class DatabaseHandler {

    public static Connection getSQLConnection() {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("dbconfig");
            Class.forName(resourceBundle.getString("db.driver"));
            return DriverManager.getConnection(resourceBundle.getString("db.url"), resourceBundle.getString("db.username"), resourceBundle.getString("db.password"));

        } catch (ClassNotFoundException exception) {
            // TODO: Drivers not found, perhaps... try different ones?
        } catch (SQLException SE) {
            // TODO: Handle error if database is down (perhaps try again, or terminate process)
        }
        return null;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException SE) {
            // TODO: Perhaps wait for dataline to be free?
        }
    }
}

package me.kyllian.netflixstatistix.database;

import me.kyllian.netflixstatistix.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

    private Connection connection;

    public DatabaseConnection() {

    }

    public DatabaseConnection connect() {
        connection = DatabaseHandler.getSQLConnection();
        return this;
    }

    public DatabaseConnection uploadUser(User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(first_name, last_name, password, email, address, birth_date, watching_profiles)" +
                " values (?,?,?,?,?,?,?)");
        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getEmail());
        preparedStatement.setString(5, user.getAdress().toString());
        preparedStatement.setDate(6, new java.sql.Date(user.getBirthDate().getTime()));
        preparedStatement.setString(7, user.getWatchingProfiles().toString());
        preparedStatement.execute();
        return this;
    }

    public boolean emailExistsAndDisconnect(String email) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        disconnect();
        return false;
    }

    public String getHashedPasswordAndDisconnect(String email) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT password FROM users WHERE email = ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void disconnect() {
        DatabaseHandler.closeConnection(connection);
    }
}

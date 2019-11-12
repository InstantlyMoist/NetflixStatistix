package me.kyllian.netflixstatistix.database;

import me.kyllian.netflixstatistix.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

    private Connection connection;
    private List<String> fetchedData;
    private User fetchable;

    public DatabaseConnection() {
        fetchedData = new ArrayList<String>();
    }

    public DatabaseConnection connect() {
        connection = DatabaseHandler.getSQLConnection();
        return this;
    }

    public DatabaseConnection uploadUser(User user) throws SQLException {
        PreparedStatement adressStatement = connection.prepareStatement("INSERT INTO address(street, number, postal_code, residence)" +
                " values(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        adressStatement.setString(1, user.getAdress().getStreet());
        adressStatement.setString(2, user.getAdress().getNumber());
        adressStatement.setString(3, user.getAdress().getPostalCode());
        adressStatement.setString(4, user.getAdress().getResidence());
        adressStatement.execute();
        ResultSet resultSet = adressStatement.getGeneratedKeys();
        if (resultSet.next()) user.setAdressID(resultSet.getInt(1) + "");

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(first_name, last_name, password, email, address_id, birth_date, watching_profiles)" +
                " values (?,?,?,?,?,?,?)");
        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getEmail());
        preparedStatement.setString(5, user.getAdressID());
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

    public DatabaseConnection setFetchable(User fetchable) {
        this.fetchable = fetchable;
        return this;
    }

    public DatabaseConnection fetchFields(String... field) {
        for (String foundField : field) {
            fetchField(foundField);
        }
        return this;
    }

    public DatabaseConnection fetchField(String field) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ? FROM users WHERE email = ? AND password = ?");
            preparedStatement.setString(1, field);
            preparedStatement.setString(2, fetchable.getEmail());
            preparedStatement.setString(3, fetchable.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String found = resultSet.getString(1);
                System.out.println(found);
                fetchedData.add(found);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return this;
    }

    public List<String> getFetchedDataAndDisconnect() {
        this.disconnect();
        return fetchedData;
    }

    public void disconnect() {
        DatabaseHandler.closeConnection(connection);
    }
}

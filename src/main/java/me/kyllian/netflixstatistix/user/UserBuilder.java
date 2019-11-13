package me.kyllian.netflixstatistix.user;

import me.kyllian.netflixstatistix.database.DatabaseConnection;
import me.kyllian.netflixstatistix.database.PasswordEncryptor;
import me.kyllian.netflixstatistix.exceptions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserBuilder {

    private String firstName;
    private String lastName;
    private String password;
    private String email;

    private Adress adress;
    private Date birthDate;

    private InputInvalidException inputInvalidException;

    public UserBuilder() {
        inputInvalidException = new InputInvalidException();
    }

    public boolean isNameValid(String name) {
        return name.matches("^[A-Z][a-z]{2,}(?: [A-Z][a-z]*)*$");
    }

    public boolean isPostalCodeValid(String postalCode) {
        return postalCode.matches("^[0-9]{4}[[A-Z][a-z]]{2}$");
    }

    public boolean isNumberValid(String number) {
        return number.matches("^[0-9]+[[A-Z][a-z]]*$");
    }

    public boolean isEmailValid(String email) {
        return email.matches("^[\\w-_\\\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
    }

    public UserBuilder withFirstName(String firstName) {
        if (!isNameValid(firstName)) inputInvalidException.addType(InvalidFieldType.FIRSTNAME);
        else this.firstName = firstName;
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        if (!isNameValid(lastName)) inputInvalidException.addType(InvalidFieldType.LASTNAME);
        else this.lastName = lastName;
        return this;
    }

    public UserBuilder withPassword(String password) {
        if (password.length() < 8)
            inputInvalidException.addType(InvalidFieldType.PASSWORDUNSAFE); //TODO: Add more checks because safety
        this.password = PasswordEncryptor.encrypt(password);
        return this;
    }

    public UserBuilder checkRepeatPassword(String password) {
        if (!this.password.equals(PasswordEncryptor.encrypt(password)))
            inputInvalidException.addType(InvalidFieldType.DIFFERENTPASSWORD);
        return this;
    }

    public UserBuilder withEmail(String email) {
        if (new DatabaseConnection().connect().emailExistsAndDisconnect(email))
            inputInvalidException.addType(InvalidFieldType.EMAILEXISTS);
        if (!isEmailValid(email)) inputInvalidException.addType(InvalidFieldType.EMAIL);
        this.email = email;
        return this;
    }

    public UserBuilder withAdress(String street, String number, String postalCode, String residence) {
        if (!isNameValid(street)) inputInvalidException.addType(InvalidFieldType.STREET);
        if (!isNumberValid(number)) inputInvalidException.addType(InvalidFieldType.NUMBER);
        if (!isPostalCodeValid(postalCode)) inputInvalidException.addType(InvalidFieldType.POSTALCODE);
        if (!isNameValid(residence)) inputInvalidException.addType(InvalidFieldType.RESIDENCE);
        this.adress = new Adress(street, number, postalCode, residence);
        return this;
    }

    public UserBuilder withDate(int day, int month, int year) {
        try {
            String dayString = day < 10 ? "0" + day : day + "";
            String monthString = month < 10 ? "0" + month : month + "";
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-" + monthString + "-" + dayString);
            this.birthDate = date;
        } catch (ParseException exception) {
            inputInvalidException.addType(InvalidFieldType.BIRTHDATE);
        }
        return this;
    }

    public User build() throws InputInvalidException {
        if (!inputInvalidException.getFoundTypes().isEmpty()) throw inputInvalidException;
        User newUser = new User(firstName, lastName, password, email, adress, birthDate);
        newUser.addWatchingProfile(new WatchingProfile()); //TODO: Return well constructed watching profiel with default recommandations
        return newUser;
    }

    public User login() throws InputInvalidException {
        if (!inputInvalidException.getFoundTypes().contains(InvalidFieldType.EMAILEXISTS)) {
            inputInvalidException.addIgnoredType(InvalidFieldType.EMAILEXISTS);
            inputInvalidException.addType(InvalidFieldType.UNKNOWNACCOUNT);
            throw inputInvalidException;
        }
        String hashedPassword = new DatabaseConnection().connect().getHashedPasswordAndDisconnect(email);
        if (!hashedPassword.equals(password)) {
            System.out.println(password);
            inputInvalidException.addType(InvalidFieldType.INCORRECTPASSWORD);
            throw inputInvalidException;
        }
        return new User(email, password);
    }

}

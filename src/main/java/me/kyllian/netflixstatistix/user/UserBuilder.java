package me.kyllian.netflixstatistix.user;

import me.kyllian.netflixstatistix.post.PasswordEncryptor;
import me.kyllian.netflixstatistix.exceptions.*;
import me.kyllian.netflixstatistix.post.PostBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserBuilder {

    private String firstName;
    private String lastName;
    private String password;
    private String email;

    private Adress adress;
    private long birthDate;

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
            this.birthDate = date.getTime();
        } catch (ParseException exception) {
            inputInvalidException.addType(InvalidFieldType.BIRTHDATE);
        }
        return this;
    }

    public User build() throws InputInvalidException {
        String response = new PostBuilder().withIdentifier("user")
                .withAttribute("firstname", firstName)
                .withAttribute("lastname", lastName)
                .withAttribute("password", password)
                .withAttribute("email", email)
                .withAttribute("street", adress.getStreet())
                .withAttribute("number", adress.getNumber())
                .withAttribute("postalcode", adress.getPostalCode())
                .withAttribute("residence", adress.getResidence())
                .withAttribute("birthdate", birthDate + "")
                .withAttribute("watchingprofiles", "null")
                .postAndGetResponse();
        if (response.equals("USER_EXISTS")) inputInvalidException.addType(InvalidFieldType.EMAILEXISTS);
        if (!inputInvalidException.getFoundTypes().isEmpty()) throw inputInvalidException;

        User newUser = new User(firstName, lastName, password, email, adress, birthDate);
        newUser.addWatchingProfile(new WatchingProfile()); //TODO: Return well constructed watching profile with default recommandations
        return newUser;
    }

    public User login() throws InputInvalidException {
        String response = new PostBuilder().withIdentifier("login")
                .withAttribute("email", email)
                .withAttribute("password", password)
                .postAndGetResponse();
        return new User(response);
    }

}

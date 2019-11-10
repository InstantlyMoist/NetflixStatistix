package me.kyllian.netflixstatistix.user;

import me.kyllian.netflixstatistix.exceptions.FirstNameInvalidException;
import me.kyllian.netflixstatistix.exceptions.LastNameInvalidException;
import me.kyllian.netflixstatistix.exceptions.PasswordUnsafeException;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserBuilder {

    private String firstName; //done
    private String lastName; //done
    private String password; //password should be checked and immediately encrypted
    private String email;

    private Adress adress;
    private Date birthDate;


    public boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile("^[A-Z][a-z]{2,}(?: [A-Z][a-z]*)*$");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public UserBuilder withFirstName(String firstName) throws FirstNameInvalidException {
        if (!isNameValid(firstName)) throw new FirstNameInvalidException("Invalid first name");
        else this.firstName = firstName;
        return this;
    }

    public UserBuilder withLastName(String lastName) throws LastNameInvalidException {
        if (!isNameValid(lastName)) throw new LastNameInvalidException("Invalid last name");
        else this.lastName = lastName;
        return this;
    }

    public UserBuilder withPassword(String password) throws PasswordUnsafeException {
        if (password.length() < 8) throw new PasswordUnsafeException("Password is unsafe"); //TODO: Add more checks
        return this;
    }
}

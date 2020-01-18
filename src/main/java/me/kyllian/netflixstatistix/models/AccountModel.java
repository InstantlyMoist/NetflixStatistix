package me.kyllian.netflixstatistix.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleLongProperty;

public class AccountModel {

    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty eMail;
    private SimpleLongProperty birthDate;
    private SimpleStringProperty street;
    private SimpleStringProperty number;
    private SimpleStringProperty residence;

    public AccountModel(String firstName, String lastName, String eMail, long birthDate, String street, String number, String residence) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.eMail = new SimpleStringProperty(eMail);
        this.birthDate = new SimpleLongProperty(birthDate);
        this.street = new SimpleStringProperty(street);
        this.number = new SimpleStringProperty(number);
        this.residence = new SimpleStringProperty(residence);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public String geteMail() {
        return eMail.get();
    }

    public long getBirthDate() {
        return birthDate.get();
    }

    public String getStreet() {
        return street.get();
    }

    public String getNumber() {
        return number.get();
    }

    public String getResidence() {
        return residence.get();
    }
}

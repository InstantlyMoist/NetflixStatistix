package me.kyllian.netflixstatistix.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SingleProfileModel {

    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty mail;

    public SingleProfileModel(String firstName, String lastName, String mail) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.mail = new SimpleStringProperty(mail);
    }

    public String getFirstName() {
        return firstName.get();
    }


    public String getLastName() {
        return lastName.get();
    }


    public String getMail() {
        return mail.get();
    }
}

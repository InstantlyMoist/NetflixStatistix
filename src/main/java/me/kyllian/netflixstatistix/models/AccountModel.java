package me.kyllian.netflixstatistix.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleLongProperty;

public class AccountModel {

    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty EMail;


    public AccountModel(String firstName, String lastName, String EMail) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.EMail = new SimpleStringProperty(EMail);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public String getEMail() {
        return EMail.get();
    }
    
}

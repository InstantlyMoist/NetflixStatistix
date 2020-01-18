package me.kyllian.netflixstatistix.user;

import java.io.*;

public class Address {

    private String street;
    private String number;
    private String postalCode;
    private String residence;

    public Address(String street, String number, String postalCode, String residence) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.residence = residence;
    }

    public Address(String dataString) {
        String[] split = dataString.split(":");
        this.street = split[0];
        this.number = split[1];
        this.postalCode = split[2];
        this.residence = split[3];
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getResidence() {
        return residence;
    }

}

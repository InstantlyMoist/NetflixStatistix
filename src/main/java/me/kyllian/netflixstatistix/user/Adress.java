package me.kyllian.netflixstatistix.user;

public class Adress {

    private String street;
    private String number;
    private String postcode;
    private String residence;

    public Adress(String street, String number, String postcode, String residence) {
        this.street = street;
        this.number = number;
        this.postcode = postcode;
        this.residence = residence;
    }

    public Adress(String dataString) {
        String[] split = dataString.split(":");
        this.street = split[0];
        this.number = split[1];
        this.postcode = split[2];
        this.residence = split[3];
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getResidence() {
        return residence;
    }

    @Override
    public String toString() {
        return street + ":" + number + ":" + postcode + ":" + residence;
    }
}

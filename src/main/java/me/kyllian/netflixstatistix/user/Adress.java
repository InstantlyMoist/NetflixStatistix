package me.kyllian.netflixstatistix.user;

public class Adress {

    private String street;
    private int houseNumber;
    private String addition;
    private String postcode;
    private String residence;

    public Adress(String street, int houseNumber, String addition, String postcode, String residence) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.addition = addition;
        this.postcode = postcode;
        this.residence = residence;
    }

    public Adress(String dataString) {
        String[] split = dataString.split(":");
        this.street = split[0];
        this.houseNumber = Integer.parseInt(split[1]);
        this.addition = split[2];
        this.postcode = split[3];
        this.residence = split[4];
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getAddition() {
        return addition;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getResidence() {
        return residence;
    }

    @Override
    public String toString() {
        return street + ":" + houseNumber + ":" + addition + ":" + postcode + ":" + residence;
    }
}

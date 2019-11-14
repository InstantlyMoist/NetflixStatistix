package me.kyllian.netflixstatistix.user;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class User {

    private String firstName;
    private String lastName;
    private String password;
    private String email;

    private Adress address;
    private String addressID;
    private long birthDate;

    private List<WatchingProfile> watchingProfiles;

    public User(String firstName, String lastName, String password, String email, Adress address, long birthDate) {
        //TODO: Validate given input, do this before this object has been created.
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;

        watchingProfiles = new ArrayList<WatchingProfile>();
    }

    public User(String jsonData) {
        JSONObject object = new JSONObject(jsonData.replace("[", "").replace("]", ""));
        this.firstName = object.getString("first_name");
        this.lastName =  object.getString("last_name");
        this.password = object.getString("password");
        this.email = object.getString("email");
        this.addressID = "" + object.getInt("address_id");
        this.birthDate = object.getLong("birth_date");

        //TODO: Add database connection to fetch watching data.
    }

    public void addWatchingProfile(WatchingProfile watchingProfile) {
        if (!watchingProfiles.contains(watchingProfile)) watchingProfiles.add(watchingProfile);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adress getAddress() {
        return address;
    }

    public void setdAdress(Adress address) {
        this.address = address;
    }

    public String getAddressID() {
        return addressID;
    }

    public void setAddressID(String addressID) {
        this.addressID = addressID;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public List<WatchingProfile> getWatchingProfiles() {
        return watchingProfiles;
    }

    public void setWatchingProfiles(List<WatchingProfile> watchingProfiles) {
        this.watchingProfiles = watchingProfiles;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", addressID='" + addressID + '\'' +
                ", birthDate=" + birthDate +
                ", watchingProfiles=" + watchingProfiles +
                '}';
    }
}

package me.kyllian.netflixstatistix.user;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String firstName;
    private String lastName;
    private String password;
    private String email;

    private Address address;
    private String addressID;
    private long birthDate;

    private List<WatchingProfile> watchingProfiles;

    public User(String firstName, String lastName, String password, String email, Address address, long birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;

        watchingProfiles = new ArrayList<WatchingProfile>();
    }

    public User(String jsonData) {
        try {
            JSONObject object = new JSONObject(jsonData.replace("[", "").replace("]", ""));
            this.firstName = object.getString("first_name");
            this.lastName =  object.getString("last_name");
            this.password = object.getString("password");
            this.email = object.getString("email");
            this.addressID = "" + object.getInt("address_id");
            this.birthDate = object.getLong("birth_date");
        } catch (JSONException exception) {
            System.out.println(jsonData);
        }
        System.out.println(this.toString());

        //TODO: Add database connection to fetch watching data.
    }

    public void addWatchingProfile(WatchingProfile watchingProfile) {
        if (!watchingProfiles.contains(watchingProfile)) watchingProfiles.add(watchingProfile);
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

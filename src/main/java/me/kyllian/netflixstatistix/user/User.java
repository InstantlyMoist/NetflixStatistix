package me.kyllian.netflixstatistix.user;

import me.kyllian.netflixstatistix.database.DatabaseConnection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class User {

    private String firstName;
    private String lastName;
    private String password;
    private String email;

    private Adress adress;
    private String adressID;
    private Date birthDate;

    private List<WatchingProfile> watchingProfiles;

    public User(String firstName, String lastName, String password, String email, Adress adress, Date birthDate) {
        //TODO: Validate given input, do this before this object has been created.
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.adress = adress;
        this.birthDate = birthDate;

        watchingProfiles = new ArrayList<WatchingProfile>();
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;

        this.watchingProfiles = new ArrayList<WatchingProfile>();

        List<String> fetchedData = new DatabaseConnection()
                .connect()
                .setFetchable(this)
                .fetchField("first_name")
                .fetchField("last_name")
                .fetchField("address")
                .fetchField("birth_date")
                .fetchField("watching_profiles")
                .getFetchedDataAndDisconnect();
        this.firstName = fetchedData.get(0);
        this.lastName = fetchedData.get(1);
        this.adressID = fetchedData.get(2);
        this.birthDate = new Date(fetchedData.get(3));
        for (String watchingProfile : Arrays.asList(fetchedData.get(4))) {
            WatchingProfile found = WatchingProfile.fromString(watchingProfile);
            System.out.println(found.badTest);
            watchingProfiles.add(found);
        }

        //TODO: Add database connection to fetch watching data.
    }

    public void addWatchingProfile(WatchingProfile watchingProfile) {
        if (!watchingProfiles.contains(watchingProfile)) watchingProfiles.add(watchingProfile);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Adress getAdress() {
        return adress;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<WatchingProfile> getWatchingProfiles() {
        return watchingProfiles;
    }

    public String getAdressID() {
        return adressID;
    }

    public void setAdressID(String adressID) {
        this.adressID = adressID;
    }
}

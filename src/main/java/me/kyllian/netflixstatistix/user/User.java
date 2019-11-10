package me.kyllian.netflixstatistix.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    private String firstName;
    private String lastName;
    private String password;
    private String email;

    private Adress adress;
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

        //TODO: Add database connection to fetch watching data.
    }

    /*
        User
        Containing:
          - First name - VARCHAR(32)
          - Last name - VARCHAR(32)
          - Password (Needs to be encrypted using the #encrypt method before sending!) - VARCHAR

          - E-mail VARCHAR
          - Adress (Straat, huisnummer + toevoeging, postcode)
            - Straat - VARCHAR
            - Huisnummer - SMALLINT
            - Toevoeging - VARCHAR(25)
            - Postcode - VARCHAR(7)
            - Woonplaats - VARCHART
          - Geboortedatum (Dag, Maand, Jaar)
            - Dag - SMALLINT ( 1 - 31 )
            - Maand - SMALLINT ( 1 - 12 )
            - Jaar - SMALLINT ( 1900 - 2019 )


          - List of watching profiles

         */

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
}

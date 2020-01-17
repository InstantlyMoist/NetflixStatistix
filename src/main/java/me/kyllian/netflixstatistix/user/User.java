package me.kyllian.netflixstatistix.user;

public class User {

    private String firstName;
    private String lastName;
    private String password;
    private String email;

    private Address address;
    private String addressID;
    private long birthDate;

    public User(String firstName, String lastName, String password, String email, Address address, long birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
    }

}

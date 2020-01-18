package me.kyllian.netflixstatistix.user;

public class WatchingProfile {

    private String username;
    private long birthDate;

    public WatchingProfile(String username, long birthDate) {
        this.username = username;
        this.birthDate = birthDate;
    }

    public String getUsername() {
        return username;
    }

    public long getBirthDate() {
        return birthDate;
    }
}

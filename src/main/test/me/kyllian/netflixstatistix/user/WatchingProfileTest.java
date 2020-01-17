package me.kyllian.netflixstatistix.user;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WatchingProfileTest {

    @Test
    public void TestSetandGetUsernameAndBirthdate(){
        WatchingProfile profile = new WatchingProfile("Caelan", 02-02-2013);
        assertEquals(profile.getBirthDate(), 02-02-2013);
        assertEquals(profile.getUsername(), "Caelan");
    }
}
package me.kyllian.netflixstatistix.session;

import me.kyllian.netflixstatistix.session.SessionData;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

class SessionDataTest {


    public void testIDK() {
        SessionData data = new SessionData();
        data.setUserID(123);
        assertEquals(data.getUserID(), 123);
    }
}
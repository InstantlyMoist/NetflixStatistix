package me.kyllian.netflixstatistix.session;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SessionDataTest {

    @Test
    public void testSetAndGetUserIDAreEqual() {
        SessionData data = new SessionData();
        data.setUserID(123);
        assertEquals(data.getUserID(), 123);
    }

    @Test
    public void testSetAndGetSelectedProfileIDAreEqual() {
        SessionData data = new SessionData();
        data.setSelectedProfileID(123);
        assertEquals(data.getSelectedProfileID(), 123);
    }

    @Test
    public void testSetAndGetEmailAreEqual() {
        SessionData data = new SessionData();
        data.setEmail("email@email.com");
        assertEquals(data.getEmail(), "email@email.com");
    }
}
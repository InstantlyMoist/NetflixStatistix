package me.kyllian.netflixstatistix.user;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AddressTest {

    @Test
    public void testInputSameAsOutput(){
        Address address = new Address("Baanweer", "91", "3363XN", "Dordrecht");
        assertEquals(address.getStreet(), "Baanweer");
        assertEquals(address.getNumber(), "91");
        assertEquals(address.getPostalCode(), "3363XN");
        assertEquals(address.getResidence(), "Dordrecht");
    }
}
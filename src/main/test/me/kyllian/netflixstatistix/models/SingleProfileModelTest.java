package me.kyllian.netflixstatistix.models;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SingleProfileModelTest {

    @Test
    public void testInputSameAsOutput(){
        SingleProfileModel singleProfileModel = new SingleProfileModel("Caelan", "Eijnsbergen", "caelan.van.eijnsbergen@gmail.com");
        assertEquals(singleProfileModel.getFirstName(), "Caelan");
        assertEquals(singleProfileModel.getLastName(), "Eijnsbergen");
        assertEquals(singleProfileModel.getMail(), "caelan.van.eijnsbergen@gmail.com");
    }
}
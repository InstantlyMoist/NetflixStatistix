package me.kyllian.netflixstatistix.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountModelTest {

    @Test
    public void testInputSameAsOutput(){
        AccountModel accountModel = new AccountModel("Caelan", "Eijnsbergen", "a@a.nl");

        assertEquals(accountModel.getFirstName(), "Caelan");
        assertEquals(accountModel.getLastName(), "Eijnsbergen");
        assertEquals(accountModel.getEMail(), "a@a.nl");

    }
}
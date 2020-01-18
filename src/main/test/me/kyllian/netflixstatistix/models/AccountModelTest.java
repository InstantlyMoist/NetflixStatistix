package me.kyllian.netflixstatistix.models;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AccountModelTest {

    @Test
    public void testInputSameAsOutput(){
        AccountModel accountModel = new AccountModel("Caelan", "Eijnsbergen", "a@a.nl", 02-02-2002, "baanweer", "19", "Dordrecht");

        assertEquals(accountModel.getFirstName(), "Caelan");
        assertEquals(accountModel.getLastName(), "Eijnsbergen");
        assertEquals(accountModel.geteMail(), "a@a.nl");
        assertEquals(accountModel.getBirthDate(), 02-02-2002);
        assertEquals(accountModel.getStreet(), "baanweer");
        assertEquals(accountModel.getNumber(), "19");
        assertEquals(accountModel.getResidence(), "Dordrecht");
    }
}
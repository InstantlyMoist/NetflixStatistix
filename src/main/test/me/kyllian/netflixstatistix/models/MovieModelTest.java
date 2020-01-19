package me.kyllian.netflixstatistix.models;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MovieModelTest {

    @Test
    public void testInputSameAsOutput(){
        MovieModel movieModel = new MovieModel("Bladerunner", 12);
        assertEquals(movieModel.getMovieName(), "Bladerunner");
        assertEquals(movieModel.getAmount(), 12);
    }
}
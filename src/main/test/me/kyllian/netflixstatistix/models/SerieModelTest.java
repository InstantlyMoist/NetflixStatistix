package me.kyllian.netflixstatistix.models;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SerieModelTest {

    @Test
    public void testInputSameAsOutput(){
        SerieModel serieModel = new SerieModel("The Witcher", 10, 61);
        assertEquals(serieModel.getTitle(), "The Witcher");
        assertEquals(serieModel.getEpisodeID(), 10);
        assertEquals(serieModel.getAverage(), 61);
    }
}
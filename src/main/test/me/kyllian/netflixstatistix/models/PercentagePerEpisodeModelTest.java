package me.kyllian.netflixstatistix.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PercentagePerEpisodeModelTest {

    @Test
    public void testInputSameAsOutput() {
        PercentagePerEpisodeModel serieModel = new PercentagePerEpisodeModel("The Witcher", 10, 61);
        assertEquals(serieModel.getSerie(), "The Witcher");
        assertEquals(serieModel.getEpisode(), 10);
        assertEquals(serieModel.getAverageTime(), 61);
    }
}

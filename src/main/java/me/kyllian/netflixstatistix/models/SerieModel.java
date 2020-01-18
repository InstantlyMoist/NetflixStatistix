package me.kyllian.netflixstatistix.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SerieModel {

    private SimpleStringProperty title;
    private SimpleIntegerProperty episodeID;
    private SimpleIntegerProperty average;

    public SerieModel(String title, int episodeID, int average) {
        this.title = new SimpleStringProperty(title);
        this.episodeID = new SimpleIntegerProperty(episodeID);
        this.average = new SimpleIntegerProperty(average);
    }

    public String getTitle() {
        return title.get();
    }

    public int getEpisodeID() {
        return episodeID.get();
    }

    public int getAverage() {
        return average.get();
    }

}

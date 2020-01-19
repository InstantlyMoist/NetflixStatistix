package me.kyllian.netflixstatistix.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PercentagePerEpisodeModel {

    private SimpleStringProperty eMailUser;
    private SimpleStringProperty serie;
    private SimpleIntegerProperty episode;
    private SimpleIntegerProperty averageTime;

    public PercentagePerEpisodeModel(String eMailUser, String serie, int episode, int averageTime) {
        this.eMailUser = new SimpleStringProperty(eMailUser);
        this.serie = new SimpleStringProperty(serie);
        this.episode = new SimpleIntegerProperty(episode);
        this.averageTime = new SimpleIntegerProperty(averageTime);
    }

    public String geteMailUser() {
        return eMailUser.get();
    }

    public String getSerie() {
        return serie.get();
    }

    public int getEpisode() {
        return episode.get();
    }

    public int getAverageTime() {
        return averageTime.get();
    }
}

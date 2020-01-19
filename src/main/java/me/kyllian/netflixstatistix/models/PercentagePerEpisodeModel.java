package me.kyllian.netflixstatistix.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PercentagePerEpisodeModel {

    private SimpleStringProperty emailUser;
    private SimpleStringProperty serie;
    private SimpleIntegerProperty episode;
    private SimpleIntegerProperty averageTime;

    public PercentagePerEpisodeModel(String emailUser, String serie, int episode, int averageTime) {
        this.emailUser = new SimpleStringProperty(emailUser);
        this.serie = new SimpleStringProperty(serie);
        this.episode = new SimpleIntegerProperty(episode);
        this.averageTime = new SimpleIntegerProperty(averageTime);
    }


    public String getEmailUser() {
        return emailUser.get();
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

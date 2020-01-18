package me.kyllian.netflixstatistix.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MovieModel {

    private SimpleStringProperty movieName;
    private SimpleIntegerProperty amount;

    public MovieModel(String movieName, int amount) {
        this.movieName = new SimpleStringProperty(movieName);
        this.amount = new SimpleIntegerProperty(amount);
    }

    public String getMovieName() {
        return movieName.get();
    }

    public int getAmount() {
        return amount.get();
    }
}

package me.kyllian.netflixstatistix.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class WatchedDataModel {

    private SimpleStringProperty profile;
    private SimpleStringProperty programWatched;
    private SimpleStringProperty programToAddOrRemove;

    public WatchedDataModel(String profile, String programWatched, String programToAddOrRemove) {
        this.profile = new SimpleStringProperty(profile);
        this.programWatched = new SimpleStringProperty(programWatched);
        this.programToAddOrRemove = new SimpleStringProperty(programToAddOrRemove);
    }

    public String getprofile() {
        return profile.get();
    }

    public String getProgramWatched() {
        return programWatched.get();
    }

    public String getProgramToAddOrRemove() {
        return programToAddOrRemove.get();
    }


}

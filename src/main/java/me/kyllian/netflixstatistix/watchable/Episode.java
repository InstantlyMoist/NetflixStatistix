package me.kyllian.netflixstatistix.watchable;

public class Episode {

    private int serialNumber;
    private String title;
    private int duration;
    private String description;

    public Episode(int serialNumber, String title, int duration, String description){
        this.serialNumber = serialNumber;
        this.title = title;
        this.duration = duration;
        this.description = description;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }
}




//een aflevering heeft alleen een volgnummer en is onderdeel van een serie
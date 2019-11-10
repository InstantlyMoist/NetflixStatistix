package me.kyllian.netflixstatistix.watchable;

public class Series {

    private String title;
    private int timeDuration;
    private String genre;
    private String language;
    private int ageIndicator;
    private int serialNumber;

    //serie bestaat uit minimaal 1 aflevering en aflevering hoort bij 1 serie

    public Series(String title, int timeDuration, String genre, String language, int ageIndicator, int serialNumber){
        this.title = title;
        this.timeDuration = timeDuration;
        this.genre = genre;
        this.language = language;
        this.ageIndicator = ageIndicator;
        this.serialNumber = serialNumber;
    }








}

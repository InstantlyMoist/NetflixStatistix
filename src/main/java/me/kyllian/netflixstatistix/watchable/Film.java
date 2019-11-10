package me.kyllian.netflixstatistix.watchable;

public class Film {

    private String title;
    private int timeDuration;
    private String genre;
    private String language;
    private int ageIndicator;

    public Film(String title, int timeDuration, String genre, String language, int ageIndicator){
        this.title = title;
        this.timeDuration = timeDuration;
        this.genre = genre;
        this.language = language;
        this.ageIndicator = ageIndicator;
    }


}

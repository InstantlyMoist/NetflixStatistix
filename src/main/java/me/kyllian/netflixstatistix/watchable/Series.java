package me.kyllian.netflixstatistix.watchable;

public class Series {

    private String title;
    private int timeDuration;
    private String genre;
    private String language;
    private int ageIndicator;
    private int serialNumber;

    //serie bestaat uit minimaal 1 aflevering en aflevering hoort bij 1 serie

    public Series(String title, int timeDuration, String genre, String language, int ageIndicator){
        this.title = title;
        this.timeDuration = timeDuration;
        this.genre = genre;
        this.language = language;
        this.ageIndicator = ageIndicator;

    }

    public String getTitle() {
        return title;
    }

    public int getTimeDuration() {
        return timeDuration;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public int getAgeIndicator() {
        return ageIndicator;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return "Series{" +
                "title='" + title + '\'' +
                ", timeDuration=" + timeDuration +
                ", genre='" + genre + '\'' +
                ", language='" + language + '\'' +
                ", ageIndicator=" + ageIndicator +
                ", serialNumber=" + serialNumber +
                '}';
    }
}

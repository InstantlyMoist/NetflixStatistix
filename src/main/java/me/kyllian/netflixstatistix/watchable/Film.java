package me.kyllian.netflixstatistix.watchable;

public class Film {

    private String title;
    private int timeDuration;
    private String description;
    private String genre;
    private String language;
    private int ageIndicator;

    public Film(String title, int timeDuration, String description, String genre, String language, int ageIndicator){
        this.title = title;
        this.timeDuration = timeDuration;
        this.description = description;
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

    public String getDescription() {
        return description;
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

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", timeDuration=" + timeDuration +
                ", genre='" + genre + '\'' +
                ", language='" + language + '\'' +
                ", ageIndicator=" + ageIndicator +
                '}';
    }
}

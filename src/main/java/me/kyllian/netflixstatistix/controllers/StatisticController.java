package me.kyllian.netflixstatistix.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import me.kyllian.netflixstatistix.NetflixStatistix;

public class StatisticController extends Controller {
    @Override
    public void handleResponse(String response) {

    }

    public void back() {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/profile.fxml"));
            root.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void handleAccountButton(){
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/account.fxml"));
            root.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void handleMoviesButton(){
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/showMovies.fxml"));
            root.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void handleSeriesButton(){
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/serie.fxml"));
            root.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void handleAccountWithProfileButton(){
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/accountWithProfile.fxml"));
            root.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void handleMovieUnderButton(){ // showt movie under 16 with highest duration.
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/movieUnder.fxml"));
            root.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void handlePercentageSeriesPerEpisode(){ // showt movie under 16 with highest duration.
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/percentagePerEpisode.fxml"));
            root.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

}

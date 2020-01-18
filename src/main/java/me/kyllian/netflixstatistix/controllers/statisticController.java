package me.kyllian.netflixstatistix.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import me.kyllian.netflixstatistix.NetflixStatistix;

public class statisticController extends Controller {
    @Override
    public void handleResponse(String response) {

    }

    public void handleAccountButton(){
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/account.fxml"));
            root.getStylesheets().add(getClass().getResource("/css/account.css").toExternalForm());
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void handleMoviesButton(){
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/showMovies.fxml"));
            root.getStylesheets().add(getClass().getResource("/css/showMovies.css").toExternalForm());
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void handleSeriesButton(){
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/serie.fxml"));
            root.getStylesheets().add(getClass().getResource("/css/serie.css").toExternalForm());
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void handleAccountWithProfileButton(){
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/accountWithProfile.fxml"));
            root.getStylesheets().add(getClass().getResource("/css/AccountWithProfile.css").toExternalForm());
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

}

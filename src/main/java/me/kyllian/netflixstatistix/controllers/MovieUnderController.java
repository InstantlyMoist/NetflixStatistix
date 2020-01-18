package me.kyllian.netflixstatistix.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import me.kyllian.netflixstatistix.NetflixStatistix;

public class MovieUnderController extends Controller {

    //shows movie under 16 with longest time.

    @Override
    public void handleResponse(String response) {

    }

    public void back() {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/statistic.fxml"));
            root.getStylesheets().add(getClass().getResource("/css/statistic.css").toExternalForm());
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}

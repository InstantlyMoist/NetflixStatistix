package me.kyllian.netflixstatistix.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import me.kyllian.netflixstatistix.NetflixStatistix;

public class PercentagePerEpisodeController extends Controller {

    //Voor een geselecteerde account en serie, geef per aflevering het gemiddeld
    //bekeken percentage van de totale tijdsduur.
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

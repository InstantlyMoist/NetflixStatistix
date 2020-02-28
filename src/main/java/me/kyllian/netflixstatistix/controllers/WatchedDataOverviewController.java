package me.kyllian.netflixstatistix.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import me.kyllian.netflixstatistix.NetflixStatistix;
import me.kyllian.netflixstatistix.models.SerieModel;

import java.net.URL;
import java.util.ResourceBundle;

public class WatchedDataOverviewController extends Controller implements Initializable {

    @FXML
    private TableView<SerieModel> table;

    @FXML
    private TableColumn<SerieModel, String> tableProfiles;

    @FXML
    private TableColumn<SerieModel, String> tableProgramsWatched;

    @FXML
    private TableColumn<SerieModel, String> tableAddRemove;

    //TODO initialize en handleResponse method kan nu gemaakt worden

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

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
}

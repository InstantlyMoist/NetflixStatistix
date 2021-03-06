package me.kyllian.netflixstatistix.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import me.kyllian.netflixstatistix.NetflixStatistix;
import me.kyllian.netflixstatistix.models.PercentagePerEpisodeModel;
import me.kyllian.netflixstatistix.post.PostBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PercentagePerEpisodeController extends Controller implements Initializable {

    //Voor een geselecteerde account en serie, geef per aflevering het gemiddeld
    //bekeken percentage van de totale tijdsduur.

    @FXML
    private TableView<PercentagePerEpisodeModel> table;

    @FXML
    private TableColumn<PercentagePerEpisodeModel, String> tableSerie;

    @FXML
    private TableColumn<PercentagePerEpisodeModel, Integer> tableEpisode;

    @FXML
    private TableColumn<PercentagePerEpisodeModel, Integer> tableAverageTime;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableSerie.setCellValueFactory(new PropertyValueFactory<>("Serie"));
        tableEpisode.setCellValueFactory(new PropertyValueFactory<>("Episode"));
        tableAverageTime.setCellValueFactory(new PropertyValueFactory<>("AverageTime"));

        new PostBuilder()
                .withIdentifier("averageTime")
                .post(this);
    }

    @Override
    public void handleResponse(String response) {
        List<PercentagePerEpisodeModel> percentagePerEpisodeModels = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(response);
            for (int i = 0; i != array.length(); i++) {
                JSONObject data = array.getJSONObject(i);
                percentagePerEpisodeModels.add(new PercentagePerEpisodeModel(data.getString("name_serie"), data.getInt("episode_id"), data.getInt("average")));
            }
        } catch (JSONException exception) {
            System.out.println("Error reading JSON from server");
            exception.printStackTrace();
        }
        table.setItems(FXCollections.observableArrayList(percentagePerEpisodeModels));
    }

    public void back() {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/statistic.fxml"));
            root.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}

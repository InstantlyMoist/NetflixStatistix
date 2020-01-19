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
import me.kyllian.netflixstatistix.models.MovieModel;
import me.kyllian.netflixstatistix.models.SerieModel;
import me.kyllian.netflixstatistix.post.PostBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SeriesController extends Controller implements Initializable {

    @FXML
    private TableView<SerieModel> table;

    @FXML
    private TableColumn<SerieModel, String> tableTitle;

    @FXML
    private TableColumn<SerieModel, Integer> tableID;

    @FXML
    private TableColumn<SerieModel, Integer> tableAverage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new PostBuilder()
                .withIdentifier("seriesAverage")
                .post(this);
        tableTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        tableID.setCellValueFactory(new PropertyValueFactory<>("EpisodeID"));
        tableAverage.setCellValueFactory(new PropertyValueFactory<>("Average"));
    }

    @Override
    public void handleResponse(String response) {
        List<SerieModel> serieModels = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(response);
            for (int i = 0; i != array.length(); i++) {
                JSONObject data = array.getJSONObject(i);
                serieModels.add(new SerieModel(data.getString("title"), data.getInt("episode_id"), data.getInt("average")));
            }
        } catch (JSONException exception) {
            System.out.println("Error reading JSON from server");
            exception.printStackTrace();
        }
        table.setItems(FXCollections.observableArrayList(serieModels));
        System.out.println(response);
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

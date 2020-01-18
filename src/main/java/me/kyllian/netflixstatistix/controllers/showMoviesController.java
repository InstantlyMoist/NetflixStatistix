package me.kyllian.netflixstatistix.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import me.kyllian.netflixstatistix.models.MovieModel;
import me.kyllian.netflixstatistix.post.PostBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class showMoviesController extends Controller implements Initializable {

    @FXML
    private TableView<MovieModel> table;

    @FXML
    private TableColumn<MovieModel, String> movieNames;

    @FXML
    private TableColumn<MovieModel, Integer> amount;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new PostBuilder()
                .withIdentifier("filmsWithWatched")
                .post(this);
        movieNames.setCellValueFactory(new PropertyValueFactory<>("MovieName"));
        amount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
    }


    @Override
    public void handleResponse(String response) {
        List<MovieModel> movieModels = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(response);
            for (int i = 0; i != array.length(); i++) {
                JSONObject data = array.getJSONObject(i);
                movieModels.add(new MovieModel(data.getString("title"), data.getInt("amount")));
            }
        } catch (JSONException exception) {
            System.out.println("Error reading JSON from server");
            exception.printStackTrace();
        }
        table.setItems(FXCollections.observableArrayList(movieModels));
        System.out.println(response);
    }
}

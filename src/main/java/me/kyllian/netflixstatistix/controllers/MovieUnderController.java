package me.kyllian.netflixstatistix.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import me.kyllian.netflixstatistix.NetflixStatistix;
import me.kyllian.netflixstatistix.post.PostBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ResourceBundle;

public class MovieUnderController extends Controller implements Initializable {

    //shows movie under 16 with longest time.

    @FXML
    private Label text;

    @Override
    public void handleResponse(String response) {
        Platform.runLater(() -> {
            System.out.println(response);
            try {
                JSONObject object = new JSONObject(response);
                text.setText(object.getString("title") + " - " + object.getString("duration"));
            } catch (JSONException exception) {
                exception.printStackTrace();
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new PostBuilder()
                .withIdentifier("longest16")
                .post(this);
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

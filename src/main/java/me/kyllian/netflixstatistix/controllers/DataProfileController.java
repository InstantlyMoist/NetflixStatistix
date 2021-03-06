package me.kyllian.netflixstatistix.controllers;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import me.kyllian.netflixstatistix.NetflixStatistix;

import java.net.URL;
import java.util.ResourceBundle;

public class DataProfileController extends Controller implements Initializable{

    @FXML
    private ImageView logo;

    @FXML
    private TableView table;

    @FXML
    private Label title;

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button loadButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logo.setImage(new Image(getClass().getClassLoader().getResource("assets/logo.png").toExternalForm()));
    }

    public void handleResponse(String response) {
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                try {
                    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/dataProfile.fxml"));
                    root.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
                    NetflixStatistix.parentWindow.getScene().setRoot(root);
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        });
    }

}

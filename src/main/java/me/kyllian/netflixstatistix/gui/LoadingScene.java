package me.kyllian.netflixstatistix.gui;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;

public class LoadingScene {

    private Stage stage;
    private Scene scene;

    public LoadingScene(Stage stage) {
        this.stage = stage;
        construct();
    }

    public void construct() {
        //TODO: Construct GUI
        Label label = new Label("Loading...");

        GridPane gridPane = new GridPane();
        //gridPane.getChildren().add(label);
    }
}

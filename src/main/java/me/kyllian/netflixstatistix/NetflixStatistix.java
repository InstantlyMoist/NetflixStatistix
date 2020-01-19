package me.kyllian.netflixstatistix;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import me.kyllian.netflixstatistix.session.SessionData;

public class NetflixStatistix extends Application {

    public static Stage parentWindow;

    private static SessionData sessionData;

    public static void main(String[] args) {
        sessionData = new SessionData();
        launch(NetflixStatistix.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        parentWindow = stage;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/login.fxml"));
        stage.getIcons().add(new Image(getClass().getResource("/assets/logo.png").toExternalForm()));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("NetflixStatistix - Kyllian Warmerdam (2158151) | Afrash Ramjit (2151957) | Caelan van Eijnsbergen (2153459)");
        stage.show();
        root.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        stage.show();
    }

    public static SessionData getSessionData() {
        return sessionData;
    }
}

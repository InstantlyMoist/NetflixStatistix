package me.kyllian.netflixstatistix.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import me.kyllian.netflixstatistix.NetflixStatistix;
import me.kyllian.netflixstatistix.post.PostBuilder;

import java.net.URL;
import java.util.ResourceBundle;

public class WatchedDataOverviewController extends Controller implements Initializable {

    //TODO initialize en handleResponse method kan nu gemaakt worden

    @FXML
    private TextField programid;

    @FXML
    private TextField percentage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void handleResponse(String response) {
        back();
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

    public void add() {
        new PostBuilder()
                .withIdentifier("addData")
                .withAttribute("profileID", NetflixStatistix.getSessionData().getSelectedProfileID() + "")
                .withAttribute("percentage", percentage.getText())
                .withAttribute("programID", programid.getText())
                .post(this);

    }

    public void remove() {
        new PostBuilder()
                .withIdentifier("removeData")
                .withAttribute("profileID", NetflixStatistix.getSessionData().getSelectedProfileID() + "")
                .withAttribute("percentage", percentage.getText())
                .withAttribute("programID", programid.getText())
                .post(this);
    }
}

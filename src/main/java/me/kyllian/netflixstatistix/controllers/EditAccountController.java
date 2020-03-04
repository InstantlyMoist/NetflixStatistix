package me.kyllian.netflixstatistix.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import me.kyllian.netflixstatistix.NetflixStatistix;
import me.kyllian.netflixstatistix.post.PostBuilder;

import java.net.URL;
import java.util.ResourceBundle;

public class EditAccountController extends Controller implements Initializable {

    @FXML
    private Button submitButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new PostBuilder()
                .withIdentifier("getAccount")
                .withAttribute("email", NetflixStatistix.getSessionData().getEmail())
                .post(this);
    }

    @Override
    public void handleResponse(String response) {
        System.out.println(response);
    }

    public void back() {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/account.fxml"));
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}

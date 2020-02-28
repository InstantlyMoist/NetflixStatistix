package me.kyllian.netflixstatistix.controllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import me.kyllian.netflixstatistix.NetflixStatistix;

import java.net.URL;
import java.util.ResourceBundle;

public class EditAccountController extends Controller implements Initializable {


    //TODO update account buttin fixen

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void handleResponse(String response) {

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

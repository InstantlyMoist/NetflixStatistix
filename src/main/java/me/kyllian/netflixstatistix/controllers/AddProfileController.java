package me.kyllian.netflixstatistix.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import me.kyllian.netflixstatistix.NetflixStatistix;
import me.kyllian.netflixstatistix.post.PostBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class AddProfileController extends Controller {

    @FXML
    private Button addButton;

    @FXML
    private TextField userName;

    @FXML
    private TextField birthDate;


    public void addProfile() {
        boolean nameOK = Pattern.matches("(\\b[A-Z]{1}[a-z]+)", userName.getText());
        userName.setStyle(nameOK ? "-fx-border-color : green" : "-fx-border-color: red");

        boolean birthOK = Pattern.matches("\\d{2}-\\d{2}-\\d{4}", birthDate.getText());
        birthDate.setStyle(birthOK ? "-fx-border-color : green" : "-fx-border-color: red");
        Date date = null;
        try {
            date = (new SimpleDateFormat("dd-MM-yyyy").parse(birthDate.getText()));
        } catch (ParseException exc) {

        }
        if (birthOK && nameOK) {
            new PostBuilder()
                    .withIdentifier("addProfile")
                    .withAttribute("userID", NetflixStatistix.getSessionData().getUserID() + "")
                    .withAttribute("profileName", userName.getText())
                    .withAttribute("birthDate", new java.sql.Date(date.getTime()).toString())
                    .post(this);
        }
    }

    @Override
    public void handleResponse(String response) {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/profile.fxml"));
            root.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void back() {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/profile.fxml"));
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}

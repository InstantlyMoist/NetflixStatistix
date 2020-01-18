package me.kyllian.netflixstatistix.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import me.kyllian.netflixstatistix.NetflixStatistix;
import me.kyllian.netflixstatistix.post.PostBuilder;
import org.json.JSONObject;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class EditProfileController extends Controller implements Initializable {

    @FXML
    private TextField userName;

    @FXML
    private TextField birthDate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // load profiles
        new PostBuilder()
                .withIdentifier("getProfile")
                .withAttribute("userID", NetflixStatistix.getSessionData().getUserID() + "")
                .withAttribute("profileID", NetflixStatistix.getSessionData().getSelectedProfileID() + "")
                .post(this);
        //logo.setImage(new Image(getClass().getClassLoader().getResource("assets/logo.png").toExternalForm()));
    }

    public void updateProfile() {
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
                    .withIdentifier("updateProfile")
                    .withAttribute("profileID", NetflixStatistix.getSessionData().getSelectedProfileID() + "")
                    .withAttribute("profileName", userName.getText())
                    .withAttribute("birthDate", new java.sql.Date(date.getTime()).toString())
                    .post(this);
        }
    }

    @Override
    public void handleResponse(String response) {
        if (response.equalsIgnoreCase("OK")) {
            try {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/profile.fxml"));
                root.getStylesheets().add(getClass().getResource("/css/profile.css").toExternalForm());
                NetflixStatistix.parentWindow.getScene().setRoot(root);
            } catch (Exception exc) {
                exc.printStackTrace();
            }
            return;
        }
        JSONObject object = new JSONObject(response);
        userName.setText(object.getString("profile_name"));
        userName.commitValue();
        String receivedDate = object.getString("birth_date");
        String[] split = receivedDate.substring(0, 10).split("-");
        birthDate.setText(split[2] + "-" + split[1] + "-" + split[0]);
        birthDate.commitValue();
    }
}

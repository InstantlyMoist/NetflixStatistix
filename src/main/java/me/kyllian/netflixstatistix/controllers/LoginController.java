package me.kyllian.netflixstatistix.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import me.kyllian.netflixstatistix.exceptions.InputInvalidException;
import me.kyllian.netflixstatistix.exceptions.InvalidFieldType;
import me.kyllian.netflixstatistix.post.PasswordEncryptor;
import me.kyllian.netflixstatistix.post.PostBuilder;
import me.kyllian.netflixstatistix.user.User;
import me.kyllian.netflixstatistix.user.UserBuilder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends Controller implements Initializable {

    private boolean loggingIn;

    @FXML
    private ImageView logo;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Label registerText;

    @FXML
    private Button loginButton;

    public LoginController() {
        this.loggingIn = false;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logo.setImage(new Image(getClass().getClassLoader().getResource("assets/logo.png").toExternalForm()));
    }

    public void login() {
        if (loggingIn) return;
        loggingIn = true;
        loginButton.setText("Logging in...");
        new PostBuilder().withIdentifier("login")
                .withAttribute("email", email.getText())
                .withAttribute("password", PasswordEncryptor.encrypt(password.getText()))
                .post(this);
    }

    public void toRegister() {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/registration.fxml"));
            root.getStylesheets().removeAll();
            root.getStylesheets().add(getClass().getResource("/css/registration.css").toExternalForm());
            loginButton.getScene().setRoot(root);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public void handleResponse(String response) {
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                loggingIn = false;
                if (response.equalsIgnoreCase("INVALID_USER")) {
                    loginButton.setText("Invalid user");
                    return;
                }
                if (response.equalsIgnoreCase("INVALID_PASSWORD")) {
                    loginButton.setText("Invalid password");
                    return;
                }
                loginButton.setText("Login successful");
                try {
                    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/profile.fxml"));
                    root.getStylesheets().removeAll();
                    root.getStylesheets().add(getClass().getResource("/css/profile.css").toExternalForm());
                    loginButton.getScene().setRoot(root);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
}

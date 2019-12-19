package me.kyllian.netflixstatistix.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import me.kyllian.netflixstatistix.post.PasswordEncryptor;
import me.kyllian.netflixstatistix.post.PostBuilder;
import me.kyllian.netflixstatistix.user.User;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

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

    public HomeController() {
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
        //TODO Actually log in
    }

    public void toRegister() {
        System.out.println("Register text pressed!");
    }

    public void handleLogin(String response) {
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
                User user = new User(response);
                loginButton.setText("Login successful");
                //TODO: GOTO NEXT SCREEN, SAVE USER OBJECT?
            }
        });

    }
}

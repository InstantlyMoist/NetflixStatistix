package me.kyllian.netflixstatistix.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import me.kyllian.netflixstatistix.exceptions.InputInvalidException;
import me.kyllian.netflixstatistix.exceptions.InvalidFieldType;
import me.kyllian.netflixstatistix.post.PasswordEncryptor;
import me.kyllian.netflixstatistix.post.PostBuilder;
import me.kyllian.netflixstatistix.user.User;
import me.kyllian.netflixstatistix.user.UserBuilder;

public class LoginController {

    private boolean loggingIn = false;

    @FXML
    private Label target;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField emailField;

    @FXML
    protected void login(ActionEvent event) {
        if (loggingIn) return;
        target.setText("Logging in...");
        loggingIn = true;
        new PostBuilder().withIdentifier("login")
                .withAttribute("email", emailField.getText())
                .withAttribute("password", PasswordEncryptor.encrypt(passwordField.getText()))
                .post();
    }

    public void handleLogin(String response) {
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                loggingIn = false;
                System.out.println(response);
                if (response.equalsIgnoreCase("INVALID_USER")) {
                    target.setText("Invalid user");
                    return;
                }
                if (response.equalsIgnoreCase("INVALID_PASSWORD")) {
                    target.setText("Invalid password");
                    return;
                }
                User user = new User(response);
                target.setText("Login successful");
                //TODO: GOTO NEXT SCREEN, SAVE USER OBJECT?
            }
        });

    }
}

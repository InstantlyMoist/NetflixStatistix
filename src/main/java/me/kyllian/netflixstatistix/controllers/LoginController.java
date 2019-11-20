package me.kyllian.netflixstatistix.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import me.kyllian.netflixstatistix.exceptions.InputInvalidException;
import me.kyllian.netflixstatistix.user.User;
import me.kyllian.netflixstatistix.user.UserBuilder;

public class LoginController {

    @FXML
    private Label target;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField emailField;

    @FXML
    protected void login(ActionEvent event) {
        try {
            User user = new UserBuilder()
                    .withEmail(emailField.getText())
                    .withPassword(passwordField.getText())
                    .login();
            target.setText("Login succesfull!");
        } catch (InputInvalidException IIE) {
            target.setText("Login failed!");
            System.out.println(IIE.getFoundTypes());
        }
    }
}

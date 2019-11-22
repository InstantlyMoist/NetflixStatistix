package me.kyllian.netflixstatistix.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import me.kyllian.netflixstatistix.exceptions.InputInvalidException;
import me.kyllian.netflixstatistix.user.User;
import me.kyllian.netflixstatistix.user.UserBuilder;

public class RegistrationController {

    @FXML
    private Label target;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastname;
    @FXML
    private TextField adress;
    @FXML
    private TextField date;

    //@FXML
    /*protected void registration(ActionEvent event) {
        try {
            User user = new UserBuilder()
                    .withEmail(emailField.getText())
                    .withFirstName(firstName.getText())
                    .withLastName(lastname.getText())
                    //.withAdress()     moet kijken wat ik hierin ga zetten
                    //.withDate(date.getText())     moet kijken wat ik hierin ga zetten
                    .withPassword(passwordField.getText())
                    .login();
            target.setText("Login succesfull!");
        } catch (InputInvalidException IIE) {
            target.setText("Login failed!");
            System.out.println(IIE.getFoundTypes());
        }
    }*/


}

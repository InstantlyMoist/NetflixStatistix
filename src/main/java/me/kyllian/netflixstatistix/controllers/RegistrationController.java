package me.kyllian.netflixstatistix.controllers;
import com.sun.org.apache.xpath.internal.patterns.NodeTestFilter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import me.kyllian.netflixstatistix.exceptions.InputInvalidException;
import me.kyllian.netflixstatistix.user.User;
import me.kyllian.netflixstatistix.user.UserBuilder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {

    private boolean loggingIn;

    @FXML
    private ImageView logo;

    @FXML
    private TextField name;

    @FXML
    private TextField birth;

    @FXML
    private TextField repeatPassword;

    @FXML
    private TextField street;

    @FXML
    private TextField number;

    @FXML
    private String postalCode;

    @FXML
    private String residence;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Label registerText;

    @FXML
    private Button loginButton;

    @FXML
    private Button backButton;

    @FXML
    private Button submitButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logo.setImage(new Image(getClass().getClassLoader().getResource("assets/logo.png").toExternalForm()));
    }

    public void register(){
        //input validatie(geeft rood cringeltje als fout is)
//        if (accountNameField.getText().length() <= 32 && accountNameField.getText().length() > 0) {
//            accountName = accountNameField.getText();
//            accountNameField.setStyle("-fx-border-color: green");
//        } else {
//            accountNameField.setStyle("-fx-border-color: red");
//        }

    }



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

    public void back() {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/login.fxml"));
            root.getStylesheets().removeAll();
            root.getStylesheets().add(getClass().getResource("/css/login.css").toExternalForm());
            backButton.getScene().setRoot(root);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


}

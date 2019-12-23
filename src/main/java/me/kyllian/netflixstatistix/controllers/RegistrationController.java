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

import javax.xml.soap.Text;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class RegistrationController implements Initializable {

    private boolean loggingIn;

    @FXML
    private ImageView logo;

    @FXML
    private TextField nameField;

    @FXML
    private TextField birthField;

    @FXML
    private TextField repeatPasswordField;

    @FXML
    private TextField streetField;

    @FXML
    private TextField numberField;

    @FXML
    private TextField postalcodeField;

    @FXML
    private TextField residenceField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

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
        //controleert input, geeft rode kleur aan als input fout is en groene kleur als input goed is
        // er is aangegeven wat verwacht woord in de comments.

        //name validatie Voornaam + Achternaam
        nameField.setStyle(Pattern.matches("(\\b[A-Z]{1}[a-z]+)( )([A-Z]{1}[a-z]+\\b)", nameField.getText()) ? "-fx-border-color : green" : "-fx-border-color: red");

        //birthday validatie 00-00-0000
        birthField.setStyle(Pattern.matches("\\d{2}-\\d{2}-\\d{4}", birthField.getText()) ?"-fx-border-color : green" : "-fx-border-color: red");

        //password meer dan 7 characters
        if (passwordField.getLength() > 7){
            passwordField.setStyle("-fx-border-color: green");
        }else{
            passwordField.setStyle("-fx-border-color: red");
        }


        //password repeat password, hetzelfde als repeatpassword
        if (passwordField.getText().equals(repeatPasswordField.getText())){
            repeatPasswordField.setStyle("-fx-border-color: green");
        }else{
            repeatPasswordField.setStyle("-fx-border-color: red");
        }

        //street name, Straatnaam
        streetField.setStyle(Pattern.matches("^[A-Z].*", streetField.getText()) ?"-fx-border-color : green" : "-fx-border-color: red");

        //number
        numberField.setStyle(Pattern.matches("[0-9]+", numberField.getText()) ?"-fx-border-color : green" : "-fx-border-color: red");

        //postalcode, 0000AA
        if (Pattern.matches("^\\d{4}\\s?\\w{2}$", postalcodeField.getText())){
            postalcodeField.setStyle("-fx-border-color: green");
        }else{
            postalcodeField.setStyle("-fx-border-color: red");
        }

        //residence, Residence
        if (Pattern.matches("^[A-Z].*", residenceField.getText())){
            residenceField.setStyle("-fx-border-color: green");
        }else{
            residenceField.setStyle("-fx-border-color: green");
        }

        //email
        if (Pattern.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", emailField.getText())){
           emailField.setStyle("-fx-border-color: green");
        }else{
            emailField.setStyle("-fx-border-color: red");
        }

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

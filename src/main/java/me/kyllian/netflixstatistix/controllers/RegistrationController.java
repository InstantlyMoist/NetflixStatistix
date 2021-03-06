package me.kyllian.netflixstatistix.controllers;

import javafx.application.Platform;
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
import me.kyllian.netflixstatistix.NetflixStatistix;
import me.kyllian.netflixstatistix.post.PasswordEncryptor;
import me.kyllian.netflixstatistix.post.PostBuilder;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class RegistrationController extends Controller implements Initializable {

    private boolean registering;

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

    public String getStyle(boolean state) {
        return state ? "-fx-border-color : green" : "-fx-border-color: red";
    }

    public void registerValidation() {
        //controleert input, geeft rode kleur aan als input fout is en groene kleur als input goed is
        // er is aangegeven wat verwacht woord in de comments.

        //name validatie Voornaam + Achternaam
        boolean nameOK = Pattern.matches("(\\b[A-Z]{1}[a-z]+)( )([A-Z]{1}[a-z]+\\b)", nameField.getText());
        nameField.setStyle(getStyle(nameOK));

        //birthday validatie 00-00-0000
        boolean birthOK = Pattern.matches("\\d{2}-\\d{2}-\\d{4}", birthField.getText());
        birthField.setStyle(getStyle(birthOK));
        Date date = null;
        try {
            date = (new SimpleDateFormat("dd-MM-yyyy").parse(birthField.getText()));
        } catch (ParseException exc) {
            birthField.setStyle(getStyle(false));
            birthOK = false;
        }

        boolean passwordOK = passwordField.getLength() > 7;
        passwordField.setStyle(getStyle(passwordOK));

        //password repeat password, hetzelfde als repeatpassword
        boolean repeatOK = passwordField.getText().equals(repeatPasswordField.getText());
        repeatPasswordField.setStyle(getStyle(repeatOK));

        //street name, Straatnaam
        boolean streetOK = Pattern.matches("^[A-Z].*", streetField.getText());
        streetField.setStyle(getStyle(streetOK));

        //number
        boolean numberOK = Pattern.matches("[0-9]+", numberField.getText());
        numberField.setStyle(getStyle(numberOK));

        //postalcode, 0000AA
        boolean postalOK = Pattern.matches("^\\d{4}\\s?\\w{2}$+", postalcodeField.getText());
        postalcodeField.setStyle(getStyle(postalOK));

        //residence, Residence
        boolean residenceOK = Pattern.matches("^[A-Z].*", residenceField.getText());
        residenceField.setStyle(getStyle(residenceOK));

        //email
        boolean emailOK = Pattern.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", emailField.getText());
        emailField.setStyle(getStyle(emailOK));

        if (emailOK && residenceOK && postalOK && numberOK && streetOK && repeatOK && passwordOK && birthOK && nameOK) {
            submitButton.setText("Registering...");
            registering = true;
            new PostBuilder()
                    .withIdentifier("register")
                    .withAttribute("email", emailField.getText())
                    .withAttribute("street", streetField.getText())
                    .withAttribute("password", PasswordEncryptor.encrypt(passwordField.getText()))
                    .withAttribute("number", numberField.getText())
                    .withAttribute("postalcode", postalcodeField.getText())
                    .withAttribute("residence", residenceField.getText())
                    .withAttribute("firstname", nameField.getText().split(" ")[0])
                    .withAttribute("lastname", nameField.getText().split(" ")[1])
                    .withAttribute("birthdate", new java.sql.Date(date.getTime()).toString())
                    .post(this);
        }
    }

    public void back() {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/login.fxml"));
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void handleResponse(String response) {
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                registering = false;
                if (response.equalsIgnoreCase("USER_EXISTS")) {
                    submitButton.setText("User exists!");
                    return;
                }
                submitButton.setText("Register succes!");
                String userID = response.split(" ")[0];
                NetflixStatistix.getSessionData().setUserID(Integer.parseInt(userID));
                try {
                    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/profile.fxml"));
                    root.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
                    NetflixStatistix.parentWindow.getScene().setRoot(root);
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        });
    }
}

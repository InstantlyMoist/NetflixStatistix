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
import org.json.JSONException;
import org.json.JSONObject;

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
            root.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }


    @Override
    public void handleResponse(String response) {
        Platform.runLater(new Runnable() {
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
                    JSONObject object = new JSONObject(response.replace("[", "").replace("]", ""));
                    NetflixStatistix.getSessionData().setUserID(object.getInt("user_id"));
                } catch (JSONException exception) {
                    System.out.println("Error reading JSON from server");
                    exception.printStackTrace();
                }
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

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

public class ProfileController implements Initializable{

    @FXML
    private ImageView logo;

    @FXML
    private Label profileMainText;

    @FXML
    private Label profile1Text;

    @FXML
    private Label profile2Text;

    @FXML
    private Label profile3Text;

    @FXML
    private Label profile4Text;

    @FXML
    private Label profile5Text;

    @FXML
    private ImageView profilePicture1;

    @FXML
    private ImageView profilePicture2;

    @FXML
    private ImageView profilePicture3;

    @FXML
    private ImageView profilePicture4;

    @FXML
    private ImageView profilePicture5;

    @FXML
    private Button manageButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logo.setImage(new Image(getClass().getClassLoader().getResource("assets/logo.png").toExternalForm()));
        profilePicture1.setImage(new Image(getClass().getClassLoader().getResource("assets/profilePicture.png").toExternalForm()));
        profilePicture2.setImage(new Image(getClass().getClassLoader().getResource("assets/profilePicture.png").toExternalForm()));
        profilePicture3.setImage(new Image(getClass().getClassLoader().getResource("assets/profilePicture.png").toExternalForm()));
        profilePicture4.setImage(new Image(getClass().getClassLoader().getResource("assets/profilePicture.png").toExternalForm()));
        profilePicture5.setImage(new Image(getClass().getClassLoader().getResource("assets/profilePicture.png").toExternalForm()));
    }

    public void profile(){

    }
}

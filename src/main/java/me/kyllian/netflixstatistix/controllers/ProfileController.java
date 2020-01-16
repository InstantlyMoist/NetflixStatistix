package me.kyllian.netflixstatistix.controllers;

import com.sun.org.apache.xpath.internal.patterns.NodeTestFilter;
import javafx.application.Platform;
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
import me.kyllian.netflixstatistix.NetflixStatistix;
import me.kyllian.netflixstatistix.exceptions.InputInvalidException;
import me.kyllian.netflixstatistix.post.PostBuilder;
import me.kyllian.netflixstatistix.user.User;
import me.kyllian.netflixstatistix.user.UserBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.xml.soap.Text;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class ProfileController extends Controller implements Initializable {

    @FXML
    private ImageView logo;

    @FXML
    private Label profileMainText;

    private List<Label> texts;

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
        texts = new ArrayList<>(Arrays.asList(profile1Text, profile2Text, profile3Text, profile4Text, profile5Text));

        logo.setImage(new Image(getClass().getClassLoader().getResource("assets/logo.png").toExternalForm()));
        profilePicture1.setImage(new Image(getClass().getClassLoader().getResource("assets/profilePicture.png").toExternalForm()));
        profilePicture2.setImage(new Image(getClass().getClassLoader().getResource("assets/profilePicture.png").toExternalForm()));
        profilePicture3.setImage(new Image(getClass().getClassLoader().getResource("assets/profilePicture.png").toExternalForm()));
        profilePicture4.setImage(new Image(getClass().getClassLoader().getResource("assets/profilePicture.png").toExternalForm()));
        profilePicture5.setImage(new Image(getClass().getClassLoader().getResource("assets/profilePicture.png").toExternalForm()));

        new PostBuilder().withIdentifier("profiles")
                .withAttribute("userID", NetflixStatistix.getSessionData().getUserID() + "").post(this);
        //get data
    }

    @Override
    public void handleResponse(String response) {
        Platform.runLater(() -> {
            System.out.println(response);
            try {
                JSONArray array = new JSONArray(response);
                for (int i = 0; i != array.length(); i++) {
                    JSONObject profile = array.getJSONObject(i);
                    texts.get(i).setText(profile.getString("profile_name"));
                }
            } catch (JSONException exception) {
                System.out.println("Error reading JSON from server");
                exception.printStackTrace();
            }
        });
    }

    public void profile() {

    }
}

package me.kyllian.netflixstatistix.controllers;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import me.kyllian.netflixstatistix.NetflixStatistix;
import me.kyllian.netflixstatistix.post.PostBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.*;

public class ProfileController extends Controller implements Initializable {

    private boolean editing = false;
    private boolean deleting = false;

    @FXML
    private ImageView logo;

    @FXML
    private Label profileMainText;

    private List<Label> texts;
    private List<ImageView> images;
    private Map<ImageView, Integer> profileIDs;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        texts = new ArrayList<>(Arrays.asList(profile1Text, profile2Text, profile3Text, profile4Text, profile5Text));
        images = new ArrayList<>(Arrays.asList(profilePicture1, profilePicture2, profilePicture3, profilePicture4, profilePicture5));
        profileIDs = new HashMap<>();


        logo.setImage(new Image(getClass().getClassLoader().getResource("assets/logo.png").toExternalForm()));

        new PostBuilder().withIdentifier("profiles")
                .withAttribute("userID", NetflixStatistix.getSessionData().getUserID() + "").post(this);
        //get data

        images.forEach(image -> {
            image.setImage(new Image(getClass().getClassLoader().getResource("assets/logo.png").toExternalForm()));
            profileIDs.put(image, -1);
            image.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
                ImageView pressed = (ImageView) event.getTarget();
                int selected = profileIDs.get(pressed);
                if (selected == -1) {
                    System.out.println("Profile not exist, creating new one");
                    try {
                        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/addProfile.fxml"));
                        root.getStylesheets().add(getClass().getResource("/css/addProfile.css").toExternalForm());
                        NetflixStatistix.parentWindow.getScene().setRoot(root);
                    } catch (Exception exc) {
                        exc.printStackTrace();
                    }
                    return;
                }
                NetflixStatistix.getSessionData().setSelectedProfileID(selected);
                if (editing) {
                    try {
                        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/editProfile.fxml"));
                        root.getStylesheets().add(getClass().getResource("/css/editProfile.css").toExternalForm());
                        NetflixStatistix.parentWindow.getScene().setRoot(root);
                    } catch (Exception exc) {
                        exc.printStackTrace();
                    }
                    return;
                }
                if (deleting) {
                    new PostBuilder()
                            .withIdentifier("removeProfile")
                            .withAttribute("profileID", selected + "")
                            .post(this);
                    return;
                }
                //todo open stats
                //
                event.consume();
            });
        });


    }

    @Override
    public void handleResponse(String response) {
        if (response.equalsIgnoreCase("REM_OK")) {
            try {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/profile.fxml"));
                root.getStylesheets().add(getClass().getResource("/css/profile.css").toExternalForm());
                NetflixStatistix.parentWindow.getScene().setRoot(root);
            } catch (Exception exc) {
                exc.printStackTrace();
            }
            return;
        }
        Platform.runLater(() -> {
            System.out.println(response);
            try {
                JSONArray array = new JSONArray(response);
                for (int i = 0; i != array.length(); i++) {
                    JSONObject profile = array.getJSONObject(i);
                    profileIDs.put(images.get(i), profile.getInt("profile_id"));
                    texts.get(i).setText(profile.getString("profile_name"));
                }
            } catch (JSONException exception) {
                System.out.println("Error reading JSON from server");
                exception.printStackTrace();
            }
        });
    }

    public void reset() {
        profileMainText.setText("Who's watching");
        editing = false;
        deleting = false;
    }

    public void toggleEdit() {
        if (editing) {
            reset();
            return;
        }
        profileMainText.setText("Click to edit");
        editing = true;
        deleting = false;
    }

    public void toggleDelete() {
        if (deleting) {
            reset();
            return;
        }
        profileMainText.setText("Click to delete");
        editing = false;
        deleting = true;
    }

    public void testLogoExistence() {
        if(logo == null){
            System.out.println("NULL LOGO");
        }
        else{
            System.out.println("NOT NULL LOGO");
        }
    }
}

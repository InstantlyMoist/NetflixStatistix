package me.kyllian.netflixstatistix.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import me.kyllian.netflixstatistix.NetflixStatistix;
import me.kyllian.netflixstatistix.models.SerieModel;
import me.kyllian.netflixstatistix.models.SingleProfileModel;
import me.kyllian.netflixstatistix.post.PostBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AccountWithProfileController extends Controller implements Initializable {

    @FXML
    private TableView<SingleProfileModel> table;

    @FXML
    private TableColumn<SingleProfileModel, String> tableFirst;

    @FXML
    private TableColumn<SingleProfileModel, String> tableLast;

    @FXML
    private TableColumn<SingleProfileModel, String> tableMail;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new PostBuilder()
                .withIdentifier("singleProfiles")
                .post(this);
        tableFirst.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        tableLast.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        tableMail.setCellValueFactory(new PropertyValueFactory<>("Mail"));
    }

    @Override
    public void handleResponse(String response) {
        List<SingleProfileModel> singleProfileModels = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(response);
            for (int i = 0; i != array.length(); i++) {
                JSONObject data = array.getJSONObject(i);
                singleProfileModels.add(new SingleProfileModel(data.getString("first_name"), data.getString("last_name"), data.getString("email")));
            }
        } catch (JSONException exception) {
            System.out.println("Error reading JSON from server");
            exception.printStackTrace();
        }
        table.setItems(FXCollections.observableArrayList(singleProfileModels));
        System.out.println(response);
    }

    public void back() {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/profile.fxml"));
            root.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}

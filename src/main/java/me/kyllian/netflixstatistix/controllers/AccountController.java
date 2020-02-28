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
import me.kyllian.netflixstatistix.models.AccountModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AccountController extends Controller implements Initializable {

    @FXML
    private TableView<AccountModel> table;

    @FXML
    private TableColumn<AccountModel, String> tableFirstName;

    @FXML
    private TableColumn<AccountModel, String> tableLastName;

    @FXML
    private TableColumn<AccountModel, String> tableEMail;

    @FXML
    private TableColumn<AccountModel, Long> tableBirthDate;

    @FXML
    private TableColumn<AccountModel, String> tableStreet;

    @FXML
    private TableColumn<AccountModel, String> tableNumber;

    @FXML
    private TableColumn<AccountModel, String> tableResidence;

    //TODO Weergeeft op dit moment geen accounts als we erop klikken en buttons doen nog niks. deze buttons zijn edit, delete,create

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        tableLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        tableEMail.setCellValueFactory(new PropertyValueFactory<>("EMail"));
        tableBirthDate.setCellValueFactory(new PropertyValueFactory<>("BirthDate"));
        tableStreet.setCellValueFactory(new PropertyValueFactory<>("Street"));
        tableNumber.setCellValueFactory(new PropertyValueFactory<>("Number"));
        tableResidence.setCellValueFactory(new PropertyValueFactory<>("Residence"));
    }

    @Override
    public void handleResponse(String response) {
        List<AccountModel> accountModels = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(response);
            for (int i = 0; i != array.length(); i++) {
                JSONObject data = array.getJSONObject(i);
                accountModels.add(new AccountModel(data.getString("FirstName"), data.getString("LastName"), data.getString("EMail"), data.getLong("BirthDate"), data.getString("Street"), data.getString("Number"), data.getString("Residence")));
            }
        } catch (JSONException exception) {
            System.out.println("Error reading JSON from server");
            exception.printStackTrace();
            return;
        }
        table.setItems(FXCollections.observableArrayList(accountModels));
        System.out.println(response);
    }

    public void back() {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/statistic.fxml"));
            root.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}

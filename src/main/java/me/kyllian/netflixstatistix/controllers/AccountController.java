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
import me.kyllian.netflixstatistix.post.PostBuilder;
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


    //TODO  buttons doen nog niks. deze buttons zijn edit ,create

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        tableLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        tableEMail.setCellValueFactory(new PropertyValueFactory<>("EMail"));

        new PostBuilder()
                .withIdentifier("accounts")
                .post(this);
    }

    @Override
    public void handleResponse(String response) {
        if (response.equalsIgnoreCase("OK")) {
            try {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/account.fxml"));
                root.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
                NetflixStatistix.parentWindow.getScene().setRoot(root);
            } catch (Exception exc) {
                exc.printStackTrace();
            }
            return;
        }
        List<AccountModel> accountModels = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(response);
            for (int i = 0; i != array.length(); i++) {
                JSONObject data = array.getJSONObject(i);
                accountModels.add(new AccountModel(data.getString("first_name"), data.getString("last_name"), data.getString("email")));
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

    public void edit() {
        if (table.getSelectionModel().getSelectedItem() == null) return;
        NetflixStatistix.getSessionData().setEmail(table.getSelectionModel().getSelectedItem().getEMail());
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/editAccount.fxml"));
            root.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void delete() {
        if (table.getSelectionModel().getSelectedItem() == null) return;
        new PostBuilder()
                .withIdentifier("removeAccount")
                .withAttribute("email", table.getSelectionModel().getSelectedItem().getEMail())
                .post(this);
    }

    public void create() {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/registration.fxml"));
            root.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
            NetflixStatistix.parentWindow.getScene().setRoot(root);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}

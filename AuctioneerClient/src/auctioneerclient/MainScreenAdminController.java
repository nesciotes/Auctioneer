/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctioneerclient;

import auctioneer.DataService;
import auctioneer.Item;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NesciO
 */
public class MainScreenAdminController implements Initializable {

    @FXML
    private TextField tbName;
    @FXML
    private Label lblUsername;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnLogout;
    @FXML
    private Button btnHome;
    @FXML
    private ListView<String> lvQueue;
    @FXML
    private TextField tbDescription;
    @FXML
    private TextField tbPrice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUsername.setText(Login.user.getUsername());

        getMyAuctions();
    }

    private void getMyAuctions() {
        DataService service = new DataService();

        auctioneer.Data port = service.getDataPort();
        
        List<Item> queue = port.getMyQueue(Login.user.getUsername());
        lvQueue.getItems().clear();
        
        for(Item i : queue) {
            lvQueue.getItems().add(i.getName());
        }
    }

    @FXML
    private void addItem(ActionEvent event) {

        double price = Double.parseDouble(tbPrice.getText());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if (tbName.getText().length() < 1) {
            alert.setTitle("Adding auction failed");
            alert.setHeaderText("Something went wrong while trying to post an auction");
            alert.setContentText("You need to enter a name");
        } else if (tbDescription.getText().length() < 1) {
            alert.setTitle("Adding auction failed");
            alert.setHeaderText("Something went wrong while trying to post an auction");
            alert.setContentText("You need to enter a description");
        } else if (price < 0.01 || price > 10000) {
            alert.setTitle("Adding auction failed");
            alert.setHeaderText("Something went wrong while trying to post an auction");
            alert.setContentText("Please make sure the price is at least 0.01 and at most 10000.00 (use 2 decimals and a .)");
        } else {
            alert.setTitle("Success!");
            alert.setHeaderText("Your auction for " + tbName.getText() + " has been posted for €" + tbPrice.getText());
            alert.setContentText("");

            DataService service = new DataService();

            auctioneer.Data port = service.getDataPort();

            port.addItem(tbName.getText(), tbDescription.getText(), "", tbPrice.getText(), tbPrice.getText(), Login.user.getUsername());
            
            getMyAuctions();
        }

        alert.show();

    }

    @FXML
    private void logOut(ActionEvent event) {
        try {
            Login.user = null;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login2.fxml"));
            MainScreenController lc = loader.getController();
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = (Stage) btnLogout.getScene().getWindow();

            stage.setScene(scene);

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainScreenAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

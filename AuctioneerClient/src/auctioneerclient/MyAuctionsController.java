/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctioneerclient;

import auctioneer.DataService;
import auctioneer.Item;
import auctioneer.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NesciO
 */
public class MyAuctionsController implements Initializable {

    @FXML
    private Label lblUsername;
    @FXML
    private ImageView ivCurrent;
    @FXML
    private Button btnWon;
    @FXML
    private Button btnLogout;
    @FXML
    private Button btnHome;
    @FXML
    private ListView<Item> ttv;
    @FXML
    private ListView<Double> ttv1;
    @FXML
    private ListView<String> ttv2;
    @FXML
    private Button btnPaySelected;
    @FXML
    private Button btnPayAll;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUsername.setText(Login.user.getUsername());
        DataService service = new DataService();
        auctioneer.Data port = (auctioneer.Data) service.getDataPort();

        ttv.setCellFactory(param -> new ListCell<Item>() {
            @Override
            protected void updateItem(Item item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getName() == null) {
                    setText(null);
                } else {
                    setText(item.getName());
                }
            }
        });

        ttv1.setCellFactory(param -> new ListCell<Double>() {
            @Override
            protected void updateItem(Double item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item == null) {
                    setText(null);
                } else {
                    setText(item.toString());
                }
            }
        });

        ttv2.setCellFactory(param -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item == null) {
                    setText(null);
                } else {
                    setText(item);
                }
            }
        });

        getMyAuctions(port);
    }

    protected void getMyAuctions(auctioneer.Data port) {
        //List<auctioneer.Item> myAuctions = port.getMyAuctions();
        System.out.println(Login.user);
        User user = port.getAccountInfo(Login.user.getUsername());

        List<User.WonItems.Entry> wonItems = user.getWonItems().getEntry();

        for (User.WonItems.Entry e : wonItems) {
            ttv.getItems().add(e.getKey());
            ttv1.getItems().add(e.getValue().doubleValue());
            ttv2.getItems().add(e.getKey().isPaid() ? "Yes" : "No");
        }

    }

    @FXML
    private void home(ActionEvent event) {
        try {
            Parent root;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
            MainScreenController lc = loader.getController();
            root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = (Stage) btnHome.getScene().getWindow();

            stage.setScene(scene);

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MyAuctionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        Login.user = null;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login2.fxml"));
        MainScreenController lc = loader.getController();
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = (Stage) btnLogout.getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }

    @FXML
    private void payAll(ActionEvent event) throws IOException {
        DataService service = new DataService();
        auctioneer.Data port = (auctioneer.Data) service.getDataPort();

        User user = port.getAccountInfo(Login.user.getUsername());

        List<User.WonItems.Entry> wonItems = user.getWonItems().getEntry();

        double totalAmount = 0;

        for (User.WonItems.Entry e : wonItems) {
            if (!e.getKey().isPaid()) {
                totalAmount += e.getValue();
            }
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Payment required");
        alert.setHeaderText("Please send your payment through bank transfer (€" + totalAmount + ")");
        alert.setContentText("Please send €" + totalAmount + " to IBAN NL07INGB0009003822 with name 'De Hr RMTJ Clark' and we will process your payment as soon as possible.");
        alert.show();

        for (User.WonItems.Entry e : wonItems) {
            if (!e.getKey().isPaid()) {
                port.itemPaid(e.getKey(), Login.user.getUsername());
            }
        }
    }

}

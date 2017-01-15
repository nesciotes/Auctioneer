package auctioneerclient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import auctioneer.DataService;
import controllers.User;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * FXML Controller class
 *
 * @author NesciO
 */
public class LoginController implements Initializable {

    @FXML

    private TextField tbUsername;
    @FXML

    private TextField tbPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private TextField tbUsername4;
    @FXML
    private TextField tbPassword4;
    @FXML
    private TextField tbAdress;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void login(ActionEvent event) throws IOException {
        DataService service = new DataService();

        auctioneer.Data port = service.getDataPort();

        String username = tbUsername.getText();
        String password = tbPassword.getText();

        auctioneer.User acc = port.login(username, password);
        if (acc != null) {
            Date date = new Date();
            User user = new User(acc.getUsername(), date, acc.getPassword(), "home");

            if (user.getId() != -1) {
                Login.user = acc;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
                MainScreenController lc = loader.getController();
                Parent root = loader.load();

                Scene scene = new Scene(root);
                Stage stage = (Stage) btnLogin.getScene().getWindow();

                stage.setScene(scene);

                stage.show();
            }
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Login failed");
            alert.setHeaderText("Your login has failed");
            alert.setContentText("Please check your account details and try again");
            alert.show();
        }

    }

    @FXML
    private void register(ActionEvent event) {
        DataService service = new DataService();

        auctioneer.Data port = service.getDataPort();

        User u = new User();
        u.setUsername(tbUsername4.getText());
        u.setAddress(tbAdress.getText());
        u.setPassword(tbPassword4.getText());

        SaltyPassword sp = new SaltyPassword();

        byte[] salt = sp.getSalt();

        u.setSalt(salt);
        port.addUser(u.getUsername(), u.getPassword());
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Register successful");
        alert.setHeaderText("Your registry as " + tbUsername4.getText() + " was successful");
        alert.setContentText("You can now log in");
        alert.show();
    }

}

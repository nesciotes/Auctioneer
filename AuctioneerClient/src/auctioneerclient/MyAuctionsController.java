/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctioneerclient;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.ImageView;

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
    private TreeTableView<?> ttv;
    @FXML
    private Button btnPaySelected;
    @FXML
    private Button btnPayAll;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void chat(ActionEvent event) {
    }


    @FXML
    private void logOut(ActionEvent event) {
    }
    
}

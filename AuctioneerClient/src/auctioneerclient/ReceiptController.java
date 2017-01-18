/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctioneerclient;

import auctioneer.DataService;
import controllers.Decryption;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javax.crypto.NoSuchPaddingException;

/**
 * FXML Controller class
 *
 * @author NesciO
 */
public class ReceiptController implements Initializable {

    @FXML
    private ImageView ivCurrent;
    @FXML
    private Button btnWon1;
    @FXML
    private Label lblUsername;
    @FXML
    private Label lblAmount;
    @FXML
    private Label lblUsername2;
    @FXML
    private Label lblDate;
    @FXML
    private Label lvlCode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            lblUsername.setText(Login.user.getUsername());
            lblUsername2.setText(Login.user.getUsername());
            
            lblAmount.setText("€" + Login.securePaymentAmount + "");
            
            String[] dateInfo = new Date().toString().split(" ");
            lblDate.setText(dateInfo[0] + " " + dateInfo[1] + " " + dateInfo[2]);
            
            //Encrypted payment code
            System.out.println(Login.securePaymentCode);
            
            String code = Decryption.decrypt(Login.securePaymentCode);
            
            lvlCode.setText(code);
            
            Login.securePaymentAmount = 0l;
            Login.securePaymentCode = null;
        } catch (InvalidKeyException ex) {
            Logger.getLogger(ReceiptController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ReceiptController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(ReceiptController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ReceiptController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

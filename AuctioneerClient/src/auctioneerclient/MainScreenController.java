/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctioneerclient;

import auctioneer.DataService;
import auctioneer.User;
import controllers.Item;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import javax.jws.WebService;
import static org.apache.commons.beanutils.BeanUtils.copyProperties;

/**
 * FXML Controller class
 *
 * @author NesciO
 */
@WebService

public class MainScreenController implements Initializable {

    @FXML
    private TextField tbChat;
    @FXML
    private Button btnSendchat;
    @FXML
    private Label lblUsername;
    @FXML
    private Label lblCurrentName;
    @FXML
    private Label lblCurrentTime;
    @FXML
    private ListView<?> lvChat;
    @FXML
    private ImageView ivCurrent;
    @FXML
    private Label lblCurrent;
    @FXML
    private Label lblCurrentAmount;
    @FXML
    private TextField tbBid;
    @FXML
    private Button btnBid;

    boolean uistate;

    int timesWaited;
    @FXML
    private ImageView ivFinished1;
    @FXML
    private Label lblFinishedlbl1;
    @FXML
    private Label lblCurrentName1;
    @FXML
    private Label lblFinished1;
    @FXML
    private Label lblFinishedPrice1;
    @FXML
    private ImageView ivFinished2;
    @FXML
    private Label lblFinishedlbl2;
    @FXML
    private Label lblCurrentName11;
    @FXML
    private Label lblFinished2;
    @FXML
    private Label lblFinishedPrice2;
    @FXML
    private ImageView ivFinished3;
    @FXML
    private Label lblFinishedlbl3;
    @FXML
    private Label lblCurrentName12;
    @FXML
    private Label lblFinished3;
    @FXML
    private Label lblFinishedPrice3;
    @FXML
    private Button btnWon;
    @FXML
    private Button btnLogout;
    @FXML
    private Button btnHome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timesWaited = 0;

        lblUsername.setText(Login.user.getUsername());

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);

        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        tick();
                    }
                }));
        timeline.play();

    }

    protected void tick() {
        try {
            DataService service = new DataService();
            auctioneer.Data port = (auctioneer.Data) service.getDataPort();

            getCurrentAuction(port);
            getChat(port);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void getCurrentAuction(auctioneer.Data port) {
        auctioneer.Item currentAuction = port.getCurrent();

        waitServerResponse(currentAuction, 5000, port);

        if (currentAuction != null) {

            lblCurrentName.setText(currentAuction.getName());
            lblCurrent.setText(currentAuction.getDescription());
            lblCurrentAmount.setText("€" + currentAuction.getCurrentBid());

            int minutes = (int) Math.floor(currentAuction.getRemainingTime() / 60);
            String seconds = String.format("%02d", currentAuction.getRemainingTime() % 60);
            lblCurrentTime.setText(minutes + ":" + seconds);
            ivCurrent.setVisible(true);

            timesWaited = 0;

        } else /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Oops");
            alert.setHeaderText("Something went wrong...");
            alert.setContentText("There seems to be a problem with the server, please try again later");
            alert.show();*/ if (timesWaited < 10) {
            lblCurrentName.setText("Fetching item...");
            lblCurrent.setText("...");
            lblCurrentAmount.setText("");
            lblCurrentTime.setText("...");
            ivCurrent.setVisible(false);

            timesWaited++;

        } else {
            lblCurrentName.setText("Closed");
            lblCurrent.setText("There are currently no available auctions");
            lblCurrentAmount.setText("");
            lblCurrentTime.setText("");
            ivCurrent.setVisible(false);
        }
    }

    protected void getChat(auctioneer.Data port) {
        List<String> chat = port.getChat();

        ObservableList chat_temp = FXCollections.observableArrayList();
        int max = 5;
        if (chat.size() < 5) {
            max = chat.size();
        }
        if (max > 0) {
            for (int i = chat.size() - max, j = chat.size(); i < j; i++) {
                chat_temp.add(chat.get(i));
            }
        }
        lvChat.setItems(chat_temp);

    }

    protected void waitServerResponse(Object value, int maxTime, auctioneer.Data port) {
        /*
            double startWaittime = System.currentTimeMillis();

            while (System.currentTimeMillis() < startWaittime + maxTime && value == null) {
                try {
                    Thread.sleep(500);
                    value = port.getCurrent();
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/

    }

    @FXML
    private void bid(ActionEvent event) throws IOException {
        DataService service = new DataService();
        auctioneer.Data port = (auctioneer.Data) service.getDataPort();


        boolean bidSuccess = port.placeBid(Login.user, tbBid.getText());

        if (!bidSuccess) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Oops");
            alert.setHeaderText("Something went wrong...");
            alert.setContentText("Check if your bid is a valid number (format: 2.65) and that there isn't already a higher bid!");
            alert.show();
        }
    }

    @FXML
    private void chat(ActionEvent event) throws IOException {
        DataService service = new DataService();
        auctioneer.Data port = (auctioneer.Data) service.getDataPort();

        port.addMessage(Login.user.getUsername() + ": " + tbChat.getText());
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctioneer;

import controllers.Controller;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.xml.ws.Endpoint;

/**
 *
 * @author NesciO
 */
public class Auctioneer extends Application {

    public static IData Data;

    private static final String url = "http://localhost:8080/auctioneer";

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Data = new Data();
            Endpoint.publish(url, Data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        initialize();
    }

    private void initialize() {
             

        int delay = 1000;   
        int interval = 1000; 
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                Data.getAllAuctions();

            }
        }, delay, interval);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}

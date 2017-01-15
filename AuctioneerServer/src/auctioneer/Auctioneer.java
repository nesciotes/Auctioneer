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
        initi();
    }

    private void initi() {
        Data.addItem("testitem1", "123", "ba", "1.55", "2.75");
        Data.addItem("testitem2", "123", "ba", "11.15", "2.75");
        Data.addItem("testitem3", "123", "ba", "25.00", "2.75");

        int delay = 5000;   // delay for 5 sec.
        int interval = 1000;  // iterate every sec.
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                Data.getAllAuctions();

            }
        }, delay, interval);

        /*        Data.addProduct(new HardwareProduct("Razer Megalodon", 150.0, "V2"));
        Data.addProduct(new HardwareProduct("Razer Deathadder", 50.0, "Green"));
        Data.addProduct(new HardwareProduct("Steelseries Siberia", 130.0, "Arctic"));
        Data.addProduct(new SoftwareProduct("WOTLK", 60.0, 3.55));
        Data.addProduct(new SoftwareProduct("Duck Hunt!!", 19.95, 4.20));
        Data.addProduct(new SoftwareProduct("ZWindows", 1130.0, 13.37));

        Account hacks = new Account("admin", "admin");
        Customer c = new Customer("Lucario", "RidolioLaan 420");
        Data.addCustomer(c);
        hacks.setCustomer(c);
        Data.addAccount("admin", "admin", "lucario", "1");*/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}

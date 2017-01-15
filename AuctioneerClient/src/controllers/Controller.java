/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author NesciO
 */
public class Controller {

    private static Controller controller = null;

    private LinkedList<Item> auctions;
    private Timer tick;

    private Item currentAuction;
    private Item lastAuction;
    
    private final int minimumTime;

    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    /**
     * Instantiates singleton Controller
     * Schedules tick method every second
     */
    private Controller() {
        this.auctions = new LinkedList<>();
        this.currentAuction = null;
        this.tick = new Timer();
        this.minimumTime = 60;

        tick.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        }, 1000, 1000);
    }

    public LinkedList getAuctions() {
        return auctions;
    }

    public void setAuctions(LinkedList auctions) {
        this.auctions = auctions;
    }

    /**
     * Main method of the controller, will be called every second and run through all steps required 
     */
    private void tick() {
        //Start an auction if no auction is currently running
        if (this.currentAuction == null && this.auctions.size() > 0) {
            currentAuction = auctions.getFirst();
            auctions.remove(auctions.getFirst());
        }
        //If an auction is running, subtract 1 second from the remaining time
        if (this.currentAuction != null) {
            if (this.currentAuction.getRemainingTime() > 0) {
                this.currentAuction.setRemainingTime(currentAuction.getRemainingTime() - 1);
            } else if (this.currentAuction.getRemainingTime() <= 0) {
                closeAuction();
            }
        }
    }

    /**
     * Add an auction to the queue
     * 
     * @param name
     * @param startingprice
     * @param remainingTime
     * @param user
     * @param minimumPrice
     * @return true if adding auction succeeded, else return false
     */
    public boolean addAuction(String name, double startingprice, int remainingTime, Admin user, double minimumPrice) {
        //Extra check to see if user has rights to place new auction
        if (user.getType() == Admin.ADMINTYPE.DISTRIBUTOR) {
            int time = (remainingTime >= this.minimumTime) ? remainingTime : this.minimumTime;
            this.auctions.add(new Item(name, startingprice, minimumPrice, time));
            return true;
        }
        return false;
    }

    /**
     * Add a bid to the current running auction
     * 
     * @param item
     * @param user
     * @param amount
     * @return true if adding bid succeeded, else return false
     */
    public boolean addBid(Item item, controllers.User user, double amount) {
        //Extra check to see if bid amount is higher than current highest bid (for desync security purposes)
        /*if (item.getHighestBid().getAmount() < amount) {
            item.addBid(new Bid(amount, item, user));
            return true;
        }*/
        return false;
    }

    /**
     * If timer expired, close auction
     */
    private void closeAuction() {
        this.currentAuction.getHighestBidder().addItem(currentAuction.getHighestBid());
        this.lastAuction = currentAuction;
        this.currentAuction = null;
    }

    public Item getCurrentAuction() {
        return currentAuction;
    }

    public Item getLastAuction() {
        return lastAuction;
    }
    
    
}

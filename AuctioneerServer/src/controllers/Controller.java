/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import auctioneer.Data;
import java.util.ArrayList;
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

    private List<Item> auctions;
    private Timer tick;

    private Item currentAuction;
    private Item lastAuction;

    private final int minimumTime;

    private List<String> chat;

    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    /**
     * Instantiates singleton Controller Schedules tick method every second
     */
    private Controller() {
        this.auctions = new LinkedList<>();
        this.currentAuction = null;
        this.tick = new Timer();
        this.minimumTime = 60;
        this.chat = new ArrayList<>();

        tick.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        }, 1000, 1000);
    }

    public List getAuctions() {
        return auctions;
    }

    public void setAuctions(LinkedList auctions) {
        this.auctions = auctions;
    }

    public void updateAuctions(List<Item> items) {
        this.auctions = (List<Item>) items;
    }

    /**
     * Main method of the controller, will be called every second and run
     * through all steps required
     */
    private void tick() {

        //Start an auction if no auction is currently running
        if (this.currentAuction == null && this.auctions.size() > 0) {
            currentAuction = auctions.get(0);
            auctions.remove(auctions.get(0));
        }
        //If an auction is running, subtract 1 second from the remaining time
        if (this.currentAuction != null) {
            if (this.currentAuction.getRemainingTime() > 0) {
                this.currentAuction.setRemainingTime(currentAuction.getRemainingTime() - 1);
                Data.updateItem(currentAuction);

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
    public boolean addAuction(Item item) {

        this.auctions.add(item);
        return true;

    }

    /**
     * Add a bid to the current running auction
     *
     * @param item
     * @param user
     * @param amount
     * @return true if adding bid succeeded, else return false
     */
    public boolean addBid(Item item, User user, double amount) {
        //Extra check to see if bid amount is higher than current highest bid (for desync security purposes)
        if (item != null) {
            if (item.getHighestBid() != null) {
                if (item.getHighestBid().getAmount() < amount && amount > item.getStartingPrice()) {
                    item.addBid(new Bid(amount, item, user));
                    item.setCurrentBid(amount);
                    Data.updateItem(currentAuction);
                    Data.itemWon(item, user.getUsername());

                    return true;
                }
            } else if (amount > item.getStartingPrice()) {
                item.addBid(new Bid(amount, item, user));
                item.setCurrentBid(amount);

                Data.updateItem(currentAuction);
                Data.itemWon(item, user.getUsername());

                return true;
            }
        }
        return false;
    }

    /**
     * If timer expired, close auction
     */
    private void closeAuction() {
        this.lastAuction = currentAuction;

        currentAuction.setActive(false);
        Data.updateItem(currentAuction);

        if (this.currentAuction.getBids() != null) {
            if (this.currentAuction.getBids().size() > 0) {
                User u = this.currentAuction.getHighestBidder();
                u = Data.getAccountInfoLocal(u.getUsername());
                u.addItem(currentAuction.getHighestBid());
                Data.persist(u);

            }
        }

        this.currentAuction = null;

    }

    public Item getCurrentAuction() {
        return currentAuction;
    }

    public Item getLastAuction() {
        return lastAuction;
    }

    public List<String> getChat() {
        return chat;
    }

}

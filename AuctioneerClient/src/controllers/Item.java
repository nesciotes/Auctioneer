/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author NesciO
 */
public class Item implements Serializable {

    private String name;
    private String description;
    private double startingPrice;
    private double minimumPrice;
    private int remainingTime;
    private double currentBid;

    private List<Bid> bids;

    private int id;

    private boolean active;

    public Item(String name, double startingPrice, int remainingTime) {
        this.name = name;
        this.startingPrice = startingPrice;
        this.remainingTime = remainingTime;
        this.bids = new ArrayList<>();
        this.currentBid = this.startingPrice;
        this.active = true;
    }

    public Item(String name, double startingPrice, double minimumPrice, int remainingTime) {
        this.name = name;
        this.startingPrice = startingPrice;
        this.minimumPrice = minimumPrice;
        this.remainingTime = remainingTime;
        this.currentBid = this.startingPrice;
        this.active = true;

    }
    
    

    public Item() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public double getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(double minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public List<Bid> getBids() {
        return this.bids;
    }

    public void setBids(LinkedList bids) {
        this.bids = bids;
    }

    public void addBid(Bid bid) {
        this.bids.add(bid);
    }

    public Bid getHighestBid() {
        return this.bids.get(bids.size() - 1);
    }

    public User getHighestBidder() {
        return this.bids.get(bids.size() - 1).getUser();
    }

    public double getCurrentBid() {
        return this.currentBid;
    }
    
    

}

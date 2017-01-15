/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author NesciO
 */
public class Bid {

    private double amount;
    private boolean highest;

    private Item item;

    private User user;

    private int id;

    public Bid(double amount, Item item, User user) {
        this.amount = amount;
        this.item = item;
        this.user = user;
        this.highest = true;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isHighest() {
        return highest;
    }

    public Item getItem() {
        return item;
    }

    public User getUser() {
        return user;
    }

    public void setHighest(boolean highest) {
        this.highest = highest;
    }
    
    
    public User returnUser() {
        return user;
    }

}

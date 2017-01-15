/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.Serializable;
import javax.persistence.*;


/**
 *
 * @author NesciO
 */
@Entity
public class Bid implements Serializable{
    
    private double amount;
    private boolean highest;
    
    @ManyToOne
    private Item item;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    
    @Id
    @GeneratedValue
    private int id;

    public Bid(double amount, Item item, User user) {
        this.amount = amount;
        this.item = item;
        this.user = user;
        this.highest = true;
    }

    public Bid() {
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
    
    
    
}

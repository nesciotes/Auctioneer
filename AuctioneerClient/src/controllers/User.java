/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author NesciO
 */
public class User extends User_parent {
    
    private String address;
    private byte[] salt;
    
    
    private HashMap<Item, Double> wonItems;
    
    
    public User(String username, Date registrydate, String password, String address) {
        super(username, registrydate, password);
        
        wonItems = new HashMap<>();
    }

    public User() {

    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HashMap<Item, Double> getWonItems() {
        return wonItems;
    }

    public void setWonItems(HashMap<Item, Double> wonItems) {
        this.wonItems = wonItems;
    }
    
    public void addItem(Bid bid) {
        this.wonItems.put(bid.getItem(), bid.getAmount());
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public byte[] getSalt() {
        return salt;
    }
    
    
    
     @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        User a = (User) obj;
        return a.getPassword().equals(this.getPassword()) && a.getUsername().equals(this.getUsername());
    }
    
}

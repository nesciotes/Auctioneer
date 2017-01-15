/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.*;

/**
 *
 * @author NesciO
 */
@Entity
@Table(name = "User")
public class User extends User_parent implements Serializable {

    private String address;
    private byte[] salt;

    @Lob
    private HashMap<Item, Double> wonItems;

    public User(String username, Date registrydate, String password, String address) {
        super(username, registrydate, password);

        wonItems = new HashMap<>();
    }

    public User() {
        wonItems = new HashMap<>();

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

}

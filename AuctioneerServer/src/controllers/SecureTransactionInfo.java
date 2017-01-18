/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author NesciO
 */
@Entity
public class SecureTransactionInfo {
    
    private String username;
    private double amount;
    private String secureCode;
    
    @Id
    @GeneratedValue
    private int id;

    public SecureTransactionInfo(String username, double amount, String secureCode) {
        this.username = username;
        this.amount = amount;
        this.secureCode = secureCode;
    }

    public SecureTransactionInfo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSecureCode() {
        return secureCode;
    }

    public void setSecureCode(String secureCode) {
        this.secureCode = secureCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
     
}

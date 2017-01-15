/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import javax.persistence.*;


/**
 *
 * @author NesciO
 */
@Entity
public class Distributor {
    
    private String name;
    private String address;
    
    @OneToOne
    private Admin account;
    
    @Id
    @GeneratedValue
    private int id;

    public Distributor(String name, String address, Admin account) {
        this.name = name;
        this.address = address;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Admin getAccount() {
        return account;
    }
    
    
}

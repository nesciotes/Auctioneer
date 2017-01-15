/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.persistence.*;

import java.util.Date;

/**
 *
 * @author NesciO
 */
@Entity
public abstract class User_parent {
    
    private String username;
    private Date registrydate;
    private String password;
    
    @Id
    @GeneratedValue
    private int id;
    
    public User_parent() {
        
    }

    public User_parent(String username, Date registrydate, String password) {
        this.username = username;
        this.registrydate = registrydate;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public Date getRegistrydate() {
        return registrydate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
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

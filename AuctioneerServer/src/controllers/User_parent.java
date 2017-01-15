/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.persistence.*;

import java.util.Date;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author NesciO
 */
@Entity
@XmlSeeAlso({User.class, Admin.class})
public abstract class User_parent {

    private String username;
    private Date registrydate;
    private String password;

    private byte[] salt;

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

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public byte[] getSalt() {
        return salt;
    }

    @Override
    public boolean equals(Object obj) {
        User_parent a = null;
        
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof User) && !(obj instanceof Admin)) {
            return false;
        } else if (obj instanceof User) {
            a = (User) obj;
        } else if (obj instanceof Admin) {
            a = (Admin) obj;
        }
        if (obj == this) {
            return true;
        }

        return a.getPassword().equals(this.getPassword()) && a.getUsername().equals(this.getUsername());
    }
}

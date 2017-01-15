/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author NesciO
 */
@Entity
public class Admin extends User_parent {

    public enum ADMINTYPE {
        DISTRIBUTOR,
        JANITOR,
        HEADADMIN
    }

    private ADMINTYPE type;
    

    public Admin(String username, Date registrydate, String password) {
        super(username, registrydate, password);

        this.type = type;
    }
    
    public Admin() {
        
    }

    public ADMINTYPE getType() {
        return type;
    }

    public void setType(ADMINTYPE type) {
        this.type = type;
    }
    
    

}

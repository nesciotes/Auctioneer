/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctioneer;

import controllers.Item;
import controllers.User;
import java.util.List;

/**
 *
 * @author NesciO
 */
public interface IData {

    User login(String username, String password);

    void addUser(String username, String password);

    Item getCurrent();

    void addItem(String name, String description, String imagepath, String startingprice, String mininumprice);


    List<Item> getAllAuctions();
    
    List<String> getChat();
    
    void addMessage(String message);
    
    boolean placeBid(User user, String amount);

}

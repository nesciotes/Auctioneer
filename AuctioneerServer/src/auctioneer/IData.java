/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctioneer;

import controllers.Bid;
import controllers.Item;
import controllers.User;
import controllers.User_parent;
import java.util.List;

/**
 *
 * @author NesciO
 */
public interface IData {

    User_parent login(String username, String password);

    void addUser(String username, String password);

    Item getCurrent();

    void addItem(String name, String description, String imagepath, String startingprice, String mininumprice, String username);


    List<Item> getAllAuctions();
    
    List<Item> getPastAuctions();
    
    List<String> getChat();
    
    void addMessage(String message);
    
    boolean placeBid(User_parent user, String amount);
    
    Bid getHighestBidForAuction(int placeInList);
    
    List<Item> getMyAuctions();
    
    User getAccountInfo(String username);
    
    void itemPaid(Item item, String username);
    
    List<Item> getMyQueue(String ownerName);

}

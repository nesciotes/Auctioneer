/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctioneer;

import controllers.Controller;
import controllers.Item;
import controllers.SaltyPassword;
import controllers.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.jws.WebService;
import javax.persistence.*;

/**
 *
 * @author NesciO
 */
@WebService
public class Data implements IData {

    public static EntityManagerFactory em;

    public static User user;

    public Data() {
        this.em = Persistence.createEntityManagerFactory("auctioneer");
    }

    @Override
    public void addUser(String username, String password) {
        Date today = new Date();
        User c = new User(username, today, password, "home");

        SaltyPassword sp = new SaltyPassword();

        byte[] salt = sp.getSalt();
        String hashedPassword = sp.getSecurePassword(password, salt);

        c.setPassword(hashedPassword);
        c.setSalt(salt);

        persist(c);
    }

    public static void persist(Object o) {
        EntityManager em_temp = em.createEntityManager();

        em_temp.getTransaction().begin();
        em_temp.merge(o);
        em_temp.getTransaction().commit();

        em_temp.close();
    }

    @Override
    public User login(String username, String password) {
        EntityManager em_temp = this.em.createEntityManager();

        User login = new User();
        login.setUsername(username);
        login.setPassword(password);

        Object acc = null;

        try {
            acc = em_temp.createQuery(
                    "SELECT OBJECT(u) FROM User_parent u WHERE u.username = :username")
                    .setParameter("username", username)
                    .getSingleResult();
            em_temp.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (acc == null) {
            return null;
        }
        User a_temp = (User) acc;
        User a = new User();

        a.setUsername(a_temp.getUsername());
        a.setPassword(a_temp.getPassword());
        a.setId(a_temp.getId());
        a.setAddress(a_temp.getAddress());
        a.setSalt(a_temp.getSalt());
        a.setWonItems(a_temp.getWonItems());

        SaltyPassword sp = new SaltyPassword();
        login.setPassword(sp.getSecurePassword(password, a_temp.getSalt()));
        if (login.equals(a)) {
            login = a;
            return login;
        }
        return null;
    }

    @Override
    public Item getCurrent() {
        /*em.getEntityManagerFactory().getCache().evictAll();

        Object item = null;

        try {
            item = em.createQuery(
                    "SELECT i FROM Item i WHERE i.id = :id")
                    .setParameter("id", 1)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (item == null) {
            return null;
        }
        return (Item) item;*/

        return Controller.getController().getCurrentAuction();
    }

    @Override
    public List<Item> getAllAuctions() {
        EntityManager em_temp = this.em.createEntityManager();

        Object items = null;

        try {
            items = em_temp.createQuery(
                    "SELECT i FROM Item i WHERE active = true")
                    .getResultList();
            em_temp.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (items == null) {
            return null;
        }
        Controller.getController().updateAuctions((List<Item>) items);
        return (List<Item>) items;
    }

    @Override
    public void addItem(String name, String description, String imagepath, String startingprice, String mininumprice) {
        Item item = new Item();
        item.setName(name);
        item.setDescription(description);
        item.setMinimumPrice(Double.parseDouble(mininumprice));
        item.setStartingPrice(Double.parseDouble(startingprice));
        item.setCurrentBid(Double.parseDouble(startingprice));
        item.setRemainingTime(40);
        item.setActive(true);

        persist(item);

        //Controller.getController().addAuction(item);
    }

    public static void updateItem(Item item) {
      EntityManager em_temp = em.createEntityManager();

        em_temp.getTransaction().begin();
        em_temp.merge(item);
        em_temp.getTransaction().commit();

        em_temp.close();
    }

    @Override
    public List<String> getChat() {
        return Controller.getController().getChat();
    }

    @Override
    public void addMessage(String message) {
        Controller.getController().getChat().add(message);
    }

    @Override
    public boolean placeBid(User user, String amount) {
        double amount_tmp;
        try {
            amount_tmp = Double.parseDouble(amount);

        } catch (Exception e) {
            return false;
        }
        return Controller.getController().addBid(Controller.getController().getCurrentAuction(), user, amount_tmp);
    }
}

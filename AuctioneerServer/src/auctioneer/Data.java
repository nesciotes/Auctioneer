/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctioneer;

import controllers.Admin;
import controllers.Bid;
import controllers.Controller;
import controllers.Item;
import controllers.SaltyPassword;
import controllers.User;
import controllers.User_parent;
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

        //Dummy data
        addItem("Test item 1", "123", "ba", "1.55", "2.75", "Admin");
        addItem("Test item 2", "123", "ba", "11.15", "2.75", "Admin");
        addItem("Test item 3", "123", "ba", "25.00", "2.75", "Admin");
        addItem("Test item 4", "123", "ba", "5.00", "2.75", "Admin");
        addItem("Test item 5", "123", "ba", "3.25", "2.75", "Admin");
        addItem("Test item 6", "123", "ba", "7.12", "2.75", "Admin");
        addItem("Test item 7", "123", "ba", "9.35", "2.75", "Admin");
        addItem("Test item 8", "123", "ba", "25.15", "2.75", "Admin");
        addItem("Test item 9", "123", "ba", "30.00", "2.75", "Admin");
        addItem("Test item 10", "123", "ba", "1.00", "2.75", "Admin");

        Admin c = new Admin("Admin", new Date(), "pass");
        SaltyPassword sp = new SaltyPassword();
        byte[] salt = sp.getSalt();
        String hashedPassword = sp.getSecurePassword("pass", salt);
        c.setPassword(hashedPassword);
        c.setSalt(salt);
        c.setType(Admin.ADMINTYPE.DISTRIBUTOR);
        persist(c);
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
    public List<Item> getMyAuctions() {
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
    public List<Item> getMyQueue(String ownerName) {
        EntityManager em_temp = this.em.createEntityManager();

        Object items = null;

        try {
            items = em_temp.createQuery(
                    "SELECT i FROM Item i WHERE ownerName = :ownerName AND active = true")
                    .setParameter("ownerName", ownerName)
                    .getResultList();
            em_temp.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (items == null) {
            return null;
        }
        return (List<Item>) items;
    }

    @Override
    public User getAccountInfo(String username) {
        EntityManager em_temp = this.em.createEntityManager();

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
        return (User) acc;
    }

    @Override
    public void itemPaid(Item item, String username) {
        EntityManager em_temp = em.createEntityManager();

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
        User user = (User) acc;

        Map<Item, Double> temp_wonItems = user.getWonItems();
        user.setWonItems(new HashMap<>());

        for (Entry<Item, Double> i : temp_wonItems.entrySet()) {
            if (!i.getKey().getName().equals(item.getName())) {
                user.getWonItems().put(i.getKey(), i.getValue());
            }
        }
        item.setPaid(true);

        user.getWonItems().put(item, item.getCurrentBid());

        Item temp_item = item;

        temp_item.setId(item.getId());

        updateItem(temp_item);

        persist(user);
    }
    
    public static void itemWon(Item item, String username) {
        EntityManager em_temp = em.createEntityManager();

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
        User user = (User) acc;


        user.getWonItems().put(item, item.getCurrentBid());
        persist(user);
    }

    public static User getAccountInfoLocal(String username) {
        EntityManager em_temp = em.createEntityManager();

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
        return (User) acc;
    }

    @Override
    public User_parent login(String username, String password) {
        EntityManager em_temp = this.em.createEntityManager();

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

        User_parent login;
        User_parent a;
        User_parent a_temp;

        if (acc.getClass() == User.class) {
            a_temp = (User) acc;

            a = new User();

            a.setUsername(a_temp.getUsername());
            a.setPassword(a_temp.getPassword());
            a.setId(a_temp.getId());
            a.setSalt(a_temp.getSalt());

            login = new User();
            login.setUsername(username);

        } else {
            a_temp = (Admin) acc;

            a = new Admin();

            a.setUsername(a_temp.getUsername());
            a.setPassword(a_temp.getPassword());
            a.setId(a_temp.getId());
            a.setSalt(a_temp.getSalt());

            login = new Admin();
            login.setUsername(username);

        }

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
    public List<Item> getPastAuctions() {
        EntityManager em_temp = this.em.createEntityManager();

        Object items = null;

        try {
            items = em_temp.createQuery(
                    "SELECT i FROM Item i WHERE active = false")
                    .getResultList();
            em_temp.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (items == null) {
            return null;
        }
        return (List<Item>) items;
    }

    @Override
    public void addItem(String name, String description, String imagepath, String startingprice, String mininumprice, String username) {
        Item item = new Item();
        item.setName(name);
        item.setDescription(description);
        item.setMinimumPrice(Double.parseDouble(mininumprice));
        item.setStartingPrice(Double.parseDouble(startingprice));
        item.setCurrentBid(Double.parseDouble(startingprice));
        item.setRemainingTime(7);
        item.setActive(true);
        item.setOwnerName(username);

        persist(item);

        //Controller.getController().addAuction(item);
    }

    public static void updateItem(Item item) {
        EntityManager em_temp = em.createEntityManager();

        Item temp_item = item;
        temp_item.setId(item.getId());

        em_temp.getTransaction().begin();
        em_temp.merge(temp_item);
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
    public Bid getHighestBidForAuction(int placeInList) {
        List<Item> pastAuctions = getPastAuctions();

        return pastAuctions.get(placeInList).getHighestBid();
    }

    @Override
    public boolean placeBid(User_parent user, String amount) {
        double amount_tmp;
        try {
            amount_tmp = Double.parseDouble(amount);

        } catch (Exception e) {
            return false;
        }
        return Controller.getController().addBid(Controller.getController().getCurrentAuction(), (User) user, amount_tmp);
    }
}

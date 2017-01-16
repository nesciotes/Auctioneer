
package auctioneer;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Data", targetNamespace = "http://auctioneer/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Data {


    /**
     * 
     * @param arg0
     * @return
     *     returns auctioneer.Bid
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHighestBidForAuction", targetNamespace = "http://auctioneer/", className = "auctioneer.GetHighestBidForAuction")
    @ResponseWrapper(localName = "getHighestBidForAuctionResponse", targetNamespace = "http://auctioneer/", className = "auctioneer.GetHighestBidForAuctionResponse")
    @Action(input = "http://auctioneer/Data/getHighestBidForAuctionRequest", output = "http://auctioneer/Data/getHighestBidForAuctionResponse")
    public Bid getHighestBidForAuction(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getChat", targetNamespace = "http://auctioneer/", className = "auctioneer.GetChat")
    @ResponseWrapper(localName = "getChatResponse", targetNamespace = "http://auctioneer/", className = "auctioneer.GetChatResponse")
    @Action(input = "http://auctioneer/Data/getChatRequest", output = "http://auctioneer/Data/getChatResponse")
    public List<String> getChat();

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns auctioneer.UserParent
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://auctioneer/", className = "auctioneer.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://auctioneer/", className = "auctioneer.LoginResponse")
    @Action(input = "http://auctioneer/Data/loginRequest", output = "http://auctioneer/Data/loginResponse")
    public UserParent login(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "addMessage", targetNamespace = "http://auctioneer/", className = "auctioneer.AddMessage")
    @ResponseWrapper(localName = "addMessageResponse", targetNamespace = "http://auctioneer/", className = "auctioneer.AddMessageResponse")
    @Action(input = "http://auctioneer/Data/addMessageRequest", output = "http://auctioneer/Data/addMessageResponse")
    public void addMessage(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns auctioneer.Item
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCurrent", targetNamespace = "http://auctioneer/", className = "auctioneer.GetCurrent")
    @ResponseWrapper(localName = "getCurrentResponse", targetNamespace = "http://auctioneer/", className = "auctioneer.GetCurrentResponse")
    @Action(input = "http://auctioneer/Data/getCurrentRequest", output = "http://auctioneer/Data/getCurrentResponse")
    public Item getCurrent();

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "addItem", targetNamespace = "http://auctioneer/", className = "auctioneer.AddItem")
    @ResponseWrapper(localName = "addItemResponse", targetNamespace = "http://auctioneer/", className = "auctioneer.AddItemResponse")
    @Action(input = "http://auctioneer/Data/addItemRequest", output = "http://auctioneer/Data/addItemResponse")
    public void addItem(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        String arg5);

    /**
     * 
     * @return
     *     returns java.util.List<auctioneer.Item>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPastAuctions", targetNamespace = "http://auctioneer/", className = "auctioneer.GetPastAuctions")
    @ResponseWrapper(localName = "getPastAuctionsResponse", targetNamespace = "http://auctioneer/", className = "auctioneer.GetPastAuctionsResponse")
    @Action(input = "http://auctioneer/Data/getPastAuctionsRequest", output = "http://auctioneer/Data/getPastAuctionsResponse")
    public List<Item> getPastAuctions();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<auctioneer.Item>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMyAuctions", targetNamespace = "http://auctioneer/", className = "auctioneer.GetMyAuctions")
    @ResponseWrapper(localName = "getMyAuctionsResponse", targetNamespace = "http://auctioneer/", className = "auctioneer.GetMyAuctionsResponse")
    @Action(input = "http://auctioneer/Data/getMyAuctionsRequest", output = "http://auctioneer/Data/getMyAuctionsResponse")
    public List<Item> getMyAuctions(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "itemPaid", targetNamespace = "http://auctioneer/", className = "auctioneer.ItemPaid")
    @ResponseWrapper(localName = "itemPaidResponse", targetNamespace = "http://auctioneer/", className = "auctioneer.ItemPaidResponse")
    @Action(input = "http://auctioneer/Data/itemPaidRequest", output = "http://auctioneer/Data/itemPaidResponse")
    public void itemPaid(
        @WebParam(name = "arg0", targetNamespace = "")
        Item arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "addUser", targetNamespace = "http://auctioneer/", className = "auctioneer.AddUser")
    @ResponseWrapper(localName = "addUserResponse", targetNamespace = "http://auctioneer/", className = "auctioneer.AddUserResponse")
    @Action(input = "http://auctioneer/Data/addUserRequest", output = "http://auctioneer/Data/addUserResponse")
    public void addUser(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<auctioneer.Item>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMyQueue", targetNamespace = "http://auctioneer/", className = "auctioneer.GetMyQueue")
    @ResponseWrapper(localName = "getMyQueueResponse", targetNamespace = "http://auctioneer/", className = "auctioneer.GetMyQueueResponse")
    @Action(input = "http://auctioneer/Data/getMyQueueRequest", output = "http://auctioneer/Data/getMyQueueResponse")
    public List<Item> getMyQueue(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.util.List<auctioneer.Item>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllAuctions", targetNamespace = "http://auctioneer/", className = "auctioneer.GetAllAuctions")
    @ResponseWrapper(localName = "getAllAuctionsResponse", targetNamespace = "http://auctioneer/", className = "auctioneer.GetAllAuctionsResponse")
    @Action(input = "http://auctioneer/Data/getAllAuctionsRequest", output = "http://auctioneer/Data/getAllAuctionsResponse")
    public List<Item> getAllAuctions();

    /**
     * 
     * @param arg0
     * @return
     *     returns auctioneer.User
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAccountInfo", targetNamespace = "http://auctioneer/", className = "auctioneer.GetAccountInfo")
    @ResponseWrapper(localName = "getAccountInfoResponse", targetNamespace = "http://auctioneer/", className = "auctioneer.GetAccountInfoResponse")
    @Action(input = "http://auctioneer/Data/getAccountInfoRequest", output = "http://auctioneer/Data/getAccountInfoResponse")
    public User getAccountInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "placeBid", targetNamespace = "http://auctioneer/", className = "auctioneer.PlaceBid")
    @ResponseWrapper(localName = "placeBidResponse", targetNamespace = "http://auctioneer/", className = "auctioneer.PlaceBidResponse")
    @Action(input = "http://auctioneer/Data/placeBidRequest", output = "http://auctioneer/Data/placeBidResponse")
    public boolean placeBid(
        @WebParam(name = "arg0", targetNamespace = "")
        UserParent arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

}

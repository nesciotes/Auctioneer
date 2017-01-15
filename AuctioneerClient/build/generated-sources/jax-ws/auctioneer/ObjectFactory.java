
package auctioneer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the auctioneer package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LoginResponse_QNAME = new QName("http://auctioneer/", "loginResponse");
    private final static QName _AddUser_QNAME = new QName("http://auctioneer/", "addUser");
    private final static QName _GetHighestBidForAuctionResponse_QNAME = new QName("http://auctioneer/", "getHighestBidForAuctionResponse");
    private final static QName _GetPastAuctions_QNAME = new QName("http://auctioneer/", "getPastAuctions");
    private final static QName _AddMessage_QNAME = new QName("http://auctioneer/", "addMessage");
    private final static QName _GetCurrentResponse_QNAME = new QName("http://auctioneer/", "getCurrentResponse");
    private final static QName _Login_QNAME = new QName("http://auctioneer/", "login");
    private final static QName _AddMessageResponse_QNAME = new QName("http://auctioneer/", "addMessageResponse");
    private final static QName _GetHighestBidForAuction_QNAME = new QName("http://auctioneer/", "getHighestBidForAuction");
    private final static QName _GetChat_QNAME = new QName("http://auctioneer/", "getChat");
    private final static QName _AddItem_QNAME = new QName("http://auctioneer/", "addItem");
    private final static QName _GetAllAuctionsResponse_QNAME = new QName("http://auctioneer/", "getAllAuctionsResponse");
    private final static QName _GetAllAuctions_QNAME = new QName("http://auctioneer/", "getAllAuctions");
    private final static QName _GetChatResponse_QNAME = new QName("http://auctioneer/", "getChatResponse");
    private final static QName _PlaceBid_QNAME = new QName("http://auctioneer/", "placeBid");
    private final static QName _GetCurrent_QNAME = new QName("http://auctioneer/", "getCurrent");
    private final static QName _GetPastAuctionsResponse_QNAME = new QName("http://auctioneer/", "getPastAuctionsResponse");
    private final static QName _PlaceBidResponse_QNAME = new QName("http://auctioneer/", "placeBidResponse");
    private final static QName _AddItemResponse_QNAME = new QName("http://auctioneer/", "addItemResponse");
    private final static QName _AddUserResponse_QNAME = new QName("http://auctioneer/", "addUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: auctioneer
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link User.WonItems }
     * 
     */
    public User.WonItems createUserWonItems() {
        return new User.WonItems();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link GetPastAuctions }
     * 
     */
    public GetPastAuctions createGetPastAuctions() {
        return new GetPastAuctions();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link GetHighestBidForAuctionResponse }
     * 
     */
    public GetHighestBidForAuctionResponse createGetHighestBidForAuctionResponse() {
        return new GetHighestBidForAuctionResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link AddMessageResponse }
     * 
     */
    public AddMessageResponse createAddMessageResponse() {
        return new AddMessageResponse();
    }

    /**
     * Create an instance of {@link GetHighestBidForAuction }
     * 
     */
    public GetHighestBidForAuction createGetHighestBidForAuction() {
        return new GetHighestBidForAuction();
    }

    /**
     * Create an instance of {@link AddMessage }
     * 
     */
    public AddMessage createAddMessage() {
        return new AddMessage();
    }

    /**
     * Create an instance of {@link GetCurrentResponse }
     * 
     */
    public GetCurrentResponse createGetCurrentResponse() {
        return new GetCurrentResponse();
    }

    /**
     * Create an instance of {@link AddItem }
     * 
     */
    public AddItem createAddItem() {
        return new AddItem();
    }

    /**
     * Create an instance of {@link GetAllAuctionsResponse }
     * 
     */
    public GetAllAuctionsResponse createGetAllAuctionsResponse() {
        return new GetAllAuctionsResponse();
    }

    /**
     * Create an instance of {@link GetChat }
     * 
     */
    public GetChat createGetChat() {
        return new GetChat();
    }

    /**
     * Create an instance of {@link PlaceBidResponse }
     * 
     */
    public PlaceBidResponse createPlaceBidResponse() {
        return new PlaceBidResponse();
    }

    /**
     * Create an instance of {@link AddItemResponse }
     * 
     */
    public AddItemResponse createAddItemResponse() {
        return new AddItemResponse();
    }

    /**
     * Create an instance of {@link GetAllAuctions }
     * 
     */
    public GetAllAuctions createGetAllAuctions() {
        return new GetAllAuctions();
    }

    /**
     * Create an instance of {@link GetChatResponse }
     * 
     */
    public GetChatResponse createGetChatResponse() {
        return new GetChatResponse();
    }

    /**
     * Create an instance of {@link PlaceBid }
     * 
     */
    public PlaceBid createPlaceBid() {
        return new PlaceBid();
    }

    /**
     * Create an instance of {@link GetCurrent }
     * 
     */
    public GetCurrent createGetCurrent() {
        return new GetCurrent();
    }

    /**
     * Create an instance of {@link GetPastAuctionsResponse }
     * 
     */
    public GetPastAuctionsResponse createGetPastAuctionsResponse() {
        return new GetPastAuctionsResponse();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link Admin }
     * 
     */
    public Admin createAdmin() {
        return new Admin();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link Bid }
     * 
     */
    public Bid createBid() {
        return new Bid();
    }

    /**
     * Create an instance of {@link User.WonItems.Entry }
     * 
     */
    public User.WonItems.Entry createUserWonItemsEntry() {
        return new User.WonItems.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHighestBidForAuctionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "getHighestBidForAuctionResponse")
    public JAXBElement<GetHighestBidForAuctionResponse> createGetHighestBidForAuctionResponse(GetHighestBidForAuctionResponse value) {
        return new JAXBElement<GetHighestBidForAuctionResponse>(_GetHighestBidForAuctionResponse_QNAME, GetHighestBidForAuctionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPastAuctions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "getPastAuctions")
    public JAXBElement<GetPastAuctions> createGetPastAuctions(GetPastAuctions value) {
        return new JAXBElement<GetPastAuctions>(_GetPastAuctions_QNAME, GetPastAuctions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "addMessage")
    public JAXBElement<AddMessage> createAddMessage(AddMessage value) {
        return new JAXBElement<AddMessage>(_AddMessage_QNAME, AddMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "getCurrentResponse")
    public JAXBElement<GetCurrentResponse> createGetCurrentResponse(GetCurrentResponse value) {
        return new JAXBElement<GetCurrentResponse>(_GetCurrentResponse_QNAME, GetCurrentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "addMessageResponse")
    public JAXBElement<AddMessageResponse> createAddMessageResponse(AddMessageResponse value) {
        return new JAXBElement<AddMessageResponse>(_AddMessageResponse_QNAME, AddMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHighestBidForAuction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "getHighestBidForAuction")
    public JAXBElement<GetHighestBidForAuction> createGetHighestBidForAuction(GetHighestBidForAuction value) {
        return new JAXBElement<GetHighestBidForAuction>(_GetHighestBidForAuction_QNAME, GetHighestBidForAuction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetChat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "getChat")
    public JAXBElement<GetChat> createGetChat(GetChat value) {
        return new JAXBElement<GetChat>(_GetChat_QNAME, GetChat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "addItem")
    public JAXBElement<AddItem> createAddItem(AddItem value) {
        return new JAXBElement<AddItem>(_AddItem_QNAME, AddItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllAuctionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "getAllAuctionsResponse")
    public JAXBElement<GetAllAuctionsResponse> createGetAllAuctionsResponse(GetAllAuctionsResponse value) {
        return new JAXBElement<GetAllAuctionsResponse>(_GetAllAuctionsResponse_QNAME, GetAllAuctionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllAuctions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "getAllAuctions")
    public JAXBElement<GetAllAuctions> createGetAllAuctions(GetAllAuctions value) {
        return new JAXBElement<GetAllAuctions>(_GetAllAuctions_QNAME, GetAllAuctions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetChatResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "getChatResponse")
    public JAXBElement<GetChatResponse> createGetChatResponse(GetChatResponse value) {
        return new JAXBElement<GetChatResponse>(_GetChatResponse_QNAME, GetChatResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlaceBid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "placeBid")
    public JAXBElement<PlaceBid> createPlaceBid(PlaceBid value) {
        return new JAXBElement<PlaceBid>(_PlaceBid_QNAME, PlaceBid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "getCurrent")
    public JAXBElement<GetCurrent> createGetCurrent(GetCurrent value) {
        return new JAXBElement<GetCurrent>(_GetCurrent_QNAME, GetCurrent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPastAuctionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "getPastAuctionsResponse")
    public JAXBElement<GetPastAuctionsResponse> createGetPastAuctionsResponse(GetPastAuctionsResponse value) {
        return new JAXBElement<GetPastAuctionsResponse>(_GetPastAuctionsResponse_QNAME, GetPastAuctionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlaceBidResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "placeBidResponse")
    public JAXBElement<PlaceBidResponse> createPlaceBidResponse(PlaceBidResponse value) {
        return new JAXBElement<PlaceBidResponse>(_PlaceBidResponse_QNAME, PlaceBidResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "addItemResponse")
    public JAXBElement<AddItemResponse> createAddItemResponse(AddItemResponse value) {
        return new JAXBElement<AddItemResponse>(_AddItemResponse_QNAME, AddItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auctioneer/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

}

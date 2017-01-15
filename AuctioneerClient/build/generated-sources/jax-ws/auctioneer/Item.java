
package auctioneer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for item complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="item">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="currentBid" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minimumPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remainingTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="startingPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "item", propOrder = {
    "currentBid",
    "description",
    "minimumPrice",
    "name",
    "remainingTime",
    "startingPrice"
})
public class Item {

    protected double currentBid;
    protected String description;
    protected double minimumPrice;
    protected String name;
    protected int remainingTime;
    protected double startingPrice;

    /**
     * Gets the value of the currentBid property.
     * 
     */
    public double getCurrentBid() {
        return currentBid;
    }

    /**
     * Sets the value of the currentBid property.
     * 
     */
    public void setCurrentBid(double value) {
        this.currentBid = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the minimumPrice property.
     * 
     */
    public double getMinimumPrice() {
        return minimumPrice;
    }

    /**
     * Sets the value of the minimumPrice property.
     * 
     */
    public void setMinimumPrice(double value) {
        this.minimumPrice = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the remainingTime property.
     * 
     */
    public int getRemainingTime() {
        return remainingTime;
    }

    /**
     * Sets the value of the remainingTime property.
     * 
     */
    public void setRemainingTime(int value) {
        this.remainingTime = value;
    }

    /**
     * Gets the value of the startingPrice property.
     * 
     */
    public double getStartingPrice() {
        return startingPrice;
    }

    /**
     * Sets the value of the startingPrice property.
     * 
     */
    public void setStartingPrice(double value) {
        this.startingPrice = value;
    }

}


package auctioneer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for admin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="admin">
 *   &lt;complexContent>
 *     &lt;extension base="{http://auctioneer/}userParent">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://auctioneer/}admintype" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "admin", propOrder = {
    "type"
})
public class Admin
    extends UserParent
{

    protected Admintype type;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link Admintype }
     *     
     */
    public Admintype getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link Admintype }
     *     
     */
    public void setType(Admintype value) {
        this.type = value;
    }

}

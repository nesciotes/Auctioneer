
package auctioneer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for admintype.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="admintype">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DISTRIBUTOR"/>
 *     &lt;enumeration value="JANITOR"/>
 *     &lt;enumeration value="HEADADMIN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "admintype")
@XmlEnum
public enum Admintype {

    DISTRIBUTOR,
    JANITOR,
    HEADADMIN;

    public String value() {
        return name();
    }

    public static Admintype fromValue(String v) {
        return valueOf(v);
    }

}

package webserviceDTO;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/***
 * 
 * @author Monika
 */
@XmlType(propOrder = {"vanzId"})
public class WebVeranstaltungAnzeigen implements Serializable {

    private int vanzId = (int) 0;

    public WebVeranstaltungAnzeigen() {
    }

    public WebVeranstaltungAnzeigen(int _id) {
        vanzId = _id;
    }

    @XmlElement(name = "vanzId", required = true)
    public int getVanzId() {
        return vanzId;
    }
}

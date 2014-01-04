package webserviceDTO;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/***
 * 
 * @author Monika
 */
@XmlType(propOrder = {"id"})
public class WebVeranstaltungAnzeigen implements Serializable {

    public int id = (int) 0;

    public WebVeranstaltungAnzeigen() {
    }

    public WebVeranstaltungAnzeigen(int _id) {
        id = _id;
    }

    @XmlElement(name = "id", required = true)
    public int getId() {
        return id;
    }
}

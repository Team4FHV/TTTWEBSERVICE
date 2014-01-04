package webserviceDTO;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/***
 * 
 * @author Monika
 */
@XmlType(propOrder = {"kbKartenId", "kbKundenId", "kbErmaessigt"})
public class WebKarteBestellen implements Serializable {

    private int kbKartenId = (int) 0;
    private int kbKundenId = (int) 0;
    private boolean kbErmaessigt = false;

    public WebKarteBestellen() {
    }

    public WebKarteBestellen(int _kartenId, int _kundenId, boolean _ermaessigt) {
        kbKartenId = _kartenId;
        kbKundenId = _kundenId;
        kbErmaessigt = _ermaessigt;
    }

    @XmlElement(name = "kbKartenId", required = true)
    public int getKbKartenId() {
        return kbKartenId;
    }

    @XmlElement(name = "kbKundenId", required = true)
    public int getKbKundenId() {
        return kbKundenId;
    }

    @XmlElement(name = "kbErmaessigt", required = true)
    public boolean isKbErmaessigt() {
        return kbErmaessigt;
    }

}

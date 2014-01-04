package webserviceDTO;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/***
 * 
 * @author Monika
 */
@XmlType(propOrder = {"kartenId", "kundenId", "ermaessigt"})
public class WebKarteBestellen implements Serializable {

    public int kartenId = (int) 0;
    public int kundenId = (int) 0;
    public boolean ermaessigt = false;

    public WebKarteBestellen() {
    }

    public WebKarteBestellen(int _kartenId, int _kundenId, boolean _ermaessigt) {
        kartenId = _kartenId;
        kundenId = _kundenId;
        ermaessigt = _ermaessigt;
    }

    @XmlElement(name = "kartenId", required = true)
    public int getKartenId() {
        return kartenId;
    }

    @XmlElement(name = "kundenId", required = true)
    public int getKundenId() {
        return kundenId;
    }

    @XmlElement(name = "ermaessigt", required = true)
    public boolean isErmaessigt() {
        return ermaessigt;
    }

}

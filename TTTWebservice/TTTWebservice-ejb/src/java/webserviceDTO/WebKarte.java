package webserviceDTO;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/***
 * 
 * @author Monika
 */
@XmlType(propOrder = {"kartenId", "reihe", "platz"})
public class WebKarte implements Serializable {

    public int kartenId = (int) 0;
    public String reihe = null;
    public int platz = (int) 0;

    public WebKarte() {
    }

    public WebKarte(int _kartenId, String _reihe, int _platz) {
        kartenId = _kartenId;
        reihe = _reihe;
        platz = _platz;
    }
    
    @XmlElement(name = "kartenId", required = true)
    public int getKartenId() {
        return kartenId;
    }
    
    @XmlElement(name = "reihe", required = true)
    public String getReihe() {
        return reihe;
    }
    
    @XmlElement(name = "platz", required = true)
    public int getPlatz() {
        return platz;
    }
}

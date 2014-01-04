package webserviceDTO;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/***
 * 
 * @author Monika
 */
@XmlType(propOrder = {"kKartenId", "kReihe", "kPlatz"})
public class WebKarte implements Serializable {

    private int kKartenId = (int) 0;
    private String kReihe = null;
    private int kPlatz = (int) 0;

    public WebKarte() {
    }

    public WebKarte(int _kartenId, String _reihe, int _platz) {
        kKartenId = _kartenId;
        kReihe = _reihe;
        kPlatz = _platz;
    }
    
    @XmlElement(name = "kKartenId", required = true)
    public int getkKartenId() {
        return kKartenId;
    }
    
    @XmlElement(name = "kReihe", required = true)
    public String getkReihe() {
        return kReihe;
    }

    
    
    @XmlElement(name = "kPlatz", required = true)
    public int getkPlatz() {
        return kPlatz;
    }
}

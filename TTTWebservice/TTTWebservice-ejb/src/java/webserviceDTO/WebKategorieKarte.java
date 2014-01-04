package webserviceDTO;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Monika
 */
@XmlType(propOrder = {"kartenList"})
public class WebKategorieKarte implements Serializable {

    public webserviceDTO.WebKarte kartenList[] = null;

    public WebKategorieKarte() {
    }

    public WebKategorieKarte(webserviceDTO.WebKarte[] _kartenList) {
        kartenList = _kartenList;
    }

    @XmlElement(name = "kartenList", required = true)
    public WebKarte[] getKartenList() {
        return kartenList;
    }

}

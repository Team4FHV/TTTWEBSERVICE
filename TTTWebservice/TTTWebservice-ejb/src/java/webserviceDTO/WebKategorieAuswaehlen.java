package webserviceDTO;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Monika
 */
@XmlType(propOrder = {"katausId"})
public class WebKategorieAuswaehlen implements Serializable {

    private int katausId = (int) 0;

    public WebKategorieAuswaehlen() {
    }

    public WebKategorieAuswaehlen(int _id) {
        katausId = _id;
    }

    @XmlElement(name = "katausId", required = true)
    public int getKatausId() {
        return katausId;
    }

}

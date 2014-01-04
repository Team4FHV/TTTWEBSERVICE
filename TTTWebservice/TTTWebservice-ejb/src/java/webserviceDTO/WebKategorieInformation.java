package webserviceDTO;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Monika
 */
@XmlType(propOrder = {"kategId", "katName", "katPreis", "freiePlaetze", "ermaessigung"})
public final class WebKategorieInformation implements Serializable {

    public int kategId = (int) 0;
    public String katName = null;
    public double katPreis = (double) 0;

    public int freiePlaetze = (int) 0;
    public int ermaessigung = (int) 0;

    public WebKategorieInformation() {
    }

    public WebKategorieInformation(int _kategId, String _katName, double _katPreis, int _freiePlaetze, int _ermaessigung) {
        kategId = _kategId;
        katName = _katName;
        katPreis = _katPreis;
        freiePlaetze = _freiePlaetze;
        ermaessigung = _ermaessigung;
    }

    @XmlElement(name = "kategId", required = true)
    public int getKategId() {
        return kategId;
    }

    @XmlElement(name = "katName", required = true)
    public String getKatName() {
        return katName;
    }

    @XmlElement(name = "katPreis", required = true)
    public double getKatPreis() {
        return katPreis;
    }

    @XmlElement(name = "freiePlaetze", required = true)
    public int getFreiePlaetze() {
        return freiePlaetze;
    }

    @XmlElement(name = "ermaessigung", required = true)
    public int getErmaessigung() {
        return ermaessigung;
    }
}

package webserviceDTO;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Monika
 */
@XmlType(propOrder = {"katinfKatId", "katinfName", "katinfPreis", "katinfFreiePlaetze", "katinfErmaessigung"})
public final class WebKategorieInformation implements Serializable {

    private int katinfKatId = (int) 0;
    private String katinfName = null;
    private double katinfPreis = (double) 0;

    private int katinfFreiePlaetze = (int) 0;
    private int katinfErmaessigung = (int) 0;

    public WebKategorieInformation() {
    }

    public WebKategorieInformation(int _kategId, String _katName, double _katPreis, int _freiePlaetze, int _ermaessigung) {
        katinfKatId = _kategId;
        katinfName = _katName;
        katinfPreis = _katPreis;
        katinfFreiePlaetze = _freiePlaetze;
        katinfErmaessigung = _ermaessigung;
    }

    @XmlElement(name = "katinfKatId", required = true)
    public int getKatinfKatId() {
        return katinfKatId;
    }

    @XmlElement(name = "katinfName", required = true)
    public String getKatinfName() {
        return katinfName;
    }

    @XmlElement(name = "katinfPreis", required = true)
    public double getKatinfPreis() {
        return katinfPreis;
    }

    @XmlElement(name = "katinfFreiePlaetze", required = true)
    public int getKatinfFreiePlaetze() {
        return katinfFreiePlaetze;
    }

    @XmlElement(name = "katinfErmaessigung", required = true)
    public int getKatinfErmaessigung() {
        return katinfErmaessigung;
    }
}

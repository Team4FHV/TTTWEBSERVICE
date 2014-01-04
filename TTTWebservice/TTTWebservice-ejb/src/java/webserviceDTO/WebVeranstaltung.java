package webserviceDTO;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Monika
 */
@XmlType(propOrder = {"vid", "vDatum", "vName", "vOrt", "kuenstler", "ermaessigt"})
public class WebVeranstaltung implements Serializable {

    public int vid = (int) 0;
    public String vDatum = null;
    public String vName = null;
    public String vOrt = null;
    public String kuenstler = null;
    public boolean ermaessigt = false;

    public WebVeranstaltung() {
    }

    public WebVeranstaltung(int _vid, String _vDatum, String _vName, String _vOrt, String _kuenstler, boolean _ermaessigt) {
        vid = _vid;
        vDatum = _vDatum;
        vName = _vName;
        vOrt = _vOrt;
        kuenstler = _kuenstler;
        ermaessigt = _ermaessigt;
    }

    @XmlElement(name = "vid", required = true)
    public int getVid() {
        return vid;
    }

    @XmlElement(name = "vDatum", required = true)
    public String getvDatum() {
        return vDatum;
    }

    @XmlElement(name = "vName", required = true)
    public String getvName() {
        return vName;
    }

    @XmlElement(name = "vOrt", required = true)
    public String getvOrt() {
        return vOrt;
    }

    @XmlElement(name = "kuenstler", required = true)
    public String getKuenstler() {
        return kuenstler;
    }

    @XmlElement(name = "ermaessigt", required = true)
    public boolean isErmaessigt() {
        return ermaessigt;
    }

}

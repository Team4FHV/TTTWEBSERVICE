package webserviceDTO;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Monika
 */
@XmlType(propOrder = {"vid", "vDatum", "vName", "vOrt", "vKuenstler", "vErmaessigt"})
public class WebVeranstaltung implements Serializable {

    private int vid = (int) 0;
    private String vDatum = null;
    private String vName = null;
    private String vOrt = null;
    private String vKuenstler = null;
    private boolean vErmaessigt = false;

    public WebVeranstaltung() {
    }

    public WebVeranstaltung(int _vid, String _vDatum, String _vName, String _vOrt, String _kuenstler, boolean _ermaessigt) {
        vid = _vid;
        vDatum = _vDatum;
        vName = _vName;
        vOrt = _vOrt;
        vKuenstler = _kuenstler;
        vErmaessigt = _ermaessigt;
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

    @XmlElement(name = "vKuenstler", required = true)
    public String getvKuenstler() {
        return vKuenstler;
    }

    @XmlElement(name = "vErmaessigt", required = true)
    public boolean isvErmaessigt() {
        return vErmaessigt;
    }

}

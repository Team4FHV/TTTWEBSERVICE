package Hibernate.objecte;
// Generated 28.10.2013 11:53:03 by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Kategorie generated by hbm2java
 */
public class Kategorie  implements java.io.Serializable {


     private Integer kategorieId;
     private Veranstaltung veranstaltung;
     private String name;
     private String beschreibung;
     private BigDecimal preis;
     private Set kartes = new HashSet(0);

    public Kategorie() {
    }

	
    public Kategorie(Veranstaltung veranstaltung, String name, BigDecimal preis) {
        this.veranstaltung = veranstaltung;
        this.name = name;
        this.preis = preis;
    }
    public Kategorie(Veranstaltung veranstaltung, String name, String beschreibung, BigDecimal preis, Set kartes) {
       this.veranstaltung = veranstaltung;
       this.name = name;
       this.beschreibung = beschreibung;
       this.preis = preis;
       this.kartes = kartes;
    }
   
    public Integer getKategorieId() {
        return this.kategorieId;
    }
    
    public void setKategorieId(Integer kategorieId) {
        this.kategorieId = kategorieId;
    }
    public Veranstaltung getVeranstaltung() {
        return this.veranstaltung;
    }
    
    public void setVeranstaltung(Veranstaltung veranstaltung) {
        this.veranstaltung = veranstaltung;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getBeschreibung() {
        return this.beschreibung;
    }
    
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
    public BigDecimal getPreis() {
        return this.preis;
    }
    
    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }
    public Set getKartes() {
        return this.kartes;
    }
    
    public void setKartes(Set kartes) {
        this.kartes = kartes;
    }




}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import ConstantContent.*;
import Domain.DAOFabrik;
import Exceptions.KarteNichtVerfuegbarException;
import Exceptions.SaveFailedException;
import Hibernate.objecte.*;
import controller.DataManager;
import controller.UseCaseControllerBestellungErstellen;
import controller.UseCaseControllerSearch;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.ejb.Stateless;
import webserviceDTO.*;

/**
 *
 * @author Monika
 */
@WebService(name = "TTTwebservice")
@Stateless
public class TTTwebservice {

    private final UseCaseControllerBestellungErstellen ucb;
    private final UseCaseControllerSearch ucs;
    private final DataManager<Object> dm;
    private final Benutzer benutzer;

    public TTTwebservice() {

        ucb = new UseCaseControllerBestellungErstellen();
        ucs = new UseCaseControllerSearch();
        dm = new DataManager<>();
        benutzer = KonstantBenutzer.EXTERN;
    }

    public WebVeranstaltung[] sucheVeranstaltungNachKriterien(String datum, String ort, String kuenstler) {
        Date date = new Date();
        Kuenstler k;
        if (datum == null) {
            date = new Date();
        }

        if (kuenstler != null) {
            k = dm.getKuenstlerNachName(kuenstler);
        } else {
            k = null;
        }

        try {
            SimpleDateFormat sdfToDate = new SimpleDateFormat("dd.MM.yyyy");
            date = sdfToDate.parse(datum);
            System.err.println("DATUM " + date.toString());

        } catch (Exception e) {
        }
        List<Veranstaltung> list = ucs.searchFilter(ort, date, k);
        WebVeranstaltung[] veranstaltungsList = new WebVeranstaltung[list.size()];
        String kuenstlerList = "";
        for (int i = 0; i < list.size(); i++) {
            Veranstaltung v = list.get(i);
            Object[] ku = v.getKuenstlers().toArray();
            for (int j = 0; j < ku.length; j++) {
                kuenstlerList = kuenstlerList + ((Kuenstler) ku[j]).getName() + " ";
            }
            boolean erm = (v.getErmaessigung() == 1);
            veranstaltungsList[i] = new WebVeranstaltung(v.getVeranstaltungId(), v.getDatumUhrzeit().toString(),
                    v.getName(), v.getVeranstaltungsort().getAdresse(), kuenstlerList, erm);
        }
        return veranstaltungsList;
    }

    public WebKategorieInformation[] getKategorieInfoVonVeranstaltung(WebVeranstaltungAnzeigen veranstaltung) {

        Veranstaltung v = ucb.getVeranstaltungByID(veranstaltung.getVanzId());

        Object[] kat = v.getKategories().toArray();
        WebKategorieInformation[] result = new WebKategorieInformation[kat.length];

        for (int i = 0; i < kat.length; i++) {
            Kategorie k = (Kategorie) kat[i];
            int ermaessigung = k.getVeranstaltung().getErmaessigung();
            int frei = dm.anzahlFreiePlatzeNachKategorie(k);
            double preis = k.getPreis().doubleValue();
            result[i] = new WebKategorieInformation(k.getKategorieId(), k.getName(), preis, frei, ermaessigung);
        }
        return result;
    }

    public WebKategorieKarte getAlleFreieKartenNachKategorie(WebKategorieAuswaehlen kategorie) {

        Kategorie k = ucb.getKategorieByID(kategorie.getKatausId());
        List<Karte> karten = ucb.getFreieKartenNachKategorie(k);

        WebKarte[] freieKarten = new WebKarte[karten.size()];

        for (int i = 0; i < karten.size(); i++) {
            Karte karte = karten.get(i);
            freieKarten[i] = new WebKarte(karte.getKartenId(), karte.getReihe(), karte.getSitzplatz());
        }

        return new WebKategorieKarte(freieKarten);
    }

    public void verkaufSpeichern(WebKarteBestellen[] karten) {
        try {
            Set<Karte> bestellteKartenSet = new HashSet<>();
            int statusFREI = KonstantKartenStatus.FREI.getKartenstatusId();

            Kunde kunde = KonstantKunde.ANONYMOUS;

            for (int i = 0; i < karten.length; i++) {
                try {
                    boolean erm = karten[i].isKbErmaessigt();
                    Karte k = ucb.getKarteByID(karten[i].getKbKartenId());
                    DAOFabrik.getInstance().getKarteDAO().saveORupdate(k);
                    if (dm.getKartenStatusId(k.getKartenId()) == statusFREI) {
                        ucb.karteKaufen(k, erm);
                        bestellteKartenSet.add(k);
                    } else {
                        ucb.kartenFreiGeben(bestellteKartenSet);
                        throw new KarteNichtVerfuegbarException(k.getKartenId());
                    }
                } catch (SaveFailedException ex) {
                    Logger.getLogger(TTTwebservice.class.getName()).log(Level.SEVERE, null, ex);
                } catch (KarteNichtVerfuegbarException ex) {
                    Logger.getLogger(TTTwebservice.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ucb.verkaufSpeichern(benutzer, kunde, bestellteKartenSet);
        } catch (Exception ex) {
            Logger.getLogger(TTTwebservice.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public WebKategorieInformation getKategorieInfo(int id) {
        Kategorie kat = ucb.getKategorieByID(id);
        int ermaessigung = kat.getVeranstaltung().getErmaessigung();
        int frei = dm.anzahlFreiePlatzeNachKategorie(kat);
        double preis = kat.getPreis().doubleValue();
        return new WebKategorieInformation(kat.getKategorieId(), kat.getName(), preis, frei, ermaessigung);

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saric.ZupanijskaNogometnaLiga.model;

/**
 *
 * @author Hrvoje-PC
 */
public class Momcad {
    private int sifra;
    private String naziv;
    private String predstavnik_kluba;
    private String trener;
    private String fizioterapeut;
    private String stadion;

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPredstavnik_kluba() {
        return predstavnik_kluba;
    }

    public void setPredstavnik_kluba(String predstavnik_kluba) {
        this.predstavnik_kluba = predstavnik_kluba;
    }

    public String getTrener() {
        return trener;
    }

    public void setTrener(String trener) {
        this.trener = trener;
    }

    public String getFizioterapeut() {
        return fizioterapeut;
    }

    public void setFizioterapeut(String fizioterapeut) {
        this.fizioterapeut = fizioterapeut;
    }

    public String getStadion() {
        return stadion;
    }

    public void setStadion(String stadion) {
        this.stadion = stadion;
    }
    
    @Override
    public String toString(){
        return naziv;
    }

    
    
}

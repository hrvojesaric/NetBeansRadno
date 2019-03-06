/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saric.zavrsniZNLhib.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Polaznik
 */
@Entity
@Table
public class Momcad extends Entitet implements Serializable {
    private String naziv;
    private String predstavnik_kluba;
    private String trener;
    private String fizioterapeut;
    private String stadion;

      @OneToMany(mappedBy = "momcad")
    private List<Igrac> igraci=new ArrayList<>();

    public List<Igrac> getIgraci() {
        return igraci;
    }

    public void setIgraci (List<Igrac> igraci) {
        this.igraci = igraci;
    }
    
    @OneToMany(mappedBy = "momcad")
    private List<Dogadaj> dogadaji=new ArrayList<>();

    public List<Dogadaj> getDogadaji() {
        return dogadaji;
    }

    public void setDogadaji (List<Dogadaj> dogadaji) {
        this.dogadaji = dogadaji;
    }
    
    @OneToMany(mappedBy = "momcad")
    private List<Utakmica> utakmice=new ArrayList<>();

    public List<Utakmica> getUtakmice() {
        return utakmice;
    }

    public void setUtakmice (List<Utakmica> utakmice) {
        this.utakmice = utakmice;
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
    public String toString() {
       return getNaziv();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saric.zavrsniZNLhib.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Polaznik
 */
@Entity
@Table
public class Igrac extends Entitet implements Serializable {

    
    private String prezime;
    private String ime;
    private String broj_licence;
    
    @ManyToOne
    private Momcad momcad;
    
    @Temporal(TemporalType.DATE)
    private Date datumrodenja;
    
    
    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getBroj_licence() {
        return broj_licence;
    }

    public void setBroj_licence(String broj_licence) {
        this.broj_licence = broj_licence;
    }

    public Momcad getMomcad() {
        return momcad;
    }

    public void setMomcad(Momcad momcad) {
        this.momcad = momcad;
    }

    public Date getDatumrodenja() {
        return datumrodenja;
    }

    public void setDatumrodenja(Date datumrodenja) {
        this.datumrodenja = datumrodenja;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saric.zavrsniZNLhib.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Polaznik
 */
@Entity
@Table
public class Dogadaj extends Entitet implements Serializable {
    
    @ManyToOne
    private Utakmica utakmica;
    
    @ManyToOne
    private Momcad momcad;
    
    private String opis;
    
    private int vrijeme;
    
    @ManyToOne
    private VrstaDogadaja vrstadogadaja;

    public Utakmica getUtakmica() {
        return utakmica;
    }

    public void setUtakmica(Utakmica utakmica) {
        this.utakmica = utakmica;
    }

    public Momcad getMomcad() {
        return momcad;
    }

    public void setMomcad(Momcad momcad) {
        this.momcad = momcad;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(int vrijeme) {
        this.vrijeme = vrijeme;
    }

    public VrstaDogadaja getVrstadogadaja() {
        return vrstadogadaja;
    }

    public void setVrstadogadaja(VrstaDogadaja vrstadogadaja) {
        this.vrstadogadaja = vrstadogadaja;
    }
    
    
}

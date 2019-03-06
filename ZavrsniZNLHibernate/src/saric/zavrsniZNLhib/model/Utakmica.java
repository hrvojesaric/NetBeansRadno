/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saric.zavrsniZNLhib.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Polaznik
 */
@Entity
@Table
public class Utakmica extends Entitet implements Serializable {
    @ManyToOne
    private Momcad domaci;
    @ManyToOne
    private Momcad gosti;
    
   @ManyToOne
    private Sudac glavni_sudac;
   @ManyToOne
    private Sudac prvi_pomocni;
   @ManyToOne
    private Sudac drugi_pomocni;
   
    @Temporal(TemporalType.DATE)
    private Date pocetak;
    
    private String rezultat;
    
    @OneToMany(mappedBy = "utakmica")
    private List<Dogadaj> dogadaji=new ArrayList<>();

    public List<Dogadaj> getDogadaji() {
        return dogadaji;
    }

    public void setDogadaji (List<Dogadaj> dogadaji) {
        this.dogadaji = dogadaji;
    }
    
    public Momcad getDomaci() {
        return domaci;
    }

    public void setDomaci(Momcad domaci) {
        this.domaci = domaci;
    }

    public Momcad getGosti() {
        return gosti;
    }

    public void setGosti(Momcad gosti) {
        this.gosti = gosti;
    }

    public Sudac getGlavni_sudac() {
        return glavni_sudac;
    }

    public void setGlavni_sudac(Sudac glavni_sudac) {
        this.glavni_sudac = glavni_sudac;
    }

    public Sudac getPrvi_pomocni() {
        return prvi_pomocni;
    }

    public void setPrvi_pomocni(Sudac prvi_pomocni) {
        this.prvi_pomocni = prvi_pomocni;
    }

    public Sudac getDrugi_pomocni() {
        return drugi_pomocni;
    }

    public void setDrugi_pomocni(Sudac drugi_pomocni) {
        this.drugi_pomocni = drugi_pomocni;
    }

    public Date getPocetak() {
        return pocetak;
    }

    public void setPocetak(Date pocetak) {
        this.pocetak = pocetak;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }
    
    
   
    
}

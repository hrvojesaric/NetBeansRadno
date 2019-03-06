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
public class VrstaDogadaja extends Entitet implements Serializable {
    
    private String naziv;

    @OneToMany(mappedBy = "vrsta_dogadaja")
    private List<Dogadaj> dogadaji=new ArrayList<>();

    public List<Dogadaj> getDogadaji() {
        return dogadaji;
    }

    public void setDogadaji (List<Dogadaj> dogadaji) {
        this.dogadaji = dogadaji;
    }
    
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    @Override
    public String toString() {
       return getNaziv();
    }
    
}

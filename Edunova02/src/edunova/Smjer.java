/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova;

import java.math.BigDecimal;

/**
 *
 * @author Profesor
 */
public class Smjer {
    
    private int sifra;
    private String naziv;
    private BigDecimal cijena;
    private BigDecimal upisnina;
    private int trajanje;
    private boolean verificiran;

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

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public BigDecimal getUpisnina() {
        return upisnina;
    }

    public void setUpisnina(BigDecimal upisnina) {
        this.upisnina = upisnina;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public boolean isVerificiran() {
        return verificiran;
    }

    public void setVerificiran(boolean verificiran) {
        this.verificiran = verificiran;
    }

    @Override
    public String toString() {
        return this.naziv;
    }

    
    
    
    
}

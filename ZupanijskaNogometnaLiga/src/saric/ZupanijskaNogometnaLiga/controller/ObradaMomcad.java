/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saric.ZupanijskaNogometnaLiga.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import saric.ZupanijskaNogometnaLiga.model.Momcad;
import saric.ZupanijskaNogometnaLiga.utility.Baza;
import saric.ZupanijskaNogometnaLiga.utility.ZupanijskaNogometnaLigaException;

/**
 *
 * @author Hrvoje-PC
 */
public class ObradaMomcad {
    private PreparedStatement izraz;
    private ResultSet rs;
    
        public List<Momcad> read() {
        List<Momcad> momcadi = new ArrayList<>();
        try {
            izraz = Baza.getInstance().getConnection().prepareStatement("select * from momcad");
            rs = izraz.executeQuery();
            Momcad s;
            while (rs.next()) {
                s = new Momcad();
                s.setSifra(rs.getInt("sifra"));
                s.setNaziv(rs.getString("naziv"));
                s.setPredstavnik_kluba(rs.getString("predstavnik_kluba"));
                s.setTrener(rs.getString("trener"));
                s.setFizioterapeut(rs.getString("fizioterapeut"));
                s.setStadion(rs.getString("stadion"));
                
                momcadi.add(s);
            }
            rs.close();
            izraz.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return momcadi;
    }
        
        
      
        public Momcad create(Momcad s) throws ZupanijskaNogometnaLigaException{

        kontrola(s);
        
        
        
        try {
            izraz = Baza.getInstance().getConnection().prepareStatement(
                    "insert into momcad (naziv,predstavnik_kluba,trener,fizioterapeut,stadion) "
                    + " values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            izraz.setString(1, s.getNaziv());
            izraz.setString(2, s.getPredstavnik_kluba());
            izraz.setString(3, s.getTrener());
            izraz.setString(4, s.getFizioterapeut());
            izraz.setString(5, s.getStadion());

            izraz.executeUpdate();
            rs = izraz.getGeneratedKeys();
            rs.next();
            s.setSifra(rs.getInt(1));

            rs.close();
            izraz.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    public boolean delete(Momcad s) {

        try {

            izraz = Baza.getInstance().getConnection().prepareStatement("delete from momcad where sifra=?");
            izraz.setInt(1, s.getSifra());

            return izraz.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean update(Momcad s) throws ZupanijskaNogometnaLigaException{
        
         kontrola(s);
        
        try {
            izraz = Baza.getInstance().getConnection().prepareStatement(
                    "insert into momcad (naziv,predstavnik_kluba,trener,fizioterapeut,stadion) "
                    + " values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            izraz.setString(1, s.getNaziv());
            izraz.setString(2, s.getPredstavnik_kluba());
            izraz.setString(3, s.getTrener());
            izraz.setString(4, s.getFizioterapeut());
            izraz.setString(5, s.getStadion());

            return izraz.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

   private void kontrola(Momcad s) throws ZupanijskaNogometnaLigaException{
       if(s.getNaziv()==null){
            throw new ZupanijskaNogometnaLigaException("Naziv je null, obavezan unos");
        }
        
        if(s.getPredstavnik_kluba()==null){
            throw new ZupanijskaNogometnaLigaException("Predstavnik kluba je null, obavezan unos");
        }
        
        if(s.getTrener()==null){
            throw new ZupanijskaNogometnaLigaException("Trener je null, obavezan unos");
        }
        
        if(s.getFizioterapeut()==null){
            throw new ZupanijskaNogometnaLigaException("Fizioterapeut je null, obavezan unos");
        }
        
        if(s.getStadion()==null){
            throw new ZupanijskaNogometnaLigaException("Stadion je null, obavezan unos");
        }
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.controller;

import edunova.model.Smjer;
import edunova.utility.Baza;
import edunova.utility.EdunovaException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Profesor
 */
public class ObradaSmjer {

    private PreparedStatement izraz;
    private ResultSet rs;

    public List<Smjer> read() {
        List<Smjer> smjerovi = new ArrayList<>();
        try {
            izraz = Baza.getInstance().getConnection().prepareStatement("select * from smjer");
            rs = izraz.executeQuery();
            Smjer s;
            while (rs.next()) {
                s = new Smjer();
                s.setSifra(rs.getInt("sifra"));
                s.setNaziv(rs.getString("naziv"));
                s.setTrajanje(rs.getInt("trajanje"));
                s.setCijena(rs.getBigDecimal("cijena"));
                s.setUpisnina(rs.getBigDecimal("upisnina"));
                s.setVerificiran(rs.getBoolean("verificiran"));
                smjerovi.add(s);
            }
            rs.close();
            izraz.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smjerovi;
    }

    public Smjer create(Smjer s) throws EdunovaException{

        kontrola(s);
        
        
        
        try {
            izraz = Baza.getInstance().getConnection().prepareStatement(
                    "insert into smjer (naziv,trajanje,cijena,upisnina,verificiran) "
                    + " values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            izraz.setString(1, s.getNaziv());
            izraz.setInt(2, s.getTrajanje());
            izraz.setBigDecimal(3, s.getCijena());
            izraz.setBigDecimal(4, s.getUpisnina());
            izraz.setBoolean(5, s.isVerificiran());

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

    public boolean delete(Smjer s) {

        try {

            izraz = Baza.getInstance().getConnection().prepareStatement("delete from smjer where sifra=?");
            izraz.setInt(1, s.getSifra());

            return izraz.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean update(Smjer s) throws EdunovaException{
        
         kontrola(s);
        
        try {
            izraz = Baza.getInstance().getConnection().prepareStatement(
                    "update smjer set naziv=?, trajanje=?, cijena=?, upisnina=?,verificiran=? "
                    + " where sifra=?");
            izraz.setString(1, s.getNaziv());
            izraz.setInt(2, s.getTrajanje());
            izraz.setBigDecimal(3, s.getCijena());
            izraz.setBigDecimal(4, s.getUpisnina());
            izraz.setBoolean(5, s.isVerificiran());
            izraz.setInt(6, s.getSifra());

            return izraz.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void kontrola(Smjer s) throws EdunovaException{
       if(s.getNaziv()==null){
            throw new EdunovaException("Naziv je null, obavezan unos");
        }
        
        if(s.getNaziv().trim().length()==0){
            throw new EdunovaException("Naziv je prazan, obavezan unos");
        }
        
        if(s.getNaziv().length()>50){
            throw new EdunovaException("Dužina naziva veća od dopuštene");
        }
        
        if(s.getTrajanje()<0 || s.getTrajanje()>500){
            throw new EdunovaException("Trajanje nije u dobrom rasponu (0 - 500)");
        }
        
        if(s.getCijena().compareTo(BigDecimal.ZERO)<0){
            throw  new EdunovaException("Cijena mora biti pozitivan broj");
        }
        
        if(s.getUpisnina().compareTo(BigDecimal.ZERO)<0){
            throw  new EdunovaException("Upisnina mora biti pozitivan broj");
        }
    }
}

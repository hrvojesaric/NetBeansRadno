/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.controller;

import edunova.model.Polaznik;
import edunova.model.Smjer;
import edunova.pomocno.EdunovaException;
import edunova.pomocno.HibernateUtil;
import edunova.pomocno.ObradaSucelje;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Profesor
 */
public class ObradaSmjer extends Obrada<Smjer>  implements ObradaSucelje<Smjer>{
    
    public ObradaSmjer(){
        super();
    }
    
    public List<Smjer> getLista(){
        //return dao.createQuery("from Smjer");
        return HibernateUtil.getSession().createQuery("from Smjer").list();
    }
    
    public Smjer spremi(Smjer s) throws EdunovaException{
        
        kontrola(s);
        
        return dao.save(s);
    }
    
    public void obrisi(Smjer s) throws EdunovaException{
        
     if(!s.getGrupe().isEmpty()){
         throw new EdunovaException("Smjer ima grupe i ne može se brisati");
     }
     
     dao.delete(s);
        
    }
    
    public void kontrola(Smjer s) throws EdunovaException{
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
        
        if(s.getCijena()!=null &&  s.getCijena().compareTo(BigDecimal.ZERO)<0){
            throw  new EdunovaException("Cijena mora biti pozitivan broj");
        }
        
        if(s.getUpisnina()!=null && s.getUpisnina().compareTo(BigDecimal.ZERO)<0){
            throw  new EdunovaException("Upisnina mora biti pozitivan broj");
        }
    }
    
    
}

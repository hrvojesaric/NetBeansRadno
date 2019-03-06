/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.controller;

import edunova.model.Predavac;
import edunova.pomocno.EdunovaException;
import edunova.pomocno.HibernateUtil;
import edunova.pomocno.ObradaSucelje;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.validator.routines.IBANValidator;


/**
 *
 * @author Profesor
 */
public class ObradaPredavac extends ObradaOsoba<Predavac>  implements ObradaSucelje<Predavac>{
    
     public ObradaPredavac(){
         super();
     }
     
     public List<Predavac> getLista(){
         return HibernateUtil.getSession().createQuery("from Predavac").list();
     }
     
     public Predavac spremi(Predavac p) throws EdunovaException{
         
         super.kontrola(p);
         kontrola(p);
         
         return dao.save(p);
     }
     
     public void obrisi(Predavac p) throws EdunovaException{
         
         if(!p.getGrupe().isEmpty()){
             throw new EdunovaException(
                     "Ne može se obrisati predavač jer predaje na grupama: " +
                             Arrays.toString(p.getGrupe().toArray())
             );
         }
         
         dao.delete(p);
     }
     
     public void kontrola(Predavac p) throws EdunovaException{
         
         if(!IBANValidator.getInstance().isValid(p.getIban())){
             throw new EdunovaException("IBAN nije ispravan");
         }
        
     }
     
    
    
}

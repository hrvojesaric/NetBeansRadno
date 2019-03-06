/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.controller;

import edunova.model.Grupa;
import edunova.model.Polaznik;
import edunova.pomocno.EdunovaException;
import edunova.pomocno.HibernateUtil;
import edunova.pomocno.ObradaSucelje;
import java.util.List;

/**
 *
 * @author Profesor
 */
public class ObradaPolaznik extends ObradaOsoba<Polaznik> implements ObradaSucelje<Polaznik>{
    
    public ObradaPolaznik(){
        super();
    }
    
     public List<Polaznik> getLista(){
         return HibernateUtil.getSession().createQuery("from Polaznik").list();
     }
     
     public Polaznik spremi(Polaznik p) throws EdunovaException{
         
         super.kontrola(p);
         kontrola(p);
         
         return dao.save(p);
     }
     
     public void obrisi(Polaznik p) throws EdunovaException{
         if(p.getGrupe().size()>0){
             throw new EdunovaException("Ne možete obrisati polaznika je je upisan na jednu ili više grupa");
         }
         
         dao.delete(p);
     }
     
      public void kontrola(Polaznik p) throws EdunovaException{
         
        
        
     }
    
    
    
}

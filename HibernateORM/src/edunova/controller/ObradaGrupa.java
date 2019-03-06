/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.controller;

import edunova.model.Grupa;
import edunova.pomocno.EdunovaException;
import edunova.pomocno.HibernateUtil;
import edunova.pomocno.ObradaSucelje;
import java.util.List;

/**
 *
 * @author Profesor
 */
public class ObradaGrupa extends Obrada<Grupa> implements ObradaSucelje<Grupa>{

    @Override
    public List<Grupa> getLista() {
        return HibernateUtil.getSession().createQuery("from Grupa").list();
    }

    @Override
    public void kontrola(Grupa t) throws EdunovaException {
        if(t.getNaziv()==null){
            throw new EdunovaException("Naziv ne definiran");
        }
        if(t.getNaziv().trim().isEmpty()){
            throw new EdunovaException("Naziv obavezno");
        }
    }

    @Override
    public Grupa spremi(Grupa t) throws EdunovaException {
        kontrola(t);
        return dao.save(t);
    }

    @Override
    public void obrisi(Grupa t) throws EdunovaException {
       if(t.getPolaznici().size()>0){
           throw new EdunovaException("Ne možete brisati, grupa ima polaznike");
       }
       dao.delete(t);
    }
    
}

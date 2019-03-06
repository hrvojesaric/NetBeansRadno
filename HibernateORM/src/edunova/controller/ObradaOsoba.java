/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.controller;

import edunova.model.Osoba;
import edunova.pomocno.EdunovaException;
import edunova.pomocno.Pomocno;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author Profesor
 * @param <T>
 */
public abstract class ObradaOsoba<T extends Osoba> extends Obrada<T>{
    
    public ObradaOsoba(){
        super();
    }
    
    public void kontrola (Osoba o) throws EdunovaException{
        if(o.getIme()==null){
            throw new EdunovaException("Ime nije definirano");
        }
        if(o.getIme().trim().isEmpty()){
            throw new EdunovaException("Ime nije Uneseno");
        }
        
        if(o.getPrezime()==null){
            throw new EdunovaException("Prezime nije definirano");
        }
        if(o.getPrezime().trim().isEmpty()){
            throw new EdunovaException("Prezime nije Uneseno");
        }
        
        /*
        //99,99 % sigurna, bolje zamjeniti jednostavnijom ili ju izbaciti
        if(!o.getEmail().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"))
        {
            throw new EdunovaException("Email nije ispravan");
        }
*/
        
        if(!EmailValidator.getInstance().isValid(o.getEmail())){
             throw new EdunovaException("Email nije ispravan");
        }
        
        if(!Pomocno.checkOIB(o.getOib())){
            throw new EdunovaException("Oib je neispravan");
        }
        
        
        
        
    }
    
}

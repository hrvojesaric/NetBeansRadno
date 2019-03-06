package edunova;

// domaća zadaća:

import edunova.controller.DAO;
import edunova.controller.ObradaOsoba;
import edunova.controller.ObradaPredavac;
import edunova.controller.ObradaSmjer;
import edunova.model.Grupa;
import edunova.model.Predavac;
import edunova.model.Smjer;
import edunova.pomocno.EdunovaException;
import edunova.pomocno.HibernateUtil;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

//upogoniti Hibernate prateći https://examples.javacodegeeks.com/enterprise-java/hibernate/hibernate-maven-example/
public class Start {

    public static void main(String[] args) {
        
        ObradaPredavac op = new ObradaPredavac();
        
        
        Predavac p = new Predavac();
        
        p.setIme("Pero");
        p.setPrezime("Perić");
        
        p.setEmail("pero@sdjgbsdbg.ll");
        p.setOib("01617271538");
        
        try {
            op.spremi(p);
        } catch (EdunovaException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
        
    }
    
}

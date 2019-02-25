/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova;

import edunova.controller.ObradaSmjer;
import edunova.model.Smjer;
import edunova.utility.Baza;
import java.math.BigDecimal;
import java.sql.SQLException;


/**
 *
 * @author Profesor
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       
            ObradaSmjer os = new ObradaSmjer();
            
           Smjer s = os.read().get(0);
           s.setCijena(new BigDecimal(99999));
           System.out.println(os.update(s));
            
      
    }
    
}

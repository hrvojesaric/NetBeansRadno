/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.pomocno;

import java.util.List;

/**
 *
 * @author Profesor
 */
public interface ObradaSucelje<T> {
    
    public List<T> getLista();
    public void kontrola(T t) throws EdunovaException;
    public T spremi(T t)  throws EdunovaException;
    public void obrisi(T t) throws EdunovaException;
    
}

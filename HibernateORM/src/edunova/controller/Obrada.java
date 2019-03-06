/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.controller;

import edunova.model.Predavac;

/**
 *
 * @author Profesor
 */
public abstract class Obrada<T> {
    
    
    protected DAO<T> dao;
    
    public Obrada(){
        dao = new DAO<>();
    }

    
    
}

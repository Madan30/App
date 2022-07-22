/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntechnepal.Interface;

import java.util.List;

/**
 *
 * @author mrg1813
 * @param <T>
 */
public interface Repository<T> {
    public void create(T t);
    public List<T> findAll();
    public T findById(Long id);
    public void delete(T t);
    public void edit(T t);
    public Boolean isUnique(T t, String uniqueColumn, Object newValue, Long id);
    
    
}

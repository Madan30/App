/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntechnepal.Converter;

import com.syntechnepal.AbstractRepository.AbstractRepository;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import com.syntechnepal.Interface.EntityInterface;

/**
 *
 * @author mrg1813
 * @param <T>
 */
public abstract class AbstractConverter<T extends EntityInterface> implements Converter, Serializable{
    protected  abstract AbstractRepository getAbstractRepository();
    
     @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
         if (value == null || value.isEmpty() || value.length() == 0 || value.equals("")) {
            return null;
        }
        return getAbstractRepository().findById(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
            if (t == null || t.equals("")) {
            return "";
        }
        return ((T) t).getId().toString();
    }
}

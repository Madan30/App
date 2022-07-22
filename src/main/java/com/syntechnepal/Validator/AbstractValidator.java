
package com.syntechnepal.Validator;

import com.syntechnepal.AbstractRepository.AbstractRepository;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import com.syntechnepal.Interface.EntityInterface;

/**
 *
 * @author mrg1813
 * @param <T>
 */
public abstract class AbstractValidator<T extends EntityInterface> implements Validator, Serializable{
    
    protected abstract AbstractRepository getAbstractRepository();

   @Override
    public void validate(final FacesContext context, final UIComponent comp, final Object newValue) throws ValidatorException {

        T currentEntity = (T) comp.getAttributes().get("currentEntity");
        String uniqueColumn = (String) comp.getAttributes().get("uniqueColumn");
        Long id = currentEntity.getId();
        boolean isValid = false;

        isValid = getAbstractRepository().isUnique(currentEntity, uniqueColumn, newValue, id);
        if (!isValid) {
            FacesMessage msg = new FacesMessage(uniqueColumn + " must be unique! ");
            context.addMessage(comp.getClientId(context), msg);
            throw new ValidatorException(msg);
        }
    }
    
}


package com.syntechnepal.Utls;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author mrg1813
 */

@Named
@RequestScoped
public class MessageUtls  implements Serializable{
    
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void showWarn(String title, String message) {
        addMessage(FacesMessage.SEVERITY_WARN, title, message);
    }

    public void showInfo(String title, String message) {
        addMessage(FacesMessage.SEVERITY_INFO, title, message);
    }

    public void showError(String title, String message) {
        addMessage(FacesMessage.SEVERITY_ERROR, title, message);
    }

    public void showSticky(String title, String message) {
        FacesContext.getCurrentInstance().addMessage("sticky-key", new FacesMessage(FacesMessage.SEVERITY_INFO, title, message));
    }
    
}

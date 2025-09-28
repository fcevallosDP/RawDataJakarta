package com.dp.controller.util;

/**
 *
 * @author ZAMBRED
 */
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.HttpSession;
import java.io.Serializable;

@Named("indexBean")
@ViewScoped
public class IndexBean implements Serializable {

    private boolean showChangeDialog;

    public IndexBean() {}

    @jakarta.annotation.PostConstruct
    public void init() {
        HttpSession s = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        Boolean mustChange = (Boolean) (s != null ? s.getAttribute("PENDING_PW_CHANGE") : Boolean.FALSE);
        showChangeDialog = Boolean.TRUE.equals(mustChange);        
    }

    public boolean isShowChangeDialog() {
        return showChangeDialog;
    }
    public void setShowChangeDialog(boolean v) {
        this.showChangeDialog = v;
    }
}

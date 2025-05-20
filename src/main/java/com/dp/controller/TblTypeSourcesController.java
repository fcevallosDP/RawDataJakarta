package com.dp.controller;

import com.dp.entity.TblTypeSources;
import com.dp.controller.util.JsfUtil;
import com.dp.controller.util.JsfUtil.PersistAction;
import com.dp.facade.TblTypeSourcesFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.ejb.EJB;
import jakarta.ejb.EJBException;
import jakarta.inject.Named;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.faces.view.ViewScoped;

@Named("tblTypeSourcesController")
@ViewScoped
public class TblTypeSourcesController implements Serializable {

    //@EJB
    private TblTypeSourcesFacade ejbFacade = new TblTypeSourcesFacade();
    private List<TblTypeSources> items = null;
    private TblTypeSources selected;

    public TblTypeSourcesController() {
    }

    public TblTypeSources getSelected() {
        return selected;
    }

    public void setSelected(TblTypeSources selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TblTypeSourcesFacade getFacade() {
        return ejbFacade;
    }

    public TblTypeSources prepareCreate() {
        selected = new TblTypeSources();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle1").getString("TblTypeSourcesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle1").getString("TblTypeSourcesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle1").getString("TblTypeSourcesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TblTypeSources> getItems() {
        if (items == null) {
            items = getFacade().getItemsEnabled();//findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle1").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle1").getString("PersistenceErrorOccured"));
            }
        }
    }

    public TblTypeSources getTblTypeSources(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<TblTypeSources> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TblTypeSources> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TblTypeSources.class)
    public static class TblTypeSourcesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TblTypeSourcesController controller = (TblTypeSourcesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tblTypeSourcesController");
            return controller.getTblTypeSources(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TblTypeSources) {
                TblTypeSources o = (TblTypeSources) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TblTypeSources.class.getName()});
                return null;
            }
        }

    }

}

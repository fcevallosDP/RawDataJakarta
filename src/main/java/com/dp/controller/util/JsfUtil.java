package com.dp.controller.util;

import com.dp.util.TblUsers;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.model.SelectItem;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class JsfUtil {

    public static SelectItem[] getSelectItems(List<?> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "---");
            i++;
        }
        for (Object x : entities) {
            items[i++] = new SelectItem(x, x.toString());
        }
        return items;
    }

    public static boolean isValidationFailed() {
        return FacesContext.getCurrentInstance().isValidationFailed();
    }

    public static void addErrorMessage(Exception ex, String defaultMsg) {
        String msg = ex.getLocalizedMessage();
        if (msg != null && msg.length() > 0) {
            addErrorMessage(msg);
        } else {
            addErrorMessage(defaultMsg);
        }
    }

    public static void addErrorMessages(List<String> messages) {
        for (String message : messages) {
            addErrorMessage(message);
        }
    }

    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

    public static String getRequestParameter(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
    }

    public static Object getObjectFromRequestParameter(String requestParameterName, Converter converter, UIComponent component) {
        String theId = JsfUtil.getRequestParameter(requestParameterName);
        return converter.getAsObject(FacesContext.getCurrentInstance(), component, theId);
    }

    public static enum PersistAction {
        CREATE,
        DELETE,
        UPDATE
    }
    public static HttpSession getSession() {
        return (HttpSession)
          FacesContext.
          getCurrentInstance().
          getExternalContext().
          getSession(false);
    }
       
    public static HttpServletRequest getRequest() {
     return (HttpServletRequest) FacesContext.
        getCurrentInstance().
        getExternalContext().getRequest();
    }
    private static String convertToHex(byte[] raw) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < raw.length; i++) {
            sb.append(Integer.toString((raw[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
    
    public static String generateHash(String cadena) {
        MessageDigest md = null;
        byte[] hash = null;
            try {
                md = MessageDigest.getInstance("SHA-512");
                hash = md.digest(cadena.getBytes("UTF-8"));
               } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                 } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return convertToHex(hash);
    }    
    
    public static TblUsers getUsuarioSesion()
    {
          try {
            TblUsers usuario = (TblUsers) ((HttpServletRequest) (FacesContext.getCurrentInstance()
                    .getExternalContext().getRequest())).getSession().getAttribute("SESVAR_Usuario");
            return usuario;

        } catch (Exception e) {
            addErrorMessage("Something went wrong trying to get the user");
            return null;
        }
    }    
}

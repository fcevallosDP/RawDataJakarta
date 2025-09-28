package com.dp.controller.util;

/**
 *
 * @author ZAMBRED
 */
import java.io.Serializable;
import com.dp.util.DAOFile;
import com.dp.util.TblProfiles;
import com.dp.util.TblRawDataNotifications;
import com.dp.util.TblUsers;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Produces;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.management.Notification;
import org.primefaces.PrimeFaces;

/**
 *
 * @author zambred
 */
@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    private String username;
    private String password;
    private String newPassword;
    private String confirmPassword;    
    private TblUsers LoggedInUser;
    private BigInteger currentView = null;
    private String autorizacion = "";
    private String hostname;
    private Boolean notificatorOpened = false;
    private String notificationTitle;
    private boolean showFirstLoginDialog;
    private boolean lbIfAdmin = false;
    private String ipaddress;
    private List<TblRawDataNotifications> notificaciones;
    private List<String> notifications = new ArrayList<String>();
    private List<String> rutas = new ArrayList<String>();

    public String getHostname() {
        return hostname;
    }

    public boolean isShowFirstLoginDialog() { return showFirstLoginDialog; }
    public void setShowFirstLoginDialog(boolean v) { showFirstLoginDialog = v; }		

    public String getNewPassword() { return newPassword; }
    public void setNewPassword(String s) { newPassword = s; }
    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String s) { confirmPassword = s; }
    
    public List<TblRawDataNotifications> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<TblRawDataNotifications> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public Boolean setOpenCloseNotificator(){
        return notificatorOpened = !notificatorOpened;
    }
    
    public Boolean getNotificatorOpened() {
        return notificatorOpened;
    }

    public void setNotificatorOpened(Boolean notificatorOpened) {
        this.notificatorOpened = notificatorOpened;
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<String> notifications) {
        this.notifications = notifications;
    }

    public boolean isAuthorized(String url)
    {
        for (String rt:rutas){
            if (url.contains(rt)) return true;
        }
        return false;
    }
    
    public List<String> getRutas()
    {
        return rutas;
    }

    public void setRutas(List<String> rutas) {
        this.rutas = rutas;
    }
    
    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public void setCurrentView(BigInteger op)
    {
        currentView=op;
    }
    public BigInteger getCurrentView()
    {
        return currentView;
    }
    public void setLoggedInUser(TblUsers User)
    {
        LoggedInUser=User;
    }

    public TblUsers getLoggedInUser()
    {
        return LoggedInUser;
    }

    public void setUsername(String Username)
    {
        username=Username;//.toLowerCase();
    }
    public String getUsername()
    {
        return username;
    }

    public boolean isLbIfAdmin() {
        return lbIfAdmin;
    }

    public void setLbIfAdmin(boolean lbIfAdmin) {
        this.lbIfAdmin = lbIfAdmin;
    }
    
    public void setPassword(String Password)
    {
        password=Password;
    }
    public String getPassword()
    {
        return password;
    }
    public LoginBean() {
      
    }
    //private int countReload = 0;

/*    public static class SimpleNotification {
        private String message;
        private LocalDateTime timestamp;

        public SimpleNotification(String message, LocalDateTime timestamp) {
            this.message = message;
            this.timestamp = timestamp;
        }

        public SimpleNotification(String message) {
            this.message = message;            
        }
        
        
        public String getMessage() {
            return message;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public String getFormattedTimestamp() {
            return timestamp.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        }    
        
    }            
*/    
    public void triggerIdle() {
        try {
            //System.out.println("countReload: " + String.valueOf(countReload++));  
            if(this.LoggedInUser !=null){
                System.out.println("kicked out!");
                logout();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }    
    
    public void resetPassword()
    {
        if (newPassword == null || !newPassword.equals(confirmPassword)) {
            JsfUtil.addErrorMessage("Passwords do not match");
        }else{        
            try{
                DAOFile dbCon = new DAOFile();       
                LoggedInUser = dbCon.getItemUserById(LoggedInUser.getIdUser());
                if (LoggedInUser != null){
                    LoggedInUser.setvPassword(JsfUtil.generateHash(newPassword));
                    LoggedInUser.setFirstLogin(false);
                    dbCon.setUpdateUser(LoggedInUser);
                    newPassword = null;
                    confirmPassword = null;                    
                    showFirstLoginDialog = false;
                    JsfUtil.addSuccessMessage("Password changed successfully!");                    
                }
            }catch (Exception e) {        
                e.printStackTrace();
                JsfUtil.addErrorMessage("Something went wrong");
            }
        }
    }
    
    @Produces
    public String login() {
        try {
            DAOFile dbCon = new DAOFile();
            notificaciones = new ArrayList<>();
            TblUsers u = dbCon.getItemUserByUserAndPass(username, JsfUtil.generateHash(password));

            if (u == null) {
                this.password = "";
                JsfUtil.addErrorMessage("Login failed!");
                return "login";
            }

            if (u.getiStatus() == 0) { // inactivo
                this.password = "";
                JsfUtil.addErrorMessage("The user is inactive");
                return "login";
            }
            
            lbIfAdmin = false;   
            TblProfiles perfil = u.getIdProfile();
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            request.getSession().setAttribute("SESVAR_Usuario", u);                
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            this.hostname = request.getRemoteHost();
            this.hostname = InetAddress.getByName(hostname).getCanonicalHostName();                
            this.ipaddress = request.getRemoteAddr();                
            if(perfil != null){

                dbCon.insertSessionLog(u.getIdUser(), this.hostname, this.ipaddress);
                if (perfil.getVDescription().toUpperCase().contains("ADMIN")){
                    lbIfAdmin = true;                        
                }
                notificaciones = dbCon.getNotificaciones(u.getvAgency());                                        
                this.setLoggedInUser(u);
                dbCon.setLastLogin(u);
                showFirstLoginDialog = Boolean.TRUE.equals(u.getFirstLogin());                
                externalContext.redirect(externalContext.getRequestContextPath() + "/index.xhtml");                
                return "index";
            }                        

            return null; 
            
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Something went wrong!");
            this.password = "";
            return "login";
        }
    }
    
/*
    public String login()
    {
        try
        {
           DAOFile dbCon = new DAOFile();
           notificaciones = new ArrayList();
           this.setLoggedInUser(dbCon.getItemUserByUserAndPass(username,JsfUtil.generateHash(password)));

           if(this.LoggedInUser==null)
           {
               this.setPassword("");
               JsfUtil.addErrorMessage("Login failed!");          
               
           }else
           {
               if (this.LoggedInUser.getiStatus() > 0) 
               {
                lbIfAdmin = false;   
                TblProfiles perfil = this.LoggedInUser.getIdProfile();
                HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                request.getSession().setAttribute("SESVAR_Usuario", this.LoggedInUser);                
                ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                this.hostname = request.getRemoteHost();
                this.hostname = InetAddress.getByName(hostname).getCanonicalHostName();                
                this.ipaddress = request.getRemoteAddr();                
                if(perfil != null){
                    dbCon.insertSessionLog(this.LoggedInUser.getIdUser(), this.hostname, this.ipaddress);
                    if (perfil.getVDescription().toUpperCase().contains("ADMIN")){
                        lbIfAdmin = true;                        
                    }
                    
                    notificaciones = dbCon.getNotificaciones(this.LoggedInUser.getvAgency());                                        
                    
                    externalContext.redirect(externalContext.getRequestContextPath() + "/index.xhtml");
                    return "index";
                }         
               }else{
                    this.setLoggedInUser(null);
                    this.setPassword("");
                   JsfUtil.addErrorMessage("The user is inactive");                   
               }
               return "login";               
           }
        } catch (Exception e)
        {
            JsfUtil.addErrorMessage("Something went wrong!");
            this.setPassword(""); 
            return "login";
        }finally{            
        }
        return "login";
    }
 */   
    public void logout() throws IOException {
        HttpSession session = JsfUtil.getSession();
        if(session != null){
            session.invalidate();
            this.setLoggedInUser(null);
            this.setPassword("");        
        }
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect(externalContext.getRequestContextPath() + "/");
   }
    
    public void keepUserSessionAlive() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        request.getSession();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.util;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author ZAMBRED
 */
public class TblUsers implements Serializable  {
    private Integer idUser;
    private String vName;
    private String vLastName;
    private String vUser;
    private String vAgency;
    private String vPassword;
    private Date dSystemDate;
    private TblProfiles idProfile;
    private int iStatus;
    private Boolean firstLogin;
    private Date lastLogin;
    private Date passwordChangedAt;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getvName() {
        return vName;
    }

    public String getvAgency() {
        return vAgency;
    }

    public void setvAgency(String vAgency) {
        this.vAgency = vAgency;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvLastName() {
        return vLastName;
    }

    public Boolean getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getPasswordChangedAt() {
        return passwordChangedAt;
    }

    public void setPasswordChangedAt(Date passwordChangedAt) {
        this.passwordChangedAt = passwordChangedAt;
    }

    public String getFullName(){
        if(vLastName != null && vName != null){
            return vLastName.concat(", ").concat(vName);
        }
        return "";
    }
    
    public void setvLastName(String vLastName) {
        this.vLastName = vLastName;
    }

    public String getvUser() {
        return vUser;
    }

    public void setvUser(String vUser) {
        this.vUser = vUser;
    }

    public String getvPassword() {
        return vPassword;
    }

    public void setvPassword(String vPassword) {
        this.vPassword = vPassword;
    }

    public Date getdSystemDate() {
        return dSystemDate;
    }

    public void setdSystemDate(Date dSystemDate) {
        this.dSystemDate = dSystemDate;
    }

    public TblProfiles getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(TblProfiles idProfile) {
        this.idProfile = idProfile;
    }

    public int getiStatus() {
        return iStatus;
    }

    public void setiStatus(int iStatus) {
        this.iStatus = iStatus;
    }
        
}

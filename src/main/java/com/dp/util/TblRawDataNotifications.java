/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dp.util;

/**
 *
 * @author ZAMBRED
 */
public class TblRawDataNotifications {
    private String vType;
    private String vKind;
    private String vDate;
    private String vFileName;
    private String vDeal;
    private String vDealId;
    private String vAgency;        
    private String message;
    public String getvDeal() {
        return vDeal;
    }

    public void setvDeal(String vDeal) {
        this.vDeal = vDeal;
    }

    public String getvType() {
        return vType;
    }

    public void setvType(String vType) {
        this.vType = vType;
    }

    public String getvKind() {
        return vKind;
    }

    public void setvKind(String vKind) {
        this.vKind = vKind;
    }

    public String getvDate() {
        return vDate;
    }

    public void setvDate(String vDate) {
        this.vDate = vDate;
    }

    public String getvFileName() {
        return vFileName;
    }

    public void setvFileName(String vFileName) {
        this.vFileName = vFileName;
    }

    public String getvDealId() {
        return vDealId;
    }

    public void setvDealId(String vDealId) {
        this.vDealId = vDealId;
    }

    public String getvAgency() {
        return vAgency;
    }

    public void setvAgency(String vAgency) {
        this.vAgency = vAgency;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }   
    
}

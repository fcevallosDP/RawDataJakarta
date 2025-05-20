/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.util;

/**
 *
 * @author ZAMBRED
 */
public class TblHistoricalDSP {
    private Integer Id;
    private Integer iYear;
    private Integer iMonth;
    private String vClient;
    private String vChannel;
    private String vVendor;
    private String vDsp;
    private String vVendorSource;
    private String vAgency;
    private Integer iImpressions;
    private Integer iClicks;
    private Double dMediaSpend;
    private Double dTotalMediaCosts;   
    private Double dCPM;
    private Double dCTR;
    private Double dCPC;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Integer getiYear() {
        return iYear;
    }

    public void setiYear(Integer iYear) {
        this.iYear = iYear;
    }

    public Integer getiMonth() {
        return iMonth;
    }

    public void setiMonth(Integer iMonth) {
        this.iMonth = iMonth;
    }

    public String getvClient() {
        return vClient;
    }

    public void setvClient(String vClient) {
        this.vClient = vClient;
    }

    public String getvChannel() {
        return vChannel;
    }

    public void setvChannel(String vChannel) {
        this.vChannel = vChannel;
    }

    public String getvVendor() {
        return vVendor;
    }

    public void setvVendor(String vVendor) {
        this.vVendor = vVendor;
    }

    public String getvDsp() {
        return vDsp;
    }

    public void setvDsp(String vDsp) {
        this.vDsp = vDsp;
    }

    public String getvVendorSource() {
        return vVendorSource;
    }

    public void setvVendorSource(String vVendorSource) {
        this.vVendorSource = vVendorSource;
    }

    public String getvAgency() {
        return vAgency;
    }

    public void setvAgency(String vAgency) {
        this.vAgency = vAgency;
    }

    public Integer getiImpressions() {
        return iImpressions;
    }

    public void setiImpressions(Integer iImpressions) {
        this.iImpressions = iImpressions;
    }

    public Integer getiClicks() {
        return iClicks;
    }

    public void setiClicks(Integer iClicks) {
        this.iClicks = iClicks;
    }

    public Double getdMediaSpend() {
        return dMediaSpend;
    }

    public void setdMediaSpend(Double dMediaSpend) {
        this.dMediaSpend = dMediaSpend;
    }

    public Double getdTotalMediaCosts() {
        return dTotalMediaCosts;
    }

    public void setdTotalMediaCosts(Double dTotalMediaCosts) {
        this.dTotalMediaCosts = dTotalMediaCosts;
    }

    public Double getdCPM() {
        return dCPM;
    }

    public void setdCPM(Double dCPM) {
        this.dCPM = dCPM;
    }

    public Double getdCTR() {
        return dCTR;
    }

    public void setdCTR(Double dCTR) {
        this.dCTR = dCTR;
    }

    public Double getdCPC() {
        return dCPC;
    }

    public void setdCPC(Double dCPC) {
        this.dCPC = dCPC;
    }
       
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.util;
import java.util.Date;
/**
 *
 * @author ZAMBRED
 */
public class TblDVXANDRSPD {
    private Integer id;
    private String vDate;
    private Date dDate;    
    private String vAdvertiser;
    private String vBrand;
    private String vDeal;
    private String vDevice;
    private String vFileName;
    private Double dGrossMargin;
    private Integer iImpressions;
    private Double dSalesRevenue;
    private Double dTechFee;
    private Double dMediaCost;
    private Double dTotalCost;
    private Double dCPM;
    private String vUser;
    private Double dMlFee;
    private Double dMarginFee;
    private Double dDspFee;
    private Double dGrossRevenue;
    private Double dNetRevenue;
    private String vClient;
    private String vChannel;
    private String vDsp;
    private String vAgency;
    private int iYear;
    private int iMonth;
    private int iDay;        
    private String vSeat;
    private String vExchange;
    private Double dMargin;   
    private Double dNetMargin;
    private TblDailyProcess idDaily;

    public Integer getId() {
        return id;
    }

    public String getvUser() {
        return vUser;
    }

    public void setvUser(String vUser) {
        this.vUser = vUser;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getvDate() {
        return vDate;
    }

    public String getVFileName() {
        return vFileName;
    }

    public void setVFileName(String vFileName) {
        this.vFileName = vFileName;
    }

    public Date getdDate() {
        return dDate;
    }

    public void setdDate(Date dDate) {
        this.dDate = dDate;
    }

    public void setvDate(String vDate) {
        this.vDate = vDate;
    }

    public TblDailyProcess getIdDaily() {
        return idDaily;
    }

    public void setIdDaily(TblDailyProcess idDaily) {
        this.idDaily = idDaily;
    }

    public Double getdNetRevenue() {
        return dNetRevenue;
    }

    public void setdNetRevenue(Double dNetRevenue) {
        this.dNetRevenue = dNetRevenue;
    }

    public String getvAdvertiser() {
        return vAdvertiser;
    }

    public void setvAdvertiser(String vAdvertiser) {
        this.vAdvertiser = vAdvertiser;
    }

    public String getvBrand() {
        return vBrand;
    }

    public Double getdNetMargin() {
        return dNetMargin;
    }

    public void setdNetMargin(Double dNetMargin) {
        this.dNetMargin = dNetMargin;
    }

    public void setvBrand(String vBrand) {
        this.vBrand = vBrand;
    }

    public String getvDeal() {
        return vDeal;
    }

    public void setvDeal(String vDeal) {
        this.vDeal = vDeal;
    }

    public String getvDevice() {
        return vDevice;
    }

    public void setvDevice(String vDevice) {
        this.vDevice = vDevice;
    }

    public Double getdGrossMargin() {
        return dGrossMargin;
    }

    public void setdGrossMargin(Double dGrossMargin) {
        this.dGrossMargin = dGrossMargin;
    }

    public Integer getiImpressions() {
        return iImpressions;
    }

    public void setiImpressions(Integer iImpressions) {
        this.iImpressions = iImpressions;
    }

    public Double getdSalesRevenue() {
        return dSalesRevenue;
    }

    public void setdSalesRevenue(Double dSalesRevenue) {
        this.dSalesRevenue = dSalesRevenue;
    }

    public Double getdTechFee() {
        return dTechFee;
    }

    public void setdTechFee(Double dTechFee) {
        this.dTechFee = dTechFee;
    }

    public Double getdMediaCost() {
        return dMediaCost;
    }

    public void setdMediaCost(Double dMediaCost) {
        this.dMediaCost = dMediaCost;
    }

    public Double getdTotalCost() {
        return dTotalCost;
    }

    public void setdTotalCost(Double dTotalCost) {
        this.dTotalCost = dTotalCost;
    }

    public Double getdCPM() {
        return dCPM;
    }

    public void setdCPM(Double dCPM) {
        this.dCPM = dCPM;
    }

    public Double getdMlFee() {
        return dMlFee;
    }

    public void setdMlFee(Double dMlFee) {
        this.dMlFee = dMlFee;
    }

    public Double getdMarginFee() {
        return dMarginFee;
    }

    public void setdMarginFee(Double dMarginFee) {
        this.dMarginFee = dMarginFee;
    }

    public Double getdDspFee() {
        return dDspFee;
    }

    public void setdDspFee(Double dDspFee) {
        this.dDspFee = dDspFee;
    }

    public Double getdGrossRevenue() {
        return dGrossRevenue;
    }

    public void setdGrossRevenue(Double dGrossRevenue) {
        this.dGrossRevenue = dGrossRevenue;
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

    public String getvDsp() {
        return vDsp;
    }

    public void setvDsp(String vDsp) {
        this.vDsp = vDsp;
    }

    public String getvAgency() {
        return vAgency;
    }

    public void setvAgency(String vAgency) {
        this.vAgency = vAgency;
    }

    public int getiYear() {
        return iYear;
    }

    public void setiYear(int iYear) {
        this.iYear = iYear;
    }

    public int getiMonth() {
        return iMonth;
    }

    public void setiMonth(int iMonth) {
        this.iMonth = iMonth;
    }

    public int getiDay() {
        return iDay;
    }

    public void setiDay(int iDay) {
        this.iDay = iDay;
    }

    public String getvSeat() {
        return vSeat;
    }

    public void setvSeat(String vSeat) {
        this.vSeat = vSeat;
    }

    public String getvExchange() {
        return vExchange;
    }

    public void setvExchange(String vExchange) {
        this.vExchange = vExchange;
    }

    public Double getdMargin() {
        return dMargin;
    }

    public void setdMargin(Double dMargin) {
        this.dMargin = dMargin;
    }        
}

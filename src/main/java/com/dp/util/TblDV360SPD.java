/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.util;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author ZAMBRED
 */
public class TblDV360SPD {
    private Integer id;

    private String vDate;
    private Date dDate;    
    private int iDia;
    private int iMes;
    private int iAnio;
    private int iSemana;
    private String vPartner;
    private String vAdvertiser;
    private String vCampaign;
    private String vInsertionOrder;
    private String vLineItem;
    private String vFileName;
    private String vExchange;
    private String vDeviceType;
    private String vDealName;
    private Integer iImpressions;
    private Integer iClicks;
    private Integer iCompleteViews;
    private Integer iDPerf;
    private Timestamp modifiedDate;
    private Double dMediaCosts;
    private Double dTotalMediaCosts;   
    private Double dCPM;
    private Double dRevenueCPM;
    private Double dCPM_W1;
    private Double dCPM_W2;
    private Double dCPM_W3;
    private Double dCPM_W4;
    private Double dCPM_W5;
    private Double dAVG_W;
    private Double dCPMGoal;
    private Double dCTRGoal;
    private Double dVCRGoal;
    private Double dACRGoal;
    private Double dClickRate;
    private Double dCTR;
    private Double dVCR;
    private Double dACR;
    private Double dCPC;
    private String vDSP;
    private String vUser;
    private String vClient;
    private String vAgency;
    private String vChannel;
    private String vAlias;
    private String vVendor;
    private String vVendorSource;
    private TblDailyProcess idDaily;
    private Integer idMontly;
    
    public TblDV360SPD() {
    }    

    public Integer getId() {
        return id;
    }

    public Double getdACR() {
        return dACR;
    }

    public void setdACR(Double dACR) {
        this.dACR = dACR;
    }

    public Integer getiCompleteViews() {
        return iCompleteViews;
    }

    public Double getdACRGoal() {
        return dACRGoal;
    }

    public void setdACRGoal(Double dACRGoal) {
        this.dACRGoal = dACRGoal;
    }

    public void setiCompleteViews(Integer iCompleteViews) {
        this.iCompleteViews = iCompleteViews;
    }

    public Double getdVCRGoal() {
        return dVCRGoal;
    }

    public void setdVCRGoal(Double dVCRGoal) {
        this.dVCRGoal = dVCRGoal;
    }

    public Integer getIdMontly() {
        return idMontly;
    }

    public void setIdMontly(Integer idMontly) {
        this.idMontly = idMontly;
    }

    public Double getdVCR() {
        return dVCR;
    }

    public void setdVCR(Double dVCR) {
        this.dVCR = dVCR;
    }

    public Integer getiDPerf() {
        return iDPerf;
    }

    public void setiDPerf(Integer iDPerf) {
        this.iDPerf = iDPerf;
    }

    public String getvAdvertiser() {
        return vAdvertiser;
    }

    public void setvAdvertiser(String vAdvertiser) {
        this.vAdvertiser = vAdvertiser;
    }

    public Double getdCTRGoal() {
        return dCTRGoal;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setdCTRGoal(Double dCTRGoal) {
        this.dCTRGoal = dCTRGoal;
    }

    public int getiSemana() {
        return iSemana;
    }

    public void setiSemana(int iSemana) {
        this.iSemana = iSemana;
    }

    public Double getdRevenueCPM() {
        return dRevenueCPM;
    }

    public Double getdAVG_W() {
        return dAVG_W;
    }

    public void setdAVG_W(Double dAVG_W) {
        this.dAVG_W = dAVG_W;
    }

    public void setdRevenueCPM(Double dRevenueCPM) {
        this.dRevenueCPM = dRevenueCPM;
    }

    public Double getdClickRate() {
        return dClickRate;
    }

    public void setdClickRate(Double dClickRate) {
        this.dClickRate = dClickRate;
    }

    public Double getdCPM_W1() {
        return dCPM_W1;
    }

    public void setdCPM_W1(Double dCPM_W1) {
        this.dCPM_W1 = dCPM_W1;
    }

    public Double getdCPM_W2() {
        return dCPM_W2;
    }

    public void setdCPM_W2(Double dCPM_W2) {
        this.dCPM_W2 = dCPM_W2;
    }

    public Double getdCPM_W3() {
        return dCPM_W3;
    }

    public void setdCPM_W3(Double dCPM_W3) {
        this.dCPM_W3 = dCPM_W3;
    }

    public Double getdCPM_W4() {
        return dCPM_W4;
    }

    public void setdCPM_W4(Double dCPM_W4) {
        this.dCPM_W4 = dCPM_W4;
    }

    public Double getdCPM_W5() {
        return dCPM_W5;
    }

    public void setdCPM_W5(Double dCPM_W5) {
        this.dCPM_W5 = dCPM_W5;
    }

    public Double getdCPMGoal() {
        return dCPMGoal;
    }

    public void setdCPMGoal(Double dCPMGoal) {
        this.dCPMGoal = dCPMGoal;
    }

    public String getvDeviceType() {
        return vDeviceType;
    }

    public void setvDeviceType(String vDeviceType) {
        this.vDeviceType = vDeviceType;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getvUser() {
        return vUser;
    }

    public void setvUser(String vUser) {
        this.vUser = vUser;
    }

    public void setdDate(Date dDate) {
        this.dDate = dDate;
    }

    public String getvDate() {
        return vDate;
    }

    public void setvDate(String vDate) {
        this.vDate = vDate;
    }

    public int getiDia() {
        return iDia;
    }

    public void setiDia(int iDia) {
        this.iDia = iDia;
    }

    public int getiMes() {
        return iMes;
    }

    public void setiMes(int iMes) {
        this.iMes = iMes;
    }

    public int getiAnio() {
        return iAnio;
    }

    public TblDailyProcess getIdDaily() {
        return idDaily;
    }

    public void setIdDaily(TblDailyProcess idDaily) {
        this.idDaily = idDaily;
    }

    public void setiAnio(int iAnio) {
        this.iAnio = iAnio;
    }

    public String getvPartner() {
        return vPartner;
    }

    public void setvPartner(String vPartner) {
        this.vPartner = vPartner;
    }

    public String getvCampaign() {
        return vCampaign;
    }

    public void setvCampaign(String vCampaign) {
        this.vCampaign = vCampaign;
    }

    public String getvInsertionOrder() {
        return vInsertionOrder;
    }

    public void setvInsertionOrder(String vInsertionOrder) {
        this.vInsertionOrder = vInsertionOrder;
    }

    public String getvLineItem() {
        return vLineItem;
    }

    public void setvLineItem(String vLineItem) {
        this.vLineItem = vLineItem;
    }

    public String getvExchange() {
        return vExchange;
    }

    public void setvExchange(String vExchange) {
        this.vExchange = vExchange;
    }

    public String getvDealName() {
        return vDealName;
    }

    public void setvDealName(String vDealName) {
        this.vDealName = vDealName;
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

    public Double getdMediaCosts() {
        return dMediaCosts;
    }

    public void setdMediaCosts(Double dMediaCosts) {
        this.dMediaCosts = dMediaCosts;
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

    public String getvDSP() {
        return vDSP;
    }

    public void setvDSP(String vDSP) {
        this.vDSP = vDSP;
    }

    public String getvClient() {
        return vClient;
    }

    public void setvClient(String vClient) {
        this.vClient = vClient;
    }

    public String getvAgency() {
        return vAgency;
    }

    public void setvAgency(String vAgency) {
        this.vAgency = vAgency;
    }

    public String getvChannel() {
        return vChannel;
    }

    public void setvChannel(String vChannel) {
        this.vChannel = vChannel;
    }

    public String getvAlias() {
        return vAlias;
    }

    public void setvAlias(String vAlias) {
        this.vAlias = vAlias;
    }

    public String getvVendor() {
        return vVendor;
    }

    public void setvVendor(String vVendor) {
        this.vVendor = vVendor;
    }

    public String getvVendorSource() {
        return vVendorSource;
    }

    public void setvVendorSource(String vVendorSource) {
        this.vVendorSource = vVendorSource;
    }


}

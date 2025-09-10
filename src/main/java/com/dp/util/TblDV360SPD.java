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
    private Double dCTR_W1;
    private Double dCTR_W2;
    private Double dCTR_W3;
    private Double dCTR_W4;
    private Double dCTR_W5;
    private Double dVCR_W1;
    private Double dVCR_W2;
    private Double dVCR_W3;
    private Double dVCR_W4;
    private Double dVCR_W5;
    private Double dACR_W1;
    private Double dACR_W2;
    private Double dACR_W3;
    private Double dACR_W4;
    private Double dACR_W5;    
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

    public Double getdCTR_W1() {
        return dCTR_W1;
    }

    public void setdCTR_W1(Double dCTR_W1) {
        this.dCTR_W1 = dCTR_W1;
    }

    public Double getdCTR_W2() {
        return dCTR_W2;
    }

    public void setdCTR_W2(Double dCTR_W2) {
        this.dCTR_W2 = dCTR_W2;
    }

    public Double getdCTR_W3() {
        return dCTR_W3;
    }

    public void setdCTR_W3(Double dCTR_W3) {
        this.dCTR_W3 = dCTR_W3;
    }

    public Double getdCTR_W4() {
        return dCTR_W4;
    }

    public void setdCTR_W4(Double dCTR_W4) {
        this.dCTR_W4 = dCTR_W4;
    }

    public Double getdCTR_W5() {
        return dCTR_W5;
    }

    public void setdCTR_W5(Double dCTR_W5) {
        this.dCTR_W5 = dCTR_W5;
    }

    public Double getdVCR_W1() {
        return dVCR_W1;
    }

    public void setdVCR_W1(Double dVCR_W1) {
        this.dVCR_W1 = dVCR_W1;
    }

    public Double getdVCR_W2() {
        return dVCR_W2;
    }

    public void setdVCR_W2(Double dVCR_W2) {
        this.dVCR_W2 = dVCR_W2;
    }

    public Double getdVCR_W3() {
        return dVCR_W3;
    }

    public void setdVCR_W3(Double dVCR_W3) {
        this.dVCR_W3 = dVCR_W3;
    }

    public Double getdVCR_W4() {
        return dVCR_W4;
    }

    public void setdVCR_W4(Double dVCR_W4) {
        this.dVCR_W4 = dVCR_W4;
    }

    public Double getdVCR_W5() {
        return dVCR_W5;
    }

    public void setdVCR_W5(Double dVCR_W5) {
        this.dVCR_W5 = dVCR_W5;
    }

    public Double getdACR_W1() {
        return dACR_W1;
    }

    public void setdACR_W1(Double dACR_W1) {
        this.dACR_W1 = dACR_W1;
    }

    public Double getdACR_W2() {
        return dACR_W2;
    }

    public void setdACR_W2(Double dACR_W2) {
        this.dACR_W2 = dACR_W2;
    }

    public Double getdACR_W3() {
        return dACR_W3;
    }

    public void setdACR_W3(Double dACR_W3) {
        this.dACR_W3 = dACR_W3;
    }

    public Double getdACR_W4() {
        return dACR_W4;
    }

    public void setdACR_W4(Double dACR_W4) {
        this.dACR_W4 = dACR_W4;
    }

    public Double getdACR_W5() {
        return dACR_W5;
    }

    public void setdACR_W5(Double dACR_W5) {
        this.dACR_W5 = dACR_W5;
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

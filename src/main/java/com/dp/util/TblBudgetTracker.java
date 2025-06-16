/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.util;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
//import org.bouncycastle.asn1.tsp.TimeStampReq;

/**
 *
 * @author ZAMBRED
 */
public class TblBudgetTracker {
    private Integer Id;
    private Integer IdBudget;
    private Integer iYear;
    private Integer iMonthly;
    private Integer iDay;
    private Integer iFlightDays;
    private Integer iRemainingDays;
    private Date dDate;
    private Integer iMonth;
    private String vPlatform;
    private String vPartner;
    private String vClient;
    private String vAgency;
    private String vCampaign;
    private String vInsertionOrder;
    //private String vLineItem;
    private String vChannel;
    private String vUser;    
    private Double dBudget;
    private Double dTotalMTDProjSpend;
    private Double dProjBudgPerc;
    private Double dBudgetPacing;
    private Double dPacingPercent;
    private Double dDifBudgetPacPerc;
    private Double dDifSpendProjectSpend;
    private Double dTotalMediaCost;
    private Double dProjPacing;
    private Double dMediaSpend;
    private Double dBalance;
    private Double dDailyTarget;
    private Double dDailyRemaining;
    private Double dAdjusted;
    private Double dYesterdaySpend;
    private Double dProjDailySpend;
    private Double dMtdCTR;
    private Boolean bUnderYestCTR;
    private Boolean bUnderMTDCTR;
    private Double dYestCTR;
    private Date startDate;
    private Date endDate;
    private Timestamp modifiedDate;
    private List<TblLineItems> lineItems;
    private Boolean bUnderPacing;
    private Boolean bOverPacing;
    
    
    public Integer getId() {
        return Id;
    }

    public Integer getiMonthly() {
        return iMonthly;
    }

    public void setiMonthly(Integer iMonthly) {
        this.iMonthly = iMonthly;
    }

    public Boolean getbUnderYestCTR() {
        return bUnderYestCTR;
    }

    public void setbUnderYestCTR(Boolean bUnderYestCTR) {
        this.bUnderYestCTR = bUnderYestCTR;
    }

    public Boolean getbUnderMTDCTR() {
        return bUnderMTDCTR;
    }

    public void setbUnderMTDCTR(Boolean bUnderMTDCTR) {
        this.bUnderMTDCTR = bUnderMTDCTR;
    }

    public Double getdPacingPercent() {
        return dPacingPercent;
    }

    public void setdPacingPercent(Double dPacingPercent) {
        this.dPacingPercent = dPacingPercent;
    }

    public Boolean getbUnderPacing() {
        return bUnderPacing;
    }

    public String getvClient() {
        return vClient;
    }

    public String getvAgency() {
        return vAgency;
    }

    public Double getdMtdCTR() {
        return dMtdCTR;
    }

    public void setdMtdCTR(Double dMtdCTR) {
        this.dMtdCTR = dMtdCTR;
    }

    public Double getdYestCTR() {
        return dYestCTR;
    }

    public void setdYestCTR(Double dYestCTR) {
        this.dYestCTR = dYestCTR;
    }

    public void setvAgency(String vAgency) {
        this.vAgency = vAgency;
    }

    public void setvClient(String vClient) {
        this.vClient = vClient;
    }

    public void setbUnderPacing(Boolean bUnderPacing) {
        this.bUnderPacing = bUnderPacing;
    }

    public Boolean getbOverPacing() {
        return bOverPacing;
    }

    public void setbOverPacing(Boolean bOverPacing) {
        this.bOverPacing = bOverPacing;
    }
        
    public List<TblLineItems> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<TblLineItems> lineItems) {
        this.lineItems = lineItems;
    }

    public Double getdAdjusted() {
        return dAdjusted;
    }

    public void setdAdjusted(Double dAdjusted) {
        this.dAdjusted = dAdjusted;
    }

    public Double getdProjPacing() {
        return dProjPacing;
    }

    public void setdProjPacing(Double dProjPacing) {
        this.dProjPacing = dProjPacing;
    }

    public Double getdDailyRemaining() {
        return dDailyRemaining;
    }

    public void setdDailyRemaining(Double dDailyRemaining) {
        this.dDailyRemaining = dDailyRemaining;
    }

    public Integer getIdBudget() {
        return IdBudget;
    }

    public String getvUser() {
        return vUser;
    }

    public void setvUser(String vUser) {
        this.vUser = vUser;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setIdBudget(Integer IdBudget) {
        this.IdBudget = IdBudget;
    }

    public Double getdProjDailySpend() {
        return dProjDailySpend;
    }

    public void setdProjDailySpend(Double dProjDailySpend) {
        this.dProjDailySpend = dProjDailySpend;
    }

    public Double getdBudgetPacing() {
        return dBudgetPacing;
    }

    public void setdBudgetPacing(Double dBudgetPacing) {
        this.dBudgetPacing = dBudgetPacing;
    }

    public Double getdDifBudgetPacPerc() {
        return dDifBudgetPacPerc;
    }

    public void setdDifBudgetPacPerc(Double dDifBudgetPacPerc) {
        this.dDifBudgetPacPerc = dDifBudgetPacPerc;
    }

    public Double getdDifSpendProjectSpend() {
        return dDifSpendProjectSpend;
    }

    public void setdDifSpendProjectSpend(Double dDifSpendProjectSpend) {
        this.dDifSpendProjectSpend = dDifSpendProjectSpend;
    }

    public Double getdBalance() {
        return dBalance;
    }

    public Double getdDailyTarget() {
        return dDailyTarget;
    }

    public void setdDailyTarget(Double dDailyTarget) {
        this.dDailyTarget = dDailyTarget;
    }

    public void setdBalance(Double dBalance) {
        this.dBalance = dBalance;
    }

    public Double getdProjBudgPerc() {
        return dProjBudgPerc;
    }

    public void setdProjBudgPerc(Double dProjBudgPerc) {
        this.dProjBudgPerc = dProjBudgPerc;
    }

    public Integer getiDay() {
        return iDay;
    }

    public Double getdTotalMTDProjSpend() {
        return dTotalMTDProjSpend;
    }

    public void setdTotalMTDProjSpend(Double dTotalMTDProjSpend) {
        this.dTotalMTDProjSpend = dTotalMTDProjSpend;
    }

    public void setiDay(Integer iDay) {
        this.iDay = iDay;
    }

    public Double getdYesterdaySpend() {
        return dYesterdaySpend;
    }

    public void setdYesterdaySpend(Double dYesterdaySpend) {
        this.dYesterdaySpend = dYesterdaySpend;
    }

    public Double getdBudget() {
        return dBudget;
    }

    public Integer getiRemainingDays() {
        return iRemainingDays;
    }

    public void setiRemainingDays(Integer iRemainingDays) {
        this.iRemainingDays = iRemainingDays;
    }

    public Integer getiFlightDays() {
        return iFlightDays;
    }

    public void setiFlightDays(Integer iFlightDays) {
        this.iFlightDays = iFlightDays;
    }

    public void setdBudget(Double dBudget) {
        this.dBudget = dBudget;
    }

    public String getvPlatform() {
        return vPlatform;
    }

    public void setvPlatform(String vPlatform) {
        this.vPlatform = vPlatform;
    }

    public Date getdDate() {
        return dDate;
    }

    public void setdDate(Date dDate) {
        this.dDate = dDate;
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

    public String getvChannel() {
        return vChannel;
    }

    public void setvChannel(String vChannel) {
        this.vChannel = vChannel;
    }

    public Double getdTotalMediaCost() {
        return dTotalMediaCost;
    }

    public void setdTotalMediaCost(Double dTotalMediaCost) {
        this.dTotalMediaCost = dTotalMediaCost;
    }

    public Double getdMediaSpend() {
        return dMediaSpend;
    }

    public void setdMediaSpend(Double dMediaSpend) {
        this.dMediaSpend = dMediaSpend;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}

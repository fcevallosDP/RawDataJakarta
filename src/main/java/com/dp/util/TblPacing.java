/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.util;

import java.sql.Date;

/**
 *
 * @author ZAMBRED
 */
public class TblPacing {
    private Integer Id;
    private Integer iYear;
    private Integer iMonth;
    private String vAgency;
    private String vClient;
    private String vChannel;
    private Double dBudget;
    private Double dPMPBudget;
    private Double dCampaignSpend;
    private Double dPMPSpend;
    private Double dConsumeRate;
    private Double dPMPRate;
    private Double dSuccessRate;
    private Double dPMPNetSplit;
    private Date startDate;
    private Date endDate;
    private Integer iDaysLeft;
    private Double dMT2YDaySpend;
    private Double dRemainingBudget;
    private Double dTargetDailySpend;

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

    public String getvAgency() {
        return vAgency;
    }

    public void setvAgency(String vAgency) {
        this.vAgency = vAgency;
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

    public Double getdBudget() {
        return dBudget;
    }

    public void setdBudget(Double dBudget) {
        this.dBudget = dBudget;
    }

    public Double getdPMPBudget() {
        return dPMPBudget;
    }

    public void setdPMPBudget(Double dPMPBudget) {
        this.dPMPBudget = dPMPBudget;
    }

    public Double getdCampaignSpend() {
        return dCampaignSpend;
    }

    public void setdCampaignSpend(Double dCampaignSpend) {
        this.dCampaignSpend = dCampaignSpend;
    }

    public Double getdPMPSpend() {
        return dPMPSpend;
    }

    public void setdPMPSpend(Double dPMPSpend) {
        this.dPMPSpend = dPMPSpend;
    }

    public Double getdConsumeRate() {
        return dConsumeRate;
    }

    public void setdConsumeRate(Double dConsumeRate) {
        this.dConsumeRate = dConsumeRate;
    }

    public Double getdPMPRate() {
        return dPMPRate;
    }

    public void setdPMPRate(Double dPMPRate) {
        this.dPMPRate = dPMPRate;
    }

    public Double getdSuccessRate() {
        return dSuccessRate;
    }

    public void setdSuccessRate(Double dSuccessRate) {
        this.dSuccessRate = dSuccessRate;
    }

    public Double getdPMPNetSplit() {
        return dPMPNetSplit;
    }

    public void setdPMPNetSplit(Double dPMPNetSplit) {
        this.dPMPNetSplit = dPMPNetSplit;
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

    public Integer getiDaysLeft() {
        return iDaysLeft;
    }

    public void setiDaysLeft(Integer iDaysLeft) {
        this.iDaysLeft = iDaysLeft;
    }

    public Double getdMT2YDaySpend() {
        return dMT2YDaySpend;
    }

    public void setdMT2YDaySpend(Double dMT2YDaySpend) {
        this.dMT2YDaySpend = dMT2YDaySpend;
    }

    public Double getdRemainingBudget() {
        return dRemainingBudget;
    }

    public void setdRemainingBudget(Double dRemainingBudget) {
        this.dRemainingBudget = dRemainingBudget;
    }

    public Double getdTargetDailySpend() {
        return dTargetDailySpend;
    }

    public void setdTargetDailySpend(Double dTargetDailySpend) {
        this.dTargetDailySpend = dTargetDailySpend;
    }
    
}

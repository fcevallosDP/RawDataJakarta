/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dp.api;
import jakarta.json.bind.annotation.JsonbProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
/**
 *
 * @author ZAMBRED
 */
public class RowDto {
    @JsonbProperty("deal_external_id")
    private String dealExternalId;

    @JsonbProperty("deal_name")
    private String dealName;

    @JsonbProperty("report_name")
    private String reportName;

    private BigDecimal spend;
    private Long impressions;
    private BigDecimal cpm;

    @JsonbProperty("report_date")
    private LocalDate reportDate;      // JSON: "YYYY-MM-DD"

    @JsonbProperty("media_cost")
    private BigDecimal mediaCost;

    @JsonbProperty("media_margin")
    private BigDecimal mediaMargin;

    @JsonbProperty("curator_margin_usd")
    private BigDecimal grossMargin;
    
    // opcional (si lo envías desde openx)
    @JsonbProperty("partner_fee")
    private BigDecimal partnerFee;

    @JsonbProperty("curator_tech_fee")
    private BigDecimal techFee;
    
    @JsonbProperty("curator_net_media_cost")
    private BigDecimal netMediaCost;

    @JsonbProperty("curator_total_cost")
    private BigDecimal totalCost;
    
    
    // getters/setters
    public String getDealExternalId() { return dealExternalId; }
    public void setDealExternalId(String v) { this.dealExternalId = v; }

    public String getDealName() { return dealName; }
    public void setDealName(String v) { this.dealName = v; }

    public String getReportName() { return reportName; }
    public void setReportName(String v) { this.reportName = v; }

    public BigDecimal getSpend() { return spend; }
    public void setSpend(BigDecimal v) { this.spend = v; }

    public Long getImpressions() { return impressions; }
    public void setImpressions(Long v) { this.impressions = v; }

    public BigDecimal getCpm() { return cpm; }
    public void setCpm(BigDecimal v) { this.cpm = v; }

    public LocalDate getReportDate() { return reportDate; }
    public void setReportDate(LocalDate v) { this.reportDate = v; }

    public BigDecimal getMediaCost() { return mediaCost; }
    public void setMediaCost(BigDecimal v) { this.mediaCost = v; }
    
    public BigDecimal getMediaMargin() { return mediaMargin; }
    public void setMediaMargin(BigDecimal v) { this.mediaMargin = v; }

    public BigDecimal getTechFee() {
        return techFee;
    }

    public BigDecimal getNetMediaCost() {
        return netMediaCost;
    }

    public void setNetMediaCost(BigDecimal netMediaCost) {
        this.netMediaCost = netMediaCost;
    }

    public void setTechFee(BigDecimal techFee) {
        this.techFee = techFee;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public BigDecimal getGrossMargin() {
        return grossMargin;
    }

    public void setGrossMargin(BigDecimal grossMargin) {
        this.grossMargin = grossMargin;
    }

    public BigDecimal getPartnerFee() { return partnerFee; }
    public void setPartnerFee(BigDecimal v) { this.partnerFee = v; }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZAMBRED
 */
@Entity
@Table(name = "tbl_raw_data", catalog = "rptdata", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRawData.findAll", query = "SELECT t FROM TblRawData t")
    , @NamedQuery(name = "TblRawData.findByIdraw", query = "SELECT t FROM TblRawData t WHERE t.idraw = :idraw")
    , @NamedQuery(name = "TblRawData.findByDDate", query = "SELECT t FROM TblRawData t WHERE t.dDate = :dDate")
    , @NamedQuery(name = "TblRawData.findByVPartner", query = "SELECT t FROM TblRawData t WHERE t.vPartner = :vPartner")
    , @NamedQuery(name = "TblRawData.findByVCampaign", query = "SELECT t FROM TblRawData t WHERE t.vCampaign = :vCampaign")
    , @NamedQuery(name = "TblRawData.findByVInsertionOrder", query = "SELECT t FROM TblRawData t WHERE t.vInsertionOrder = :vInsertionOrder")
    , @NamedQuery(name = "TblRawData.findByVLineItem", query = "SELECT t FROM TblRawData t WHERE t.vLineItem = :vLineItem")
    , @NamedQuery(name = "TblRawData.findByVExchange", query = "SELECT t FROM TblRawData t WHERE t.vExchange = :vExchange")
    , @NamedQuery(name = "TblRawData.findByVDealName", query = "SELECT t FROM TblRawData t WHERE t.vDealName = :vDealName")
    , @NamedQuery(name = "TblRawData.findByIImpressions", query = "SELECT t FROM TblRawData t WHERE t.iImpressions = :iImpressions")
    , @NamedQuery(name = "TblRawData.findByIClicks", query = "SELECT t FROM TblRawData t WHERE t.iClicks = :iClicks")
    , @NamedQuery(name = "TblRawData.findByDMediaCost", query = "SELECT t FROM TblRawData t WHERE t.dMediaCost = :dMediaCost")
    , @NamedQuery(name = "TblRawData.findByDTotalMediaCost", query = "SELECT t FROM TblRawData t WHERE t.dTotalMediaCost = :dTotalMediaCost")
    , @NamedQuery(name = "TblRawData.findByVDSP", query = "SELECT t FROM TblRawData t WHERE t.vDSP = :vDSP")
    , @NamedQuery(name = "TblRawData.findByVClient", query = "SELECT t FROM TblRawData t WHERE t.vClient = :vClient")
    , @NamedQuery(name = "TblRawData.findByVAgency", query = "SELECT t FROM TblRawData t WHERE t.vAgency = :vAgency")
    , @NamedQuery(name = "TblRawData.findByVChannel", query = "SELECT t FROM TblRawData t WHERE t.vChannel = :vChannel")
    , @NamedQuery(name = "TblRawData.findByVAlias", query = "SELECT t FROM TblRawData t WHERE t.vAlias = :vAlias")
    , @NamedQuery(name = "TblRawData.findByVVendor", query = "SELECT t FROM TblRawData t WHERE t.vVendor = :vVendor")
    , @NamedQuery(name = "TblRawData.findByVVendorSource", query = "SELECT t FROM TblRawData t WHERE t.vVendorSource = :vVendorSource")
    , @NamedQuery(name = "TblRawData.findByDCPM", query = "SELECT t FROM TblRawData t WHERE t.dCPM = :dCPM")
    , @NamedQuery(name = "TblRawData.findByDCTR", query = "SELECT t FROM TblRawData t WHERE t.dCTR = :dCTR")
    , @NamedQuery(name = "TblRawData.findByDCPC", query = "SELECT t FROM TblRawData t WHERE t.dCPC = :dCPC")
    , @NamedQuery(name = "TblRawData.findByIAnio", query = "SELECT t FROM TblRawData t WHERE t.iAnio = :iAnio")
    , @NamedQuery(name = "TblRawData.findByIMes", query = "SELECT t FROM TblRawData t WHERE t.iMes = :iMes")
    , @NamedQuery(name = "TblRawData.findByIDia", query = "SELECT t FROM TblRawData t WHERE t.iDia = :iDia")
    , @NamedQuery(name = "TblRawData.findByDSystemDate", query = "SELECT t FROM TblRawData t WHERE t.dSystemDate = :dSystemDate")
    , @NamedQuery(name = "TblRawData.findByVFileName", query = "SELECT t FROM TblRawData t WHERE t.vFileName = :vFileName")
    , @NamedQuery(name = "TblRawData.findByTEstado", query = "SELECT t FROM TblRawData t WHERE t.tEstado = :tEstado")})
public class TblRawData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_raw")
    private Integer idraw;
    @Column(name = "dDate")
    @Temporal(TemporalType.DATE)
    private Date dDate;
    @Size(max = 100)
    @Column(name = "vPartner")
    private String vPartner;
    @Size(max = 100)
    @Column(name = "vCampaign")
    private String vCampaign;
    @Size(max = 150)
    @Column(name = "vInsertionOrder")
    private String vInsertionOrder;
    @Size(max = 150)
    @Column(name = "vLineItem")
    private String vLineItem;
    @Size(max = 150)
    @Column(name = "vExchange")
    private String vExchange;
    @Size(max = 150)
    @Column(name = "vDealName")
    private String vDealName;
    @Column(name = "iImpressions")
    private Integer iImpressions;
    @Column(name = "iClicks")
    private Integer iClicks;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "dMediaCost")
    private Double dMediaCost;
    @Column(name = "dTotalMediaCost")
    private Double dTotalMediaCost;
    @Size(max = 25)
    @Column(name = "vDSP")
    private String vDSP;
    @Size(max = 50)
    @Column(name = "vClient")
    private String vClient;
    @Size(max = 50)
    @Column(name = "vAgency")
    private String vAgency;
    @Size(max = 50)
    @Column(name = "vChannel")
    private String vChannel;
    @Size(max = 25)
    @Column(name = "vAlias")
    private String vAlias;
    @Size(max = 50)
    @Column(name = "vVendor")
    private String vVendor;
    @Size(max = 25)
    @Column(name = "vVendorSource")
    private String vVendorSource;
    @Column(name = "dCPM")
    private Double dCPM;
    @Column(name = "dCTR")
    private Double dCTR;
    @Column(name = "dCPC")
    private Double dCPC;
    @Column(name = "iAnio")
    private Short iAnio;
    @Column(name = "iMes")
    private Short iMes;
    @Column(name = "iDia")
    private Short iDia;
    @Column(name = "dSystemDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dSystemDate;
    @Size(max = 100)
    @Column(name = "vFileName")
    private String vFileName;
    @Column(name = "tEstado")
    private Boolean tEstado;

    public TblRawData() {
    }

    public TblRawData(Integer idraw) {
        this.idraw = idraw;
    }

    public Integer getIdraw() {
        return idraw;
    }

    public void setIdraw(Integer idraw) {
        this.idraw = idraw;
    }

    public Date getDDate() {
        return dDate;
    }

    public void setDDate(Date dDate) {
        this.dDate = dDate;
    }

    public String getVPartner() {
        return vPartner;
    }

    public void setVPartner(String vPartner) {
        this.vPartner = vPartner;
    }

    public String getVCampaign() {
        return vCampaign;
    }

    public void setVCampaign(String vCampaign) {
        this.vCampaign = vCampaign;
    }

    public String getVInsertionOrder() {
        return vInsertionOrder;
    }

    public void setVInsertionOrder(String vInsertionOrder) {
        this.vInsertionOrder = vInsertionOrder;
    }

    public String getVLineItem() {
        return vLineItem;
    }

    public void setVLineItem(String vLineItem) {
        this.vLineItem = vLineItem;
    }

    public String getVExchange() {
        return vExchange;
    }

    public void setVExchange(String vExchange) {
        this.vExchange = vExchange;
    }

    public String getVDealName() {
        return vDealName;
    }

    public void setVDealName(String vDealName) {
        this.vDealName = vDealName;
    }

    public Integer getIImpressions() {
        return iImpressions;
    }

    public void setIImpressions(Integer iImpressions) {
        this.iImpressions = iImpressions;
    }

    public Integer getIClicks() {
        return iClicks;
    }

    public void setIClicks(Integer iClicks) {
        this.iClicks = iClicks;
    }

    public Double getDMediaCost() {
        return dMediaCost;
    }

    public void setDMediaCost(Double dMediaCost) {
        this.dMediaCost = dMediaCost;
    }

    public Double getDTotalMediaCost() {
        return dTotalMediaCost;
    }

    public void setDTotalMediaCost(Double dTotalMediaCost) {
        this.dTotalMediaCost = dTotalMediaCost;
    }

    public String getVDSP() {
        return vDSP;
    }

    public void setVDSP(String vDSP) {
        this.vDSP = vDSP;
    }

    public String getVClient() {
        return vClient;
    }

    public void setVClient(String vClient) {
        this.vClient = vClient;
    }

    public String getVAgency() {
        return vAgency;
    }

    public void setVAgency(String vAgency) {
        this.vAgency = vAgency;
    }

    public String getVChannel() {
        return vChannel;
    }

    public void setVChannel(String vChannel) {
        this.vChannel = vChannel;
    }

    public String getVAlias() {
        return vAlias;
    }

    public void setVAlias(String vAlias) {
        this.vAlias = vAlias;
    }

    public String getVVendor() {
        return vVendor;
    }

    public void setVVendor(String vVendor) {
        this.vVendor = vVendor;
    }

    public String getVVendorSource() {
        return vVendorSource;
    }

    public void setVVendorSource(String vVendorSource) {
        this.vVendorSource = vVendorSource;
    }

    public Double getDCPM() {
        return dCPM;
    }

    public void setDCPM(Double dCPM) {
        this.dCPM = dCPM;
    }

    public Double getDCTR() {
        return dCTR;
    }

    public void setDCTR(Double dCTR) {
        this.dCTR = dCTR;
    }

    public Double getDCPC() {
        return dCPC;
    }

    public void setDCPC(Double dCPC) {
        this.dCPC = dCPC;
    }

    public Short getIAnio() {
        return iAnio;
    }

    public void setIAnio(Short iAnio) {
        this.iAnio = iAnio;
    }

    public Short getIMes() {
        return iMes;
    }

    public void setIMes(Short iMes) {
        this.iMes = iMes;
    }

    public Short getIDia() {
        return iDia;
    }

    public void setIDia(Short iDia) {
        this.iDia = iDia;
    }

    public Date getDSystemDate() {
        return dSystemDate;
    }

    public void setDSystemDate(Date dSystemDate) {
        this.dSystemDate = dSystemDate;
    }

    public String getVFileName() {
        return vFileName;
    }

    public void setVFileName(String vFileName) {
        this.vFileName = vFileName;
    }

    public Boolean getTEstado() {
        return tEstado;
    }

    public void setTEstado(Boolean tEstado) {
        this.tEstado = tEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idraw != null ? idraw.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRawData)) {
            return false;
        }
        TblRawData other = (TblRawData) object;
        if ((this.idraw == null && other.idraw != null) || (this.idraw != null && !this.idraw.equals(other.idraw))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dp.controller.TblRawData[ idraw=" + idraw + " ]";
    }
    
}

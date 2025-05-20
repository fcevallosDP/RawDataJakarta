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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZAMBRED
 */
@Entity
@Table(name = "tbl_type_sources", catalog = "rptdata", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTypeSources.findAll", query = "SELECT t FROM TblTypeSources t")
    , @NamedQuery(name = "TblTypeSources.findById", query = "SELECT t FROM TblTypeSources t WHERE t.id = :id")
    , @NamedQuery(name = "TblTypeSources.findByVSource", query = "SELECT t FROM TblTypeSources t WHERE t.vSource = :vSource")
    , @NamedQuery(name = "TblTypeSources.findByVType", query = "SELECT t FROM TblTypeSources t WHERE t.vType = :vType")
    , @NamedQuery(name = "TblTypeSources.findByDSystemDate", query = "SELECT t FROM TblTypeSources t WHERE t.dSystemDate = :dSystemDate")
    , @NamedQuery(name = "TblTypeSources.findByIEstado", query = "SELECT t FROM TblTypeSources t WHERE t.iEstado = :iEstado")})
public class TblTypeSources implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vSource")
    @Size(max = 1)
    private String vSource;
    @Size(max = 10)
    @Column(name = "vType")
    private String vType;
    @Column(name = "dSystemDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dSystemDate;
    @Column(name = "iEstado")
    private Boolean iEstado;

    public TblTypeSources() {
    }

    public TblTypeSources(Integer id) {
        this.id = id;
    }

    public TblTypeSources(Integer id, String vSource) {
        this.id = id;
        this.vSource = vSource;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVSource() {
        return vSource;
    }

    public void setVSource(String vSource) {
        this.vSource = vSource;
    }

    public String getVType() {
        return vType;
    }

    public void setVType(String vType) {
        this.vType = vType;
    }

    public Date getDSystemDate() {
        return dSystemDate;
    }

    public void setDSystemDate(Date dSystemDate) {
        this.dSystemDate = dSystemDate;
    }

    public Boolean getIEstado() {
        return iEstado;
    }

    public void setIEstado(Boolean iEstado) {
        this.iEstado = iEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTypeSources)) {
            return false;
        }
        TblTypeSources other = (TblTypeSources) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dp.entity.TblTypeSources[ id=" + id + " ]";
    }
    
}

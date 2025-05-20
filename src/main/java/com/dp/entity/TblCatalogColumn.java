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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tbl_catalog_column", catalog = "rptdata", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCatalogColumn.findAll", query = "SELECT t FROM TblCatalogColumn t")
    , @NamedQuery(name = "TblCatalogColumn.findById", query = "SELECT t FROM TblCatalogColumn t WHERE t.id = :id")
    , @NamedQuery(name = "TblCatalogColumn.findByVSource", query = "SELECT t FROM TblCatalogColumn t WHERE t.vSource = :vSource")
    , @NamedQuery(name = "TblCatalogColumn.findByVCategory", query = "SELECT t FROM TblCatalogColumn t WHERE t.vCategory = :vCategory")
    , @NamedQuery(name = "TblCatalogColumn.findByVColumnName", query = "SELECT t FROM TblCatalogColumn t WHERE t.vColumnName = :vColumnName")
    , @NamedQuery(name = "TblCatalogColumn.findByIOrder", query = "SELECT t FROM TblCatalogColumn t WHERE t.iOrder = :iOrder")
    , @NamedQuery(name = "TblCatalogColumn.findByDSystemDate", query = "SELECT t FROM TblCatalogColumn t WHERE t.dSystemDate = :dSystemDate")
    , @NamedQuery(name = "TblCatalogColumn.findByIEstado", query = "SELECT t FROM TblCatalogColumn t WHERE t.iEstado = :iEstado")
    , @NamedQuery(name = "TblCatalogColumn.findByVSourceVCategory", query = "SELECT t.vColumnName FROM TblCatalogColumn t WHERE t.vSource = :vSource and t.vCategory = :vCategory and t.iEstado = :iEstado order by t.iOrder")})
public class TblCatalogColumn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "vColumnName")
    private String vColumnName;
    @Column(name = "iOrder")
    private Short iOrder;
    @Column(name = "dSystemDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dSystemDate;
    @Column(name = "iEstado")
    private Boolean iEstado;
    @JoinColumn(name = "id_catalog", referencedColumnName = "id")
    @ManyToOne
    private TblCatalog idCatalog;
    
    public TblCatalogColumn() {
    }

    public TblCatalogColumn(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TblCatalog getIdCatalog() {
        return idCatalog;
    }

    public void setIdCatalog(TblCatalog idCatalog) {
        this.idCatalog = idCatalog;
    }

    public String getVColumnName() {
        return vColumnName;
    }

    public void setVColumnName(String vColumnName) {
        this.vColumnName = vColumnName;
    }

    public Short getIOrder() {
        return iOrder;
    }

    public void setIOrder(Short iOrder) {
        this.iOrder = iOrder;
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
        if (!(object instanceof TblCatalogColumn)) {
            return false;
        }
        TblCatalogColumn other = (TblCatalogColumn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dp.entity.TblCatalogColumn[ id=" + id + " ]";
    }
    
}

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
public class TblCatalogoColumn {
    private Integer id;
    private Integer idCatalog;
    private String vSource;
    private String vCategory;
    private String vColumnName;
    private Short iOrder;    

    public Integer getId() {
        return id;
    }

    public Integer getIdCatalog() {
        return idCatalog;
    }

    public void setIdCatalog(Integer idCatalog) {
        this.idCatalog = idCatalog;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getvSource() {
        return vSource;
    }

    public void setvSource(String vSource) {
        this.vSource = vSource;
    }

    public String getvCategory() {
        return vCategory;
    }

    public void setvCategory(String vCategory) {
        this.vCategory = vCategory;
    }

    public String getvColumnName() {
        return vColumnName;
    }

    public void setvColumnName(String vColumnName) {
        this.vColumnName = vColumnName;
    }

    public Short getiOrder() {
        return iOrder;
    }

    public void setiOrder(Short iOrder) {
        this.iOrder = iOrder;
    }
    
    
}

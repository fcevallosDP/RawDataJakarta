/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.util;

import java.util.List;

/**
 *
 * @author ZAMBRED
 */
public class TblCatalogo {
    private Integer id;
    private String vSource;  
    private String vType;
    private String vValue;
    private String vPattern;
    private List<TblCatalogoColumn> tblCatalogColumnList;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getvSource() {
        return vSource;
    }

    public List<TblCatalogoColumn> getTblCatalogColumnList() {
        return tblCatalogColumnList;
    }

    public void setTblCatalogColumnList(List<TblCatalogoColumn> tblCatalogColumnList) {
        this.tblCatalogColumnList = tblCatalogColumnList;
    }

    public void setvSource(String vSource) {
        this.vSource = vSource;
    }

    public String getvType() {
        return vType;
    }

    public void setvType(String vType) {
        this.vType = vType;
    }

    public String getvValue() {
        return vValue;
    }

    public void setvValue(String vValue) {
        this.vValue = vValue;
    }

    public String getvPattern() {
        return vPattern;
    }

    public void setvPattern(String vPattern) {
        this.vPattern = vPattern;
    }
    
}

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
public class TblLineItems {
    private Integer id;
    private String vInsertionOrder;
    private String vLineItem;
    private Double dSpendYesterday;

    public String getvLineItem() {
        return vLineItem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getvInsertionOrder() {
        return vInsertionOrder;
    }

    public void setvInsertionOrder(String vInsertionOrder) {
        this.vInsertionOrder = vInsertionOrder;
    }

    public void setvLineItem(String vLineItem) {
        this.vLineItem = vLineItem;
    }

    public Double getdSpendYesterday() {
        return dSpendYesterday;
    }

    public void setdSpendYesterday(Double dSpendYesterday) {
        this.dSpendYesterday = dSpendYesterday;
    }
    
}

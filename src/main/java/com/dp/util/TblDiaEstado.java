/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dp.util;

/**
 *
 * @author ZAMBRED
 */
public class TblDiaEstado {
    private Integer iDia;
    private String vEstado;

    
    public TblDiaEstado(int dia, String estado) {
        this.iDia = dia;
        this.vEstado = estado;
    }    
    
    public Integer getiDia() {
        return iDia;
    }

    public void setiDia(Integer iDia) {
        this.iDia = iDia;
    }

    public String getvEstado() {
        return vEstado;
    }

    public void setvEstado(String vEstado) {
        this.vEstado = vEstado;
    }
        
}

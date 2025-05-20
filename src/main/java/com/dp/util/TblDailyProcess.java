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
public class TblDailyProcess {
    private Integer id_daily;
    private Integer iYear;
    private Integer iMonth;
    private Integer iDay;
    private Date dDate;
    private String vDate;
    private TblProcessStatus iStatusProcess;
    private Integer iQuarter;
    private Integer iWeek;
    private String vDayName;
    private String vMonthName;
    private Boolean iSHoliday;
    private Boolean iSWeekend;
    
    public TblDailyProcess(){

    }
    
    public TblDailyProcess(Integer iYear, Integer iMonth, Integer iDay, String lsDate){
        this.id_daily = 0;
        this.iYear = iYear;
        this.iMonth = iMonth;
        this.iDay = iDay;
        this.vDate = lsDate;
    }

    public String getVDate() {
        return vDate;
    }

    public void setVDate(String vDate) {
        this.vDate = vDate;
    }

    public Integer getId_daily() {
        return id_daily;
    }

    public void setId_daily(Integer id_daily) {
        this.id_daily = id_daily;
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

    public Integer getiDay() {
        return iDay;
    }

    public void setiDay(Integer iDay) {
        this.iDay = iDay;
    }

    public Date getdDate() {
        return dDate;
    }

    public void setdDate(Date dDate) {
        this.dDate = dDate;
    }

    public TblProcessStatus getiStatusProcess() {
        return iStatusProcess;
    }

    public void setiStatusProcess(TblProcessStatus iStatusProcess) {
        this.iStatusProcess = iStatusProcess;
    }

    public Integer getiQuarter() {
        return iQuarter;
    }

    public void setiQuarter(Integer iQuarter) {
        this.iQuarter = iQuarter;
    }

    public Integer getiWeek() {
        return iWeek;
    }

    public void setiWeek(Integer iWeek) {
        this.iWeek = iWeek;
    }

    public String getvDayName() {
        return vDayName;
    }

    public void setvDayName(String vDayName) {
        this.vDayName = vDayName;
    }

    public String getvMonthName() {
        return vMonthName;
    }

    public void setvMonthName(String vMonthName) {
        this.vMonthName = vMonthName;
    }

    public Boolean getiSHoliday() {
        return iSHoliday;
    }

    public void setiSHoliday(Boolean iSHoliday) {
        this.iSHoliday = iSHoliday;
    }

    public Boolean getiSWeekend() {
        return iSWeekend;
    }

    public void setiSWeekend(Boolean iSWeekend) {
        this.iSWeekend = iSWeekend;
    }        
}

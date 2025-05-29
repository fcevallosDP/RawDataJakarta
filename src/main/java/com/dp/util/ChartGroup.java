/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dp.util;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author ZAMBRED
 */
public class ChartGroup {
    private String metricName;              // Ej: "CPM", "CTR", "VCR"
    private List<String> chartIds;          // Lista de canvasId correspondientes

    public ChartGroup() {
    }

    public ChartGroup(String metricName, List<String> chartIds) {
        this.metricName = metricName;
        this.chartIds = chartIds;
    }

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public List<String> getChartIds() {
        return chartIds;
    }

    public void setChartIds(List<String> chartIds) {
        this.chartIds = chartIds;
    }    
}

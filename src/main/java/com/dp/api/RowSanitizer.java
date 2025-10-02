/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dp.api;

/**
 *
 * @author ZAMBRED
 */
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class RowSanitizer {

    public static List<RowDto> sanitize(List<RowDto> rows) {
        return rows.stream()
            .map(RowSanitizer::sanitizeRow)
            .collect(Collectors.toList());
    }

    private static RowDto sanitizeRow(RowDto r) {
        if (r == null) return null;

        // enteros
        if (r.getImpressions() == null) r.setImpressions(0L);

        // decimales
        if (r.getSpend() == null) r.setSpend(BigDecimal.ZERO);
        if (r.getCpm() == null) r.setCpm(BigDecimal.ZERO);
        if (r.getMediaCost() == null) r.setMediaCost(BigDecimal.ZERO);
        if (r.getMediaMargin() == null) r.setMediaMargin(BigDecimal.ZERO);
        if (r.getGrossMargin() == null) r.setGrossMargin(BigDecimal.ZERO);
        if (r.getPartnerFee() == null) r.setPartnerFee(BigDecimal.ZERO);
        if (r.getTechFee() == null) r.setTechFee(BigDecimal.ZERO);
        if (r.getNetMediaCost() == null) r.setNetMediaCost(BigDecimal.ZERO);
        if (r.getTotalCost() == null) r.setTotalCost(BigDecimal.ZERO);

        return r;
    }
}
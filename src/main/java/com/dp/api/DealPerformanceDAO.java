/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dp.api;

/**
 *
 * @author ZAMBRED
 */
import com.dp.util.DatabaseConnector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class DealPerformanceDAO {

    /**
     * Inserta en lote las filas normalizadas enviadas por Python.
     * Ajusta la tabla y columnas a tu esquema real.
     */

	public int bulkInsert(String source, List<Map<String, Object>> rows) {
		System.out.println(">>> [TEST] bulkInsert llamado con source=" + source);
		System.out.println(">>> [TEST] rows=" + rows);
		return rows.size();
	}
    
    
    /*
    public int bulkInsert(String source, List<Map<String, Object>> rows) {
        if (rows == null || rows.isEmpty()) return 0;

        final String SQL = """
            INSERT INTO deal_performance
              (source, deal_id, event_date, impressions, spend, revenue)
            VALUES (?, ?, ?, ?, ?, ?)
            """;
        // Si vas a evitar duplicados por (source, deal_id, event_date):
        // 1) Crea UNIQUE KEY uq_source_deal_date (source, deal_id, event_date)
        // 2) Usa:
        // final String SQL = """
        //   INSERT INTO deal_performance (source, deal_id, event_date, impressions, spend, revenue)
        //   VALUES (?, ?, ?, ?, ?, ?)
        //   ON DUPLICATE KEY UPDATE
        //     impressions = VALUES(impressions),
        //     spend       = VALUES(spend),
        //     revenue     = VALUES(revenue)
        // """;

        int total = 0;

        try (Connection connect = DatabaseConnector.getConnection();
             PreparedStatement pstmt = connect.prepareStatement(SQL)) {

            connect.setAutoCommit(false);

            for (Map<String, Object> row : rows) {
                // Si diferentes sources traen claves distintas, usa un switch(source) aquí
                String dealId      = asString(row.get("deal_id"));
                Date   eventDate   = asSqlDate(row.get("date"));           // espera "YYYY-MM-DD"
                Long   impressions = asLong(row.get("impressions"));
                Double spend       = asDouble(row.get("spend"));
                Double revenue     = asDouble(row.get("revenue"));

                // bind params
                setStringOrNull(pstmt, 1, source);
                setStringOrNull(pstmt, 2, dealId);
                setDateOrNull  (pstmt, 3, eventDate);
                setLongOrNull  (pstmt, 4, impressions);
                setDoubleOrNull(pstmt, 5, spend);
                setDoubleOrNull(pstmt, 6, revenue);

                pstmt.addBatch();
                total++;
            }

            pstmt.executeBatch();
            connect.commit();
            return total;

        } catch (Exception ex) {
            ex.printStackTrace();
            // Si falla, haz rollback seguro
            try {
                // Si la conexión está cerrada, este bloque será ignorado
                DatabaseConnector.getConnection().rollback();
            } catch (Exception ignore) {}
            return 0;
        }
    }
    */

    // ===== helpers de casteo =====
    private static String asString(Object v) {
        return (v == null) ? null : String.valueOf(v);
    }

    private static Long asLong(Object v) {
        if (v == null) return null;
        if (v instanceof Number n) return n.longValue();
        return Long.parseLong(v.toString());
    }

    private static Double asDouble(Object v) {
        if (v == null) return null;
        if (v instanceof Number n) return n.doubleValue();
        return Double.parseDouble(v.toString());
    }

    private static Date asSqlDate(Object v) {
        if (v == null) return null;
        // Ajusta si algún source te manda otro formato
        LocalDate d = LocalDate.parse(v.toString()); // "YYYY-MM-DD"
        return Date.valueOf(d);
    }

    // ===== helpers para setear nullables =====
    private static void setStringOrNull(PreparedStatement ps, int idx, String v) throws Exception {
        if (v == null) ps.setNull(idx, Types.VARCHAR); else ps.setString(idx, v);
    }
    private static void setLongOrNull(PreparedStatement ps, int idx, Long v) throws Exception {
        if (v == null) ps.setNull(idx, Types.BIGINT); else ps.setLong(idx, v);
    }
    private static void setDoubleOrNull(PreparedStatement ps, int idx, Double v) throws Exception {
        if (v == null) ps.setNull(idx, Types.DOUBLE); else ps.setDouble(idx, v);
    }
    private static void setDateOrNull(PreparedStatement ps, int idx, Date v) throws Exception {
        if (v == null) ps.setNull(idx, Types.DATE); else ps.setDate(idx, v);
    }
}
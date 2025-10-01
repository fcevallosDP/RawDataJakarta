/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dp.api;

/**
 *
 * @author ZAMBRED
 */
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

public class IngestRequest {
    @NotBlank
    private String source;

    @NotNull
    private List<RowDto> rows;

    // opcional
    private Long sent_at;

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public List<RowDto> getRows() { return rows; }
    public void setRows(List<RowDto> rows) { this.rows = rows; }

    public Long getSent_at() { return sent_at; }
    public void setSent_at(Long sent_at) { this.sent_at = sent_at; }
}
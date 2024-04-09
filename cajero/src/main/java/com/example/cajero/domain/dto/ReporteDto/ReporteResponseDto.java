package com.example.cajero.domain.dto.ReporteDto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ReporteResponseDto {
    private LocalDate fecha;
    private String cliente;
    private String numerocuenta;
    private String tipo;
    private double saldoinicial;
    private String estado;
    private double movimiento;
    private double saldodisponible;
}

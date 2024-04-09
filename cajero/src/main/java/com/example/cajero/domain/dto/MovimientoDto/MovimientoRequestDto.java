package com.example.cajero.domain.dto.MovimientoDto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class MovimientoRequestDto {
    private Long id_cuenta;
    private LocalDate fecha;
    private String tipo_movimiento;
    private double valor;
    private double saldo;
}

package com.example.cajero.domain.dto.MovimientoDto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Data
public class MovimientoResponseDto {
    private Long id;
    private Long id_cuenta;
    private LocalDate fecha;
    private String tipo_movimiento;
    private double valor;
    private double saldo;

    public MovimientoResponseDto(Long id, Long id_cuenta, LocalDate fecha, String tipo_movimiento, double valor, double saldo) {
        this.id = id;
        this.id_cuenta = id_cuenta;
        this.fecha = fecha;
        this.tipo_movimiento = tipo_movimiento;
        this.valor = valor;
        this.saldo = saldo;
    }


}

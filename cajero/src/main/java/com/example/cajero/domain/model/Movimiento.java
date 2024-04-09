package com.example.cajero.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Date;

@Table(name = "movimiento")
@Getter
@Setter
@NoArgsConstructor
public class Movimiento {
    @Id
    private Long id;
    private Long id_cuenta;
    private LocalDate fecha;
    private String tipo_movimiento;
    private double valor;
    private double saldo;

    public Movimiento(Long id, Long id_cuenta, LocalDate fecha, String tipo_movimiento, double valor, double saldo) {
        this.id = id;
        this.id_cuenta = id_cuenta;
        this.fecha = fecha;
        this.tipo_movimiento = tipo_movimiento;
        this.valor = valor;
        this.saldo = saldo;
    }

    public Movimiento(Long id_cuenta, LocalDate fecha, String tipo_movimiento, double valor, double saldo) {
        this.id_cuenta = id_cuenta;
        this.fecha = fecha;
        this.tipo_movimiento = tipo_movimiento;
        this.valor = valor;
        this.saldo = saldo;
    }
}

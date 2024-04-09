package com.example.cajero.domain.dto.CuentaDto;

import lombok.Data;

@Data
public class CuentaResponseDto {
    private Long id;
    private String numero_cuenta;
    private String tipo_cuenta;
    private double saldo_inicial;
    private String estado;
    private Long id_cliente;

    public CuentaResponseDto(Long id, String numero_cuenta, String tipo_cuenta, double saldo_inicial, String estado, Long id_cliente) {
        this.id = id;
        this.numero_cuenta = numero_cuenta;
        this.tipo_cuenta = tipo_cuenta;
        this.saldo_inicial = saldo_inicial;
        this.estado = estado;
        this.id_cliente = id_cliente;
    }
}

package com.example.cajero.domain.dto.CuentaDto;

import lombok.Data;

@Data
public class CuentaRequestDto {
    private String numero_cuenta;
    private String tipo_cuenta;
    private double saldo_inicial;
    private String estado;
    private Long id_cliente;
}
